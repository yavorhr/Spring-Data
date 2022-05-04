package com.example.xmlexercise.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer age;

    private Set<User> fiends;
    private Set <Product> soldProducts;

    public User() {
    }


    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    @ManyToMany
    public Set<User> getFiends() {
        return fiends;
    }

    //!!!!!!
    @OneToMany(mappedBy = "seller",fetch = FetchType.EAGER)
    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFiends(Set<User> fiends) {
        this.fiends = fiends;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
