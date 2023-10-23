package com.alten.product.config;

import com.alten.product.repositories.IProductRepository;
import com.alten.product.services.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {
    @Bean
    ProductServiceImpl productService(IProductRepository productRepository, ObjectMapper mapper){
        return new ProductServiceImpl(productRepository,mapper);
    }
}
