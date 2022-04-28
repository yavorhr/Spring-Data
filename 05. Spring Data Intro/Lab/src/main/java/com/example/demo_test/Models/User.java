package com.example.demo_test.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String username;
    private int age;
    private Set<Account> account;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public User() {
    }

    @Column(unique = true)
    public String getUsername() {
        return username;
    }
    @Column
    public int getAge() {
        return age;
    }

    @OneToMany(mappedBy = "user")
    public Set<Account> getAccount() {
        return account;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }
}
