package modules.Gameplay;

import globals.TestConditions;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.CustomAssert;

public class GameTest16 extends Gameplay {

    static double balanceAfterBetting = 0.0;

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 16");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.Balance);

        while (!TestConditions.isRedWin(getRoundResult())) {
            placeAndConfirmAnyBettingOptions();
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.Balance);
        }

        VerificationHandler.verifyIfDisplayed(DealerTable.Container.RoundResult, 150);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.YouWon, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.WonAmount, 5);
        CustomAssert.assertTrue(getUpdatedBalance() > balanceAfterBetting,
                "** Balance is Updated",
                "** Balance is Not Updated");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
