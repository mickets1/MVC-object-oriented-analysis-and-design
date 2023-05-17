package model.persistance;

import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberRecord;

/**
 * Hard coded loading of members.
 */
public class HardCodedLoader implements Registry {
  @Override
  public MemberRecord load() {
    MemberRecord rec = new MemberRecord();

    Member m = rec.addMember(new Member("Mac", "Bradley", "19601027"));
    m.addMemberBoat(Boat.BoatType.SailBoat, "16");
    m.addMemberBoat(Boat.BoatType.MotorSailer, "10");

    m = rec.addMember(new Member("Josie", "Thorpe", "19700413"));
    m.addMemberBoat(Boat.BoatType.Kayak_Canoe, "10");

    m = rec.addMember(new Member("Johnny", "Rojas", "19801215"));
    m.addMemberBoat(Boat.BoatType.Other, "40");
    m.addMemberBoat(Boat.BoatType.Other, "20");
    m.addMemberBoat(Boat.BoatType.SailBoat, "23");

    return rec;
  }
}
