package com.alten.product.repositories;

import com.alten.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product,String> {
    @Override
    void deleteById(String id);
}
