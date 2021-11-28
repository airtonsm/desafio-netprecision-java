package com.airton.desafionetprecision.mapper;

import com.airton.desafionetprecision.dto.OrderDTO;
import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.entities.Order;
import com.airton.desafionetprecision.entities.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    default OrderDTO toDTO(Order entity){
        OrderDTO  orderDTO = new OrderDTO();

        orderDTO.setId(entity.getId());
        orderDTO.setMoment(entity.getMoment());

        for (OrderProduct ord : entity.getProducts()){
            ProductDTO pdto = ProductMapper.INSTANCE.toDTO(ord.getProduct());
            pdto.setQuantity(ord.getQuantity());
            orderDTO.setProductQuantity(orderDTO.getProductQuantity() + ord.getQuantity());
            orderDTO.getProducts().add(pdto);
        }
        return orderDTO;
    };


    Order toEntity(OrderDTO oDTO);

    default List<OrderDTO> toListDTO(List<Order> listEntity){
        List<OrderDTO> listDto = new ArrayList<>();
        for (Order order: listEntity) {
            listDto.add(toDTO(order));
        }
        return listDto;
    };


}
