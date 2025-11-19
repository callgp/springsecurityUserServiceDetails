package com.telusko.spring_sec_demo.dao;

import com.telusko.spring_sec_demo.model.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

public interface UserRepo extends JpaRepository<User,Integer>{

   User findByUserName(String username);
}
