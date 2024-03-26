package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest28 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 28");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfContained(DealerTable.Container.Timer, "class", "red", "Red Color");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
