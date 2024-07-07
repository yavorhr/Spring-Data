package entities.FootballBettingDatabase.Enums;

public enum PredictionsEnum {
  HOME_TEAM_WIN("Home team win"),
  DRAW_GAME("Draw Game"),
  AWAY_TEAM_WIN("Away Team Win");

  private final String displayPrediction;

  PredictionsEnum(String displayPrediction) {
    this.displayPrediction = displayPrediction;
  }

  @Override
  public String toString() {
    return this.displayPrediction;
  }

  public String getDisplayPrediction() {
    return this.displayPrediction;
  }
}
