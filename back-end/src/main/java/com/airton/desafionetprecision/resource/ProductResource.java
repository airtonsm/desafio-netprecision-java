package com.airton.desafionetprecision.resource;

import com.airton.desafionetprecision.dto.ProductDTO;
import com.airton.desafionetprecision.exception.GlobalExceptionHandler;
import com.airton.desafionetprecision.service.ProductService;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:8000")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> listDTO = productService.findAll();
        return ResponseEntity.ok().body(listDTO);
    }

    ProductDTO productDTO = new ProductDTO();
    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody  ProductDTO dto) throws GlobalExceptionHandler, Exception {
        productDTO= productService.save(dto);
        if(productDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
        }else{
            throw new GlobalExceptionHandler();
        }
    }



}
