package com.airton.desafionetprecision.resource;

import com.airton.desafionetprecision.dto.OrderDTO;
import com.airton.desafionetprecision.dto.ProductQuantityDTO;
import com.airton.desafionetprecision.entities.Order;
import com.airton.desafionetprecision.mapper.OrderMapper;
import com.airton.desafionetprecision.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> order = orderService.findAll();

        return ResponseEntity.ok().body(order);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> toCreate(OrderDTO  dto){
        OrderDTO orderDTO = orderService.toCreate(dto);
        return ResponseEntity.ok().body(orderDTO);
    }

    @PostMapping("add-product/{id}")
    public ResponseEntity<OrderDTO> insertProduct(@PathVariable Long id, @RequestBody List<ProductQuantityDTO> products){
        OrderDTO order = orderService.insert(id, products);
        return ResponseEntity.ok().body(order);
    }

    @DeleteMapping("remove-product/{id}")
    public ResponseEntity<OrderDTO> removeProduct(@PathVariable Long id, @RequestBody List<ProductQuantityDTO> products) throws Exception {
        OrderDTO order = orderService.remove_product(id, products);
        return ResponseEntity.ok().body(order);
    }


}
