package com.airton.desafionetprecision.mapper;

import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.entities.Product;
import com.airton.desafionetprecision.utils.AnexoUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);



    ProductDTO toDTO(Product p);

    Product toEntity(ProductDTO dto);

    List<ProductDTO> toListDTO(List<Product> productList);

    @AfterMapping
    default void afterToDTO(Product product, @MappingTarget ProductDTO dto)  {
            if (StringUtils.isNotBlank(product.getImageName())) {
                dto.setBase64(AnexoUtils.toBase64(product.getImageName()));
            }
    }



}
