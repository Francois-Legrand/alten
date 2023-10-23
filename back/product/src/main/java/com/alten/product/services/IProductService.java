package com.alten.product.services;

import com.alten.product.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTO> findAll();
    Optional<ProductDTO> findById(String id);
    ProductDTO save(ProductDTO productDTO);

    void deleteById(String id);

    public ProductDTO update(String id, ProductDTO productDTO);

    ProductDTO deleteAll();


}
