package controller;

import model.domain.MemberRecord;
import model.persistance.HardCodedLoader;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    HardCodedLoader loader = new HardCodedLoader();
    view.ConsoleUi v = new view.ConsoleUi();
    MemberRecord m = loader.load();

    controller.BoatClub c = new BoatClub();
    
    c.startApp(m, v);
  }
}
