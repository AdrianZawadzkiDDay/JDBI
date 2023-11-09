package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import entities.Product;
import jakarta.validation.Valid;

public interface ProductService {
    Product create(Product product);

    List<Product> gdtAllProducts();

    Optional<Product> getProductById(long id);

    int updateProductById(@Valid Product product);

    int deleteProductById(long id);
}
