package com.example.springjava.domain.builder;

import com.example.springjava.controller.dto.ProductDTO;
import com.example.springjava.domain.entity.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcuctBuilder {

    public static Product mapObject(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .value(productDTO.getValue())
                .build();
    }
}
