package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_predictions")
public class ResultPredictions extends BaseEntity  {
  PredictionsEnum prediction;

  public ResultPredictions() {
  }

  public ResultPredictions(PredictionsEnum prediction) {
    this.prediction = prediction;
  }

  public PredictionsEnum getPrediction() {
    return this.prediction;
  }

  public void setPrediction(PredictionsEnum prediction) {
    this.prediction = prediction;
  }
}
