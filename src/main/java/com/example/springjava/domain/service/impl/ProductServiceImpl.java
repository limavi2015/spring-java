package com.example.springjava.domain.service.impl;

import com.example.springjava.controller.dto.ProductDTO;
import com.example.springjava.domain.builder.ObjectBuilder;
import com.example.springjava.domain.builder.ProcuctBuilder;
import com.example.springjava.domain.entity.Product;
import com.example.springjava.domain.repository.ProductRepository;
import com.example.springjava.domain.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import io.vavr.control.Try;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectBuilder objectBuilder;

    @Override
    public List<ProductDTO> getProducts(){
        return objectBuilder.mapAll(productRepository.findAll(), ProductDTO.class);
    }

    @Override
    @Transactional(rollbackFor = {DataException.class, Exception.class}, propagation = Propagation.REQUIRED)
    public String createProduct(ProductDTO productDTO) {
        Try<Product> value = Try.of(() -> {
            return productRepository.save(ProcuctBuilder.mapObject(productDTO));
        });
        return Match(value).of(
                Case($Success($()), "Producto guardado sarisfactoriamente"),
                Case($Failure($()), e-> "Error al guardar producto " +  e.getMessage())
        );
    }

}
