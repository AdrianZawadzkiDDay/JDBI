package com.example.demo.service.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.exception.DataNotFoundException;
import com.example.demo.model.Product;
import jakarta.validation.Valid;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(Jdbi jdbi) {
        this.productRepository = jdbi.onDemand(ProductRepository.class);
    }

    @Override
    public Product create(Product product) {
        return getById(productRepository.insert(product));
    }

    private Product getById(long id) {

        Product product = productRepository.getById(id);
        if(ObjectUtils.isEmpty(product)) {
            throw new DataNotFoundException(MessageFormat.format("Product id {0} not found.", String.valueOf(id)));
        }
        return product;
    }

    @Override
    public List<Product> gdtAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return Optional.ofNullable(productRepository.getById(id));
    }

    @Override
    public int updateProductById(@Valid Product product) {
        return productRepository.updateProductById(product);
    }

    @Override
    public int deleteProductById(long id) {
        return productRepository.deleteProductById(id);
    }
}
