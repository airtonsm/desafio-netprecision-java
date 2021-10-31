package com.airton.desafionetprecision.service;

import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.mapper.ProductMapper;
import com.airton.desafionetprecision.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll(){
        return ProductMapper.INSTANCE.toListDTO(productRepository.findAll());
    }

}
