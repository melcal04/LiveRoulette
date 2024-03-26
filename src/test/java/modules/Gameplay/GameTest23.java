package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest23 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 23");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfContained(DealerTable.Button.Double, "class", "disabled", "Disabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
