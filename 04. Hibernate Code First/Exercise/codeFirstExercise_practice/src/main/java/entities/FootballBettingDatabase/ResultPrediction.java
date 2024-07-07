package entities.FootballBettingDatabase;

import entities.BaseEntity;
import entities.FootballBettingDatabase.Enums.PredictionsEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {
  PredictionsEnum prediction;

  public ResultPrediction() {
  }

  public ResultPrediction(PredictionsEnum prediction) {
    this.prediction = prediction;
  }

  public PredictionsEnum getPrediction() {
    return this.prediction;
  }

  public void setPrediction(PredictionsEnum prediction) {
    this.prediction = prediction;
  }
}
