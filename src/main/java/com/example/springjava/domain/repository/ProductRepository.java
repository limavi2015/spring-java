package com.example.springjava.domain.repository;

import com.example.springjava.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    public List<Product> findAll();

}
