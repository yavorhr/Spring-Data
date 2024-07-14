package com.example.springintro.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;
    private AgeRestriction ageRestriction;

    private Author author;
    private Set<Category> categories;


    public Book() {
    }

    public Book(EditionType editionType, LocalDate releaseDate, Integer copies, BigDecimal price, AgeRestriction ageRestriction, String title, Author author, Set<Category> categories) {
        this.editionType = editionType;
        this.releaseDate = releaseDate;
        this.copies = copies;
        this.price = price;
        this.ageRestriction = ageRestriction;
        this.title = title;
        this.author = author;
        this.categories = categories;
    }

    @Column(name = "title", length = 50, nullable = false)
    public String getTitle() {
        return title;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Enumerated(EnumType.ORDINAL)
    public EditionType getEditionType() {
        return editionType;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column
    public Integer getCopies() {
        return copies;
    }

    @Column(name = "release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Enumerated
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @ManyToOne
    public Author getAuthor() {
        return author;
    }

    @ManyToMany
    public Set<Category> getCategories() {
        return categories;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
