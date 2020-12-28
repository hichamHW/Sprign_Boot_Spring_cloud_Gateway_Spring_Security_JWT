package com.example.auth.services;

import com.example.auth.models.MyRole;
import com.example.auth.models.MyUser;
import com.example.auth.models.Product;
import com.example.auth.repo.RepoRole;
import com.example.auth.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.List;

@Service
@Transactional
public class AccountServicesImp  implements  AccountServices{

    @Autowired
    RepoUser repoUser;
    @Autowired
    RepoRole repoRole;
    @Autowired
    ProductInteractionServicesImp productInteractionServicesImp;

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Override
    public MyRole createRole(MyRole myRole) {
        return repoRole.save(myRole);
    }

    @Override
    public MyUser createUser(MyUser myUser) {
        myUser.setPassword(passwordEncoder().encode(myUser.getPassword()));
        return repoUser.save(myUser);
    }

    @Override
    public List<MyUser> getUser() {
        return repoUser.findAll();
    }

    @Override
    public void addRoleToUser(String role, String user) {
        MyUser myUser = repoUser.findByUsername(user);
        MyRole myRole = repoRole.findByName(role);
        List<MyRole> myRoles = new ArrayList<>();
        myRoles.add(myRole);
        myUser.setMyRoles(myRoles);
    }

    @Override
    public MyUser getUserByUsername(String username) {
        MyUser myUser =  repoUser.findByUsername(username);
        myUser.setProducts(productInteractionServicesImp.getTask(myUser.getId()));
        return  myUser;
    }

    @Override
    public List<MyUser> getUserProducts() {
        List<MyUser> myUsers = repoUser.findAll();
        myUsers.forEach((u)->{
            u.setProducts(productInteractionServicesImp.getTask(u.getId()));
        });
        return myUsers;
    }
}
