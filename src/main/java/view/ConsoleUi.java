package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;

/**
 * The view - responsible for low-level-input and printing to console.
 */
public class ConsoleUi {
  private Scanner scan = new Scanner(System.in, "utf-8");

  /**
   * Menu items.
   */
  public enum MainMenu {
    Create_Member,
    List_Members,
    Delete_Member,
    Change_Member_Information,
    Show_Specific_Member,
    Register_A_Boat,
    Delete_A_Boat,
    Change_Boat_Information,
    Quit
  }

  /**
   * Sub menu items.
   */
  public enum SubMenu {
    Verbose_List,
    Compact_List,
    Back
  }

  /**
   * Shows the main menu.
   */
  public MainMenu showMainMenu() {
    System.out.println("\n<-----Menu----->");
    for (int i = 0; i < MainMenu.values().length; i++) {
      addNumbersToList(i + 1);
      System.out.println(MainMenu.values()[i]);
    }
    System.out.println("<-------------->");

    int menuChoice = getMenuChoice();
    
    if (menuChoice == 1) {
      return MainMenu.Create_Member;
    } else if (menuChoice == 2) {
      return MainMenu.List_Members;
    } else if (menuChoice == 3) {
      return MainMenu.Delete_Member;
    } else if (menuChoice == 4) {
      return MainMenu.Change_Member_Information;
    } else if (menuChoice == 5) {
      return MainMenu.Show_Specific_Member;
    } else if (menuChoice == 6) {
      return MainMenu.Register_A_Boat;
    } else if (menuChoice == 7) {
      return MainMenu.Delete_A_Boat;
    } else if (menuChoice == 8) {
      return MainMenu.Change_Boat_Information;
    }

    return MainMenu.Quit;
  }

  /**
   * Shows the sub menu.
   */
  public SubMenu showSubMenu() {
    System.out.println("\n<---SubMenu--->");
    for (int i = 0; i < SubMenu.values().length; i++) {
      addNumbersToList(i + 1);
      System.out.println(SubMenu.values()[i]);
    }
    System.out.println("<---------->");

    int menuChoice = getMenuChoice();

    if (menuChoice == 1) {
      return SubMenu.Verbose_List;
    } else if (menuChoice == 2) {
      return SubMenu.Compact_List;
    }

    return SubMenu.Back;
  }

  /**
   * Prints a verbose list of member information.
   *
   * @param members All of the members.
   */
  public void printVerboseList(ArrayList<Member> members) {
    int index = 0;

    for (Member member : members) {
      addNumbersToList(index += 1);

      System.out.println("\nName: " + member.getFirstName() + " " + member.getLastName());
      System.out.println("PersonalNumber: " + member.getPersonalNumber());
      System.out.println("MemberID: " + member.getmemberId());

      printBoatInformation(member);
      printDevider();
    }
  }

  /**
   * Prints a compact list of the member's information.
   *
   * @param members All of the members.
   */
  public void printCompactList(ArrayList<Member> members) {
    int index = 0;

    for (Member member : members) {
      addNumbersToList(index += 1);

      System.out.println("\nName: " + member.getFirstName() + " " + member.getLastName());
      System.out.println("MemberID: " + member.getmemberId());
      System.out.println("Number of boats: " + member.getMemberBoat().size() + "\n");
    }
  }

  /**
   * Presents a new member form.
   *
   * @return a new Member.
   */
  public Member newMemberForm() {
    System.out.print("Enter firstname: ");
    String firstName = scan.next();

    System.out.print("Enter lastname: ");
    String lastName = scan.next();

    System.out.print("Enter personal number: ");
    String pnr = scan.next();

    return new Member(firstName, lastName, pnr);
  }

