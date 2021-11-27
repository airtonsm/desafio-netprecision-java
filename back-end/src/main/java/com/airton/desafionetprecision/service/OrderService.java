package com.airton.desafionetprecision.service;

import com.airton.desafionetprecision.dto.OrderDTO;
import com.airton.desafionetprecision.dto.ProductQuantityDTO;
import com.airton.desafionetprecision.entities.Order;
import com.airton.desafionetprecision.entities.OrderProduct;
import com.airton.desafionetprecision.mapper.OrderMapper;
import com.airton.desafionetprecision.repositories.OrderRepository;
import com.airton.desafionetprecision.repositories.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<OrderDTO> findAll(){
        List<OrderDTO> listorder = OrderMapper.INSTANCE.toListDTO(orderRepository.findAll());
        for(OrderDTO order : listorder){
            order.calcPrice();
        }
        return listorder;
    }

    public OrderDTO toCreate(OrderDTO orderDTO){
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);

        return OrderMapper.INSTANCE.toDTO(orderRepository.save(order));
    }

    public OrderDTO insert (Long id, List<ProductQuantityDTO> products){
        Order order = orderRepository.getById(id);

        for (ProductQuantityDTO product : products) {
            Integer productIndex = order.findProductIndex(product.getId());
            Integer quantity = product.getQuantity().equals(0) ? 1 : product.getQuantity();
            if(productIndex == -1){
                order.getProducts().add(
                        new OrderProduct(order, productRepository.getById(Math.toIntExact(Long.valueOf(product.getId()))), quantity));
            }else{
                order.getProducts().get(productIndex).addQuantity(quantity);
            }
        }
        return OrderMapper.INSTANCE.toDTO(orderRepository.save(order));
    }

    public OrderDTO remove_product(Long id, List<ProductQuantityDTO> products) throws Exception{
        Order order = orderRepository.getById(id);

        for (ProductQuantityDTO product: products) {
            Integer productIndex = order.findProductIndex(product.getId());
            Integer quantity = product.getQuantity().equals(0) ? 1 : product.getQuantity();

            if(productIndex != -1){
                order.getProducts().get(productIndex).removeQuantity(quantity);
                if(order.getProducts().get(productIndex).getQuantity() <= 0){
                    order.getProducts().remove(productIndex.intValue());
                }
            }else{
                throw new NotFoundException("Product with id:" + product.getId() +"not found in order with id: " + order.getId() + ".");
            }
        }
        return OrderMapper.INSTANCE.toDTO(orderRepository.save(order));
    }





}
