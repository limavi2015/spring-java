package com.example.springjava.domain.service;

import com.example.springjava.controller.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();

    String createProduct(ProductDTO productDTO);

}
