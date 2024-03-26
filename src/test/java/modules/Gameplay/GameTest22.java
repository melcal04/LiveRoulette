package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest22 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 22");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfNotContained(DealerTable.Button.Double, "class", "disabled", "Enabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
