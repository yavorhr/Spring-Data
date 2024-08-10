package com.example.mappingobjectslab.entity.model;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Country {
    private Long id;
    private String name;
    private Set<City> cities;
    private MyEnum asd;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country")
    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public MyEnum getAsd() {
        return asd;
    }

    public void setAsd(MyEnum asd) {
        this.asd = asd;
    }
}
