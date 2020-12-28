package com.example.demo.controller;

import com.example.demo.models.Product;

import com.example.demo.services.ProductServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServicesImp productServicesImp;
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productServicesImp.getProducts();
    }

    @GetMapping("/products/user/{iduser}")
    public List<Product> getProductUser(@PathVariable("iduser") int iduser){
        return productServicesImp.getProductByUser(iduser);
    }


    @PostMapping("/products")
    public Product createProduct(@RequestBody  Product product){
        return productServicesImp.createProduct(product);
    }
}
