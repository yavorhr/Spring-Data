package com.example.demo_test.Models;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    private Long id;
    private BigDecimal balance;
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Account() {
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    @Column
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
