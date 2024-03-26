package modules.Gameplay;

import globals.TestConditions;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;
import utilities.handlers.WaitHandler;

public class GameTest17 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 17");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);

        while (TestConditions.isRedWin(getRoundResult())) {
            placeAndConfirmAnyBettingOptions();
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        }

        VerificationHandler.verifyIfDisplayed(DealerTable.Container.RoundResult, 150);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
