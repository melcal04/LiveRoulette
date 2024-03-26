package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest3 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 3");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.WelcomeAndGoodLuck, 5);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
