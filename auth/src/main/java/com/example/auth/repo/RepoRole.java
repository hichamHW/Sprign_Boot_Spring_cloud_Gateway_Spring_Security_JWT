package com.example.auth.repo;

import com.example.auth.models.MyRole;
import com.example.auth.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRole extends JpaRepository<MyRole,Long> {
    MyRole findByName(String name);
}
