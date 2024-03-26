package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest14 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 14");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.BettingIsClosing, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.PopUpConfirm, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.PopUpNotNow, 5);

        System.out.println();
        EventHandler.click(DealerTable.Button.PopUpNotNow);
        EventHandler.click(DealerTable.Button.Back);
    }

}
