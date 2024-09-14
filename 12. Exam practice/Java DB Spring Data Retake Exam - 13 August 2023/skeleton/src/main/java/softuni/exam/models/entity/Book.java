package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.GenreEnum;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
  private String title;
  private String author;
  private String description;
  private boolean available;
  private GenreEnum genre;
  private Double rating;

  public Book() {
  }

  @Column(nullable = false, unique = true)
  public String getTitle() {
    return title;
  }

  @Column(nullable = false)
  public String getAuthor() {
    return author;
  }

  @Column(columnDefinition = "TEXT",nullable = false)
  public String getDescription() {
    return description;
  }

  @Column
  public boolean isAvailable() {
    return available;
  }

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  public GenreEnum getGenre() {
    return genre;
  }

  @Column(nullable = false)
  public Double getRating() {
    return rating;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public void setGenre(GenreEnum genre) {
    this.genre = genre;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }
}
