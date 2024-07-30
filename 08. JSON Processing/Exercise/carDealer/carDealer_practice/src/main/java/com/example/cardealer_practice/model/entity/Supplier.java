package com.example.cardealer_practice.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    private String name;
    private boolean isImporter;
    private List<Part> parts;

    public Supplier() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_importer")
    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER)
    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
