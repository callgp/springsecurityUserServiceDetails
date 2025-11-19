package com.telusko.spring_sec_demo.model;

@Data
@Entity
@Table(name="users")
public class User {
    private int id;
    private String username;
    private String password;

}
