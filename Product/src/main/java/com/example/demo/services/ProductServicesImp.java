package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServicesImp implements ProductServices {
    @Autowired
    ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getProductByUser(int idUser) {
        return productRepo.findByIdUser(idUser);
    }
}
