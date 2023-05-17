package model.domain;

/**
 * Boat constructor.
 */
public class Boat {
  private BoatType boatType;
  private String boatLength;

  public Boat() {
  }

  /**
   * The boat types.
   */
  public enum BoatType {
    SailBoat,
    MotorSailer,
    Kayak_Canoe,
    Other
  }

  public Boat(BoatType boatType, String boatLength) {
    this.boatType = boatType;
    this.boatLength = boatLength;
  }

  /**
   * Sets the boat type.
   *
   * @param boatType Type of the boat.
   */
  public void setBoatType(BoatType boatType) {
    this.boatType = boatType;
  }

  public BoatType getBoatType() {
    return boatType;
  }

  /**
   * Sets the length of the boat.
   *
   * @param boatLength Length of the boat.
   */
  public void setBoatLength(String boatLength) {
    if (boatLength.length() > 0) {
      this.boatLength = boatLength;
    }
  }

  public String getBoatLength() {
    return boatLength;
  }
}
