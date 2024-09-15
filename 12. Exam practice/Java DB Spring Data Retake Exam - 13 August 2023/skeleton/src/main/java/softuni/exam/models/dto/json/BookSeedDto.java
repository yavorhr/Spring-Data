package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.enums.GenreEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookSeedDto {

  @Expose
  private String author;
  @Expose
  private boolean available;
  @Expose
  private String description;
  @Expose
  private GenreEnum genre;
  @Expose
  private String title;
  @Expose
  private Double rating;

  public BookSeedDto() {
  }

  @Size(min = 3, max = 40)
  public String getAuthor() {
    return author;
  }

  public boolean isAvailable() {
    return available;
  }

  @Size(min = 5)
  public String getDescription() {
    return description;
  }

  @Enumerated
  public GenreEnum getGenre() {
    return genre;
  }

  @Size(min = 3, max = 40)
  public String getTitle() {
    return title;
  }

  @Positive
  public Double getRating() {
    return rating;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setGenre(GenreEnum genre) {
    this.genre = genre;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }
}
