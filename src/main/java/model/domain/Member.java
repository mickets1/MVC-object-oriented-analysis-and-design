package model.domain;

import java.util.ArrayList;
import java.util.Random;
import model.domain.Boat.BoatType;

/**
 * Representing a boat club member and their boat's.
 */
public class Member {
  private ArrayList<Boat> boats;
  private String memberId;
  private String firstName;
  private String lastName;
  private String personalNumber;

  /**
   * Constructor of Member.
   *
   * @param firstName First name of a member.
   * @param lastName Last name of a Member.
   * @param personalNumber Personal number of a Member.
   */
  public Member(String firstName, String lastName, String personalNumber) {
    boats = new ArrayList<Boat>();
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNumber = personalNumber;
    this.memberId = generateMemberId();
  }

  /**
   * Updates member details.
   *
   * @param member The member object.
   */
  public void update(Member member) {
    member.setFirstName(firstName);
    member.setLastName(lastName);
    member.setPersonalNumber(personalNumber);
  }

  /**
   * Removes a specific boat.
   *
   * @param boat The boat object.
   */
  public void delete(Boat boat) {
    boats.remove(boat);
  }

  /**
   * Generates a member id.
   *
   * @return The generated ID.
   */
  private String generateMemberId() {
    StringBuffer buf = new StringBuffer();

    Random rnd = new Random();
    for (int i = 0; i < 6; i++) {
      buf.append(rnd.nextInt(9 - 1) + 1);
    }
    return buf.toString();
  }

  /**
   * Adds a boat to a member if it's an allowed type.
   *
   * @param boatType Type of the boat - Sailboat, Motorsailer, Kayak/Canoe, Other
   * @param boatLength Length of the boat.
   * @return true if boat type is allowed.
   */
  public Boat addMemberBoat(BoatType boatType, String boatLength) {
    Boat boat = new Boat(boatType, boatLength);
    boats.add(boat);

    return boat;
  }

  /**
   * Owned boat(s) of the member.
   *
   * @return Array of owned boats.
   */
  public ArrayList<Boat> getMemberBoat() {
    return boats;
  }

  /**
   * Set's the first name of a member.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    if (firstName.length() > 0) {
      this.firstName = firstName;
    }
  }

  /**
   * Get's first name of a member.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Set's last name.
   *
   * @param lastName The last name.
   */
  public void setLastName(String lastName) {
    if (lastName.length() > 0) {
      this.lastName = lastName;
    }   
  }

  /**
   * Get's last name.
   *
   * @return last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Set's personal number. 
   *
   * @param personalNumber The personal number.
   */
  public void setPersonalNumber(String personalNumber) {
    if (personalNumber.length() > 0) {
      this.personalNumber = personalNumber;
    }
  }

  /**
   * Get's the personal number.
   *
   * @return The personal number.
   */
  public String getPersonalNumber() {
    return personalNumber;
  }

  /**
   * Get's the member ID.
   *
   * @return The member ID.
   */
  public String getmemberId() {
    return memberId;
  }
}
