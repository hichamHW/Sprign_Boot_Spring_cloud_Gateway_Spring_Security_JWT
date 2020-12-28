package com.example.auth.services;

import com.example.auth.configs.Variable;
import com.example.auth.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class ProductInteractionServicesImp {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Collection<Product> getTask(Long userid){
        Collection<Product> tasks = new ArrayList<Product>();
        Product[] objects = restTemplate().getForObject(Variable.uriTask+"/user/"+userid,Product[].class);
        System.out.println(Arrays.asList(objects));
        Arrays.asList(objects).forEach(t->{
            System.out.println(t.toString());
            tasks.add(t);
        });

        System.out.println(Arrays.asList(objects));
        return  tasks;
    }
}
