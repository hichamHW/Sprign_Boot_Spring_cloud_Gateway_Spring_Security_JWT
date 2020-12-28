package com.example.auth.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private float price;
}
