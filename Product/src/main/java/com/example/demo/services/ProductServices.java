package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductServices {
    public Product createProduct(Product product);
    public List<Product>  getProducts();
    public  Product getProduct(Long id);
    public List<Product> getProductByUser(int idUser);
}
