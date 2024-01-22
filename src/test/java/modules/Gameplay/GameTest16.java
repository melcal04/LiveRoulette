package modules.Gameplay;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.*;

public class GameTest16 extends Gameplay {

    static double balanceAfterBetting = 0.0;

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 16");
        System.out.println("Actual Results: ");

        balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        WaitHandler.waitVisibility(DealerTable.Container.BetResult, 150);

        while (!RoundCondition.isRedWin(getRoundResult())) {
            placeAndConfirmAnyBettingOptions();
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
            WaitHandler.waitVisibility(DealerTable.Container.BetResult, 150);
        }

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.Label.BetResultNumber),
                "** Round Result is Displayed",
                "** Round Result is Not Displayed");

        verifyDisplay(DealerTable.Label.YouWonText);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.Label.YouWonValue),
                "** Win Result is Displayed",
                "** Win Result is Not Displayed");

        WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBets, 150);
        AssertHandler.assertTrue(getUpdatedBalance() > balanceAfterBetting,
                "** Balance is Updated",
                "** Balance is Not Updated");

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
