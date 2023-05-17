package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import model.domain.MemberRecord;
import model.domain.Boat;
import model.domain.Member;


public class SimpleTest {
  @Test
  public void testMemberInput() {
    MemberRecord rec = new MemberRecord();

    Member m = rec.addMember(new Member("Mac", "Bradley", "19601027"));
    m.addMemberBoat(Boat.BoatType.SailBoat, "16");
    m.addMemberBoat(Boat.BoatType.MotorSailer, "10");

    Member member = rec.getMembers().get(0);

    assertTrue(member.getFirstName().length() == 3, "first name length should equal 3");
    assertTrue(member.getLastName().length() == 7, "last name length should equal 7");
    assertTrue(member.getPersonalNumber().length() == 8, "last name length should equal 8");

    Boat boat1 = member.getMemberBoat().get(0);
    assertTrue(boat1.getBoatType() == Boat.BoatType.SailBoat, " Boat type should equal Sailboat");
    assertTrue(boat1.getBoatLength() == "16", "boat length should equal 16");

    Boat boat2 = member.getMemberBoat().get(1);
    assertTrue(boat2.getBoatType() == Boat.BoatType.MotorSailer, " Boat type should equal Motorsailer");
    assertTrue(boat2.getBoatLength() == "10", "boat length should equal 10");
  }
}
