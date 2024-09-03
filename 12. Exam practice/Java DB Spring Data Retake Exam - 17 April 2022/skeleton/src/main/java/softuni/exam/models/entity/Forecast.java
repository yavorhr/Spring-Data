package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity {
  private DayOfWeekEnum dayOfWeek;
  private Double maxTemperature;
  private Double minTemperature;
  private LocalDateTime sunrise;
  private LocalDateTime sunset;
  private City city;

  public Forecast() {
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "day_of_week", nullable = false)
  public DayOfWeekEnum getDayOfWeek() {
    return dayOfWeek;
  }

  @Column(name = "max_temperature", nullable = false)
  public Double getMaxTemperature() {
    return maxTemperature;
  }

  @Column(name = "min_temperature", nullable = false)
  public Double getMinTemperature() {
    return minTemperature;
  }

  @Column(columnDefinition = "TIME", nullable = false)
  public LocalDateTime getSunrise() {
    return sunrise;
  }

  @Column(columnDefinition = "TIME", nullable = false)
  public LocalDateTime getSunset() {
    return sunset;
  }

  @ManyToOne
  public City getCity() {
    return city;
  }

  public void setDayOfWeek(DayOfWeekEnum dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public void setMaxTemperature(Double maxTemperature) {
    this.maxTemperature = maxTemperature;
  }

  public void setMinTemperature(Double minTemperature) {
    this.minTemperature = minTemperature;
  }

  public void setSunrise(LocalDateTime sunrise) {
    this.sunrise = sunrise;
  }

  public void setSunset(LocalDateTime sunset) {
    this.sunset = sunset;
  }

  public void setCity(City city) {
    this.city = city;
  }
}
