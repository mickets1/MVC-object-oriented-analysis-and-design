package controller;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;
import view.ConsoleUi;

/**
 * Controller.
 */
public class BoatClub {
  /**
   * Menu of the boat club.
   */
  public void startApp(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    boolean quit = false;
    do {
      ConsoleUi.MainMenu menuChoiceAction = ui.showMainMenu();

      switch (menuChoiceAction) {
        case Create_Member:
          createMemberFromInput(reg, ui);
          break;
        case List_Members:
          listMemberAction(reg, ui);
          break;
        case Delete_Member:
          deleteMember(reg, ui);
          break;
        case Change_Member_Information:
          updateMember(reg, ui);
          break;
        case Show_Specific_Member:
          showSpecificMember(reg, ui);
          break;
        case Register_A_Boat:
          registerBoat(reg, ui);
          break;
        case Delete_A_Boat:
          deleteBoat(reg, ui);
          break;
        case Change_Boat_Information:
          changeBoatInformation(reg, ui);
          break;
        case Quit:
          quit = true;
          ui.closeScanner();
          break;
        default:
      }
    } while (!quit);
  }

  private void createMemberFromInput(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    Member member = ui.newMemberForm();

    reg.addMember(member);
  }

  /**
   * Prints the members in different ways in the ui.
   *
   * @param menuChoice Menu choice of the user.
   */
  private void listMemberAction(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    ConsoleUi.SubMenu menuChoiceAction = ui.showSubMenu();

    switch (menuChoiceAction) {
      case Verbose_List:
        listMembers(reg.getMembers(), ui, true);
        break;
      case Compact_List:
        listMembers(reg.getMembers(), ui, false);
        break;
      case Back:
        break;
      default:
    }
  }

  private void deleteMember(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    listMembers(reg.getMembers(), ui, false);
    Member member = ui.memberActionPrompt(reg.getMembers());

    reg.deleteMember(member);
  }

  /**
   * Updates a member's information from view input.
   */
  private void updateMember(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    listMembers(reg.getMembers(), ui, false);
    Member oldMember = ui.memberActionPrompt(reg.getMembers());
    Member updatedMember = ui.newMemberForm();

    reg.updateMember(oldMember, updatedMember);
  }

  /**
   * Select a member and display in ui.
   */
  private void showSpecificMember(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    Member member = getSpecificMember(reg, ui);

    ui.printSpecificMember(member);
  }

  /**
   * Register a new boat for a specific user based on input.
   */
  private void registerBoat(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    listMembers(reg.getMembers(), ui, false);
    Member member = getSpecificMember(reg, ui);

    member.addMemberBoat(ui.boatType(), ui.boatLength());
  }

  /**
   * Removes a boat from a member.
   *
   * @param boat a specific boat object.
   */
  private void deleteBoat(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    listMembers(reg.getMembers(), ui, false);
    Member member = getSpecificMember(reg, ui);

    Boat boat = getSpecificBoat(member, reg, ui);

    member.delete(boat);
  }

  /**
   * Changes a boat's information bases on input.
   *
   * @param boat a specific boat object.
   */
  private void changeBoatInformation(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    Member member = getSpecificMember(reg, ui);
    Boat boat = getSpecificBoat(member, reg, ui);

    BoatType boatType = ui.boatType();
    String boatLength = ui.boatLength();

    boat.setBoatType(boatType);
    boat.setBoatLength(boatLength);
  }

  private void listMembers(ArrayList<Member> members, view.ConsoleUi ui, boolean isVerbose) {
    if (isVerbose) {
      ui.printVerboseList(members);
    } else {
      ui.printCompactList(members);
    }
  }

  private Member getSpecificMember(model.domain.MemberRecord reg, view.ConsoleUi ui) {
    listMembers(reg.getMembers(), ui, false);
    return ui.memberActionPrompt(reg.getMembers());
  }
  
  /**
   * Returns a specific boat.
   *
   * @return a specific boat object.
   */
  private Boat getSpecificBoat(Member member, model.domain.MemberRecord reg, view.ConsoleUi ui) {
    ui.printBoatInformation(member);

    ArrayList<Boat> boats = member.getMemberBoat();

    if (boats.size() > 1) {
      return ui.getSpecificBoat(boats);
    } else {
      return boats.get(0);
    }
  }
}
