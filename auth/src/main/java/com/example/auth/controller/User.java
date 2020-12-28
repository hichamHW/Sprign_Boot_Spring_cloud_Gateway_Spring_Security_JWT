package com.example.auth.controller;

import com.example.auth.models.MyRole;
import com.example.auth.models.MyUser;
import com.example.auth.services.AccountServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User {

    @Autowired
    AccountServicesImp accountServicesImp;

    @PostMapping("/users")
    public MyUser createUser(@RequestBody MyUser myUser){
        return accountServicesImp.createUser(myUser);
    }

    @GetMapping("/users")
    public List<MyUser> getUsers(){
        return accountServicesImp.getUser();
    }

    @GetMapping("/users/products")
    public List<MyUser> getUserProducts(){
        return accountServicesImp.getUserProducts();
    }

    @GetMapping("/users/products/{username}")
    public MyUser getUserByUsername(@PathVariable("username") String username){
        return accountServicesImp.getUserByUsername(username);
    }


    @PostMapping("/users/Role")
    public MyRole createRole( @RequestBody MyRole myRole){
        return accountServicesImp.createRole(myRole);
    }
}
