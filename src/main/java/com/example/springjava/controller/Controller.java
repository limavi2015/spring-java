package com.example.springjava.controller;

import com.example.springjava.controller.dto.ProductDTO;
import com.example.springjava.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/v1/products", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getbands() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @RequestMapping(value = "/v1/products", method = RequestMethod.POST)
    public ResponseEntity<String> createBand(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
}
