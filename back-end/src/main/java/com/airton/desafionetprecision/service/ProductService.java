package com.airton.desafionetprecision.service;

import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.entities.Product;
import com.airton.desafionetprecision.mapper.ProductMapper;
import com.airton.desafionetprecision.repositories.ProductRepository;
import com.airton.desafionetprecision.utils.AnexoUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll(){
        return ProductMapper.INSTANCE.toListDTO(productRepository.findAll());
    }

    public ProductDTO save(ProductDTO productDTO) throws Exception {

        String nomeUnicoArquivo = AnexoUtils.salvarImagem(productDTO);
        productDTO.setImageName(nomeUnicoArquivo);

        Product prod = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDTO(productRepository.save(prod));
    }




}
