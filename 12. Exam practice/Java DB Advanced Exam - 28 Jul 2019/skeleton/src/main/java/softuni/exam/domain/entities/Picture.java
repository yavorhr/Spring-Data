package softuni.exam.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private String url;

  public Picture() {
  }

  @Column(nullable = false,unique = true)
  public String getUrl() {
    return url;
  }

  public Picture setUrl(String url) {
    this.url = url;
    return this;
  }
}
