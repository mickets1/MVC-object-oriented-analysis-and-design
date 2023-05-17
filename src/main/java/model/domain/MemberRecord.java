package model.domain;

import java.util.ArrayList;

/**
 * The members record of all the members in the boat club.
 */
public class MemberRecord {
  private ArrayList<Member> members;
  private ArrayList<String> memberIds;

  public MemberRecord() {
    members = new ArrayList<Member>();
    memberIds = new ArrayList<String>();
  }

  /**
   * Adds a new member to the member record.
   *
   * @param member The new Member.
   * @return The new member object.
   */
  public Member addMember(Member member) {
    // Certifies a unique id is assigned to member.
    while (true) {
      String memberId = member.getmemberId();
      if (!memberIds.contains(memberId)) {
        memberIds.add(memberId);
        members.add(member);
        break;
      } else {
        this.addMember(new Member(member.getFirstName(), member.getLastName(), member.getPersonalNumber()));
      }
    }

    return member;
  }

  /**
   * Removes a member from the record.
   *
   * @param member The member.
   */
  public void deleteMember(Member member) {
    members.remove(member);
  }

  /**
   * Updates an old member with new information.
   *
   * @param oldMember The old member.
   * @param updatedMember The new updated member.
   */
  public void updateMember(Member oldMember, Member updatedMember) {
    oldMember.setFirstName(updatedMember.getFirstName());
    oldMember.setLastName(updatedMember.getLastName());
    oldMember.setPersonalNumber(updatedMember.getPersonalNumber());
  }

  /**
   * Retuns the member record.
   *
   * @return The members in the record.
   */
  public ArrayList<Member> getMembers() {
    ArrayList<Member> membersCopy = new ArrayList<>();
    for (Member member : members) {
      membersCopy.add(member);
    }
    return membersCopy;
  }
}
