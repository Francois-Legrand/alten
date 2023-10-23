package com.alten.product.services.impl;

import com.alten.product.dto.ProductDTO;
import com.alten.product.models.Product;
import com.alten.product.repositories.IProductRepository;
import com.alten.product.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements IProductService {
    private final IProductRepository repository;

    private final ObjectMapper mapper;
    public ProductServiceImpl(IProductRepository repository,ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> findAll(){
        List<Product> products = this.repository.findAll();
        List<ProductDTO> getProductsDTOs = new ArrayList<>();
        products.forEach(product -> getProductsDTOs.add(this.mapper.convertValue(product,ProductDTO.class)));
        return getProductsDTOs;
    }
    @Override
    public Optional<ProductDTO> findById(String id){
            if (this.repository.findById(id).isPresent()){
                return Optional.ofNullable(mapper.convertValue(this.repository.findById(id).get(), ProductDTO.class));
            }else {
                System.out.println("Not found");
            }
        return null;
    }
    public ProductDTO update(String id,ProductDTO productDTO){
        if (this.repository.findById(productDTO.getId()).isPresent()){
            Product product = mapper.convertValue(productDTO, Product.class);
            return mapper.convertValue(this.repository.save(product), ProductDTO.class);
        }else {
            System.out.println("Not found");
        }
        return null;
    }
    @Override
    public ProductDTO save(ProductDTO productDTO){
        Product product = mapper.convertValue(productDTO, Product.class);
        return mapper.convertValue(this.repository.save(product), ProductDTO.class);
    }
    @Override
    public void deleteById(String id){
        this.repository.deleteById(id);
    }
    @Override
    public ProductDTO deleteAll(){
        this.repository.deleteAll();
        return null;
    }


}
