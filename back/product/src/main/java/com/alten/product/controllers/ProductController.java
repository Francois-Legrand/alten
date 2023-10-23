package com.alten.product.controllers;

import com.alten.product.dto.ProductDTO;
import com.alten.product.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductServiceImpl service;
    @GetMapping
    public List<ProductDTO> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Optional<ProductDTO> findById(@PathVariable String id){

        return service.findById(id);
    }
    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        return service.save(productDTO);
    }
    @PutMapping("/{id}")
    public ProductDTO edit(@RequestBody ProductDTO productDTO){
        return service.save(productDTO);
    }
    @DeleteMapping
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("/{id}") void deleteById(@PathVariable String id){
        service.deleteById(id);
    }
}
