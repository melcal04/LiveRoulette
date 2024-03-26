package modules.Gameplay;

import globals.TestVariables;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;
import utilities.objects.Locator;

public class GameTest10 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 10");
        System.out.println("Actual Results: ");

        for (Locator actionButton : TestVariables.ACTION_BUTTONS)
            VerificationHandler.verifyIfNotContained(actionButton, "class", "disabled", "Enabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
