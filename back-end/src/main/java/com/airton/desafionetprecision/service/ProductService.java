package com.airton.desafionetprecision.service;

import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.entities.Product;
import com.airton.desafionetprecision.mapper.ProductMapper;
import com.airton.desafionetprecision.repositories.ProductRepository;
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

    private static final String REGEX_BASE_64_PREFIX = "data.+base64,";
    private static final String DIRETORIO_IMAGENS = "C:\\Users\\PC show\\Documents\\PROGRAMAÇÃO\\Full Stack\\desafio-netprecision\\back-end\\src\\main\\resources\\templates\\img\\";

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll(){
        return ProductMapper.INSTANCE.toListDTO(productRepository.findAll());
    }

    public ProductDTO save(ProductDTO productDTO) throws Exception {

        String nomeUnicoArquivo = salvarImagem(productDTO);
        productDTO.setImageName(nomeUnicoArquivo);

        Product prod = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDTO(productRepository.save(prod));
    }



    private String salvarImagem(ProductDTO productDTO) throws Exception {
        String nomeArquivo = productDTO.getImageName();

        if (StringUtils.isNotBlank(nomeArquivo)) {
            String nomeUnicoArquivo = UUID.randomUUID().toString() + "_" + nomeArquivo;
            String arquivoComDiretorio = FilenameUtils.normalize(DIRETORIO_IMAGENS + nomeUnicoArquivo);

            salvarAnexoBase64(arquivoComDiretorio, productDTO.getBase64());
            return nomeUnicoArquivo;
        }

        throw new IllegalArgumentException("Nome do anexo não poder vazio ou nulo.");
    }

    private void salvarAnexoBase64(String caminho, String base64) throws Exception {
        try {
            String arquivoBase64 = base64.replaceAll(REGEX_BASE_64_PREFIX, "");
            byte[] decode = Base64.decode(arquivoBase64);
            Path path = Paths.get(caminho);

            Files.write(path, decode);

        } catch (IOException e) {
            throw e;
        }
    }
}
