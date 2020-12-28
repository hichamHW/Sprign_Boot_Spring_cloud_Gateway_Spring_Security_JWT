package com.example.demo.repos;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ProductRepo  extends JpaRepository<Product,Long> {
    List<Product> findByIdUser(int idUser);
}
