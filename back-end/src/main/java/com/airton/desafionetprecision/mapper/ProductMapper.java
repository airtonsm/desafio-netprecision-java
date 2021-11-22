package com.airton.desafionetprecision.mapper;

import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product p);

    List<ProductDTO> toListDTO(List<Product> productList);

}
