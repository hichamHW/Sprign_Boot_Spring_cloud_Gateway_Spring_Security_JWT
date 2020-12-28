package com.example.auth.repo;

import com.example.auth.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<MyUser,Long> {
    MyUser findByUsername(String username);
}
