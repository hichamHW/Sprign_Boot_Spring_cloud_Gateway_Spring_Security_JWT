package com.example.demo;

import com.example.demo.models.Product;
import com.example.demo.services.ProductServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceTaskApplication implements CommandLineRunner {

	@Autowired
	ProductServicesImp productServicesImp;
	public static void main(String[] args) {
		SpringApplication.run(ServiceTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productServicesImp.createProduct(new Product(null,"pc",80,1));
		productServicesImp.createProduct(new Product(null,"phone",80,1));
		productServicesImp.createProduct(new Product(null,"tablet",80,2));

		productServicesImp.getProducts().forEach((p)->{
			System.out.println(p.toString());
		});
	}

	@GetMapping("/test")
	public String test(){
		return "test Ok";
	}
}
