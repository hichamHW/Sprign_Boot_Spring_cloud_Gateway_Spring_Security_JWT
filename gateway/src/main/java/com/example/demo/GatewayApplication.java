package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Bean
//	RouteLocator routeLocator(RouteLocatorBuilder builder){
//		return builder.routes()
//				.route(r -> r.path("/employee/**")
//						.uri("http://localhost:8081/")
//						.id("employeeModule"))
//
//				.route(r -> r.path("/consumer/**")
//						.uri("http://localhost:8082/")
//						.id("consumerModule"))
//				.build();
//	}
}
