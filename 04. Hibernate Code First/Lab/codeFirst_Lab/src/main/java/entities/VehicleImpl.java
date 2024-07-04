package entities;

public abstract class VehicleImpl {
  private String brand;
  private String model;
  private int horsePowers;

  protected VehicleImpl(String brand, String model, int horsePowers, Engine engine) {
    this.brand = brand;
    this.model = model;
    this.horsePowers = horsePowers;
    this.engine = engine;
  }

  @Override
  public void ignite() {
    this.engine.ignite();
  }
}
