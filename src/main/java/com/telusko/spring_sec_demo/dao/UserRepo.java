package com.telusko.spring_sec_demo.dao;

import com.telusko.spring_sec_demo.model.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

 public  User findByUsername(String username);
}
