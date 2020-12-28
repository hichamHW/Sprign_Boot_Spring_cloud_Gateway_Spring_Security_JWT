package com.example.auth.services;

import com.example.auth.models.MyRole;
import com.example.auth.models.MyUser;

import java.util.List;

public interface AccountServices {
    public MyRole createRole(MyRole myRole);
    public MyUser createUser(MyUser myUser);
    public List<MyUser> getUser();
    public void addRoleToUser(String role,String user);
    public MyUser getUserByUsername(String username);
    public List<MyUser>  getUserProducts();
}