  /**
   * Boat type - user input.
   *
   * @return The boat type.
   */
  public BoatType boatType() {
    System.out.print("Boat Type: \n");

    System.out.println("1. " + enumToString(BoatType.SailBoat));
    System.out.println("2. " + enumToString(BoatType.MotorSailer));
    System.out.println("3. " + enumToString(BoatType.Kayak_Canoe));
    System.out.println("4. " + enumToString(BoatType.Other));
    System.out.print("Select a boat type to register: ");

    int selection = scan.nextInt();

    if (selection == 1) {
      return BoatType.SailBoat;
    } else if (selection == 2) {
      return BoatType.MotorSailer;
    } else if (selection == 3) {
      return BoatType.Kayak_Canoe;
    } else if (selection == 4) {
      return BoatType.Other;
    }

    return null;
  }

  /**
   * The length of the boat.
   *
   * @return The length of the boat.
   */
  public String boatLength() {
    System.out.print("Boat Length: ");

    return scan.next();
  }

  /**
   * Promt for selecting a member.
   *
   * @param members All of the members.
   * @return a specific member.
   */
  public Member memberActionPrompt(ArrayList<Member> members) {
    System.out.print("Select a member: ");
    int selection = scan.nextInt();

    return getMemberByIndex(members, selection);
  }

  /**
   * Returns a specific member in the member record.
   *
   * @param members All of the members.
   * @param index Index of the specific member.
   * @return The specific member.
   */
  public Member getMemberByIndex(ArrayList<Member> members, int index) {
    return members.get(index - 1);
  }

  /**
   * Returns a specific boat.
   *
   * @param boats The boat(s) of a member.
   * @return A specific boat object.
   */
  public Boat getSpecificBoat(ArrayList<Boat> boats) {
    System.out.print("Select a boat: ");
    int boatSelection = scan.nextInt() - 1;

    return boats.get(boatSelection);
  }

  /**
   * Prints the details of a specific member. 
   *
   * @param member The member.
   */
  public void printSpecificMember(Member member) {
    printDevider();
    System.out.println("\nName: " + member.getFirstName() + " " + member.getLastName());
    System.out.println("PersonalNumber: " + member.getPersonalNumber());
    System.out.println("MemberID: " + member.getmemberId());

    ArrayList<Boat> boats = member.getMemberBoat();
    System.out.print("\nOwned Boat(s):");
    for (Boat boat : boats) {
      System.out.println("\nBoat Type: " + boat.getBoatType());
      System.out.println("Boat Length: " + boat.getBoatLength());
    }
  }

  /**
   * Prints the boat information. 
   *
   * @param member A specific member.
   */
  public void printBoatInformation(Member member) {
    ArrayList<Boat> boats = member.getMemberBoat();

    int index = 0;
    
    System.out.println("\nBoat(s): ");
    for (Boat boat : boats) {
      addNumbersToList(index += 1);
      System.out.println("\nBoat Type: " + boat.getBoatType());
      System.out.println("Boat Length: " + boat.getBoatLength() + "\n");
    }
  }

  /**
   * Retuns the string representation of a boat enumeration.
   *
   * @param type Boat type enum.
   * @return Boat type String.
   */
  private String enumToString(model.domain.Boat.BoatType type) {
    switch (type) {
      case SailBoat:
        return "Sail Boat";
      case MotorSailer:
        return "Motor Sailer";
      case Kayak_Canoe:
        return "Kayak/Canoe";
      case Other:
        return "Other Type";
      default:
        return "Unknown Boat Type";
    }
  }

  /**
   * Adds number to list in console.
   *
   * @param index Index to print.
   */
  public void addNumbersToList(int index) {
    System.out.print(index + ") ");
  }

  /**
   * Prints a simple divider.
   */
  public void printDevider() {
    System.out.println("<--------------------------------->");
  }

  /**
   * Retuns the user input.
   *
   * @return The input.
   */
  private int getMenuChoice() {
    System.out.print("Choose an alternative: ");
    return scan.nextInt();
  }

  /**
   * Closes the scanner and prints a exit message.
   */
  public void closeScanner() {
    System.out.println("Goodbye");
    scan.close();
  }
}
