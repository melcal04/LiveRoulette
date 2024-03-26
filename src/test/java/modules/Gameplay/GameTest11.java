package modules.Gameplay;

import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.CustomAssert;

public class GameTest11 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 11");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.BetsAccepted, 5);
        WaitHandler.wait(1);
        double expectedTotalBet = getChipValue(DEFAULT_BETTING_CHIP);
        double actualTotalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        CustomAssert.assertEquals(expectedTotalBet, actualTotalBet,
                "** First Bet Amount is Reflected in Total Bet: " + expectedTotalBet + " == " + actualTotalBet,
                "** First Bet Amount is Not Reflected in Total Bet: " + expectedTotalBet + " != " + actualTotalBet);

        EventHandler.click(BettingPanel.Option.getSide(TestVariables.EVEN));
        EventHandler.click(DealerTable.Button.Confirm);

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.BetsAccepted, 5);
        WaitHandler.wait(1);
        expectedTotalBet += getChipValue(BettingPanel.Chip.getSide(TestVariables.EVEN));
        actualTotalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        CustomAssert.assertEquals(expectedTotalBet, actualTotalBet,
                "** Second Bet Amount is Reflected in Total Bet: " + expectedTotalBet + " == " + actualTotalBet,
                "** Second Bet Amount is Not Reflected in Total Bet: " + expectedTotalBet + " != " + actualTotalBet);

        double expectedBalance = balanceBeforeBetting - expectedTotalBet;
        double actualBalance = GetHandler.getDouble(DealerTable.Label.Balance);
        CustomAssert.assertEquals(expectedBalance, actualBalance,
                "** Total Bet is Deducted From The Total Balance: " + expectedBalance + " == " + actualBalance,
                "** Total Bet is Not Deducted From The Total Balance: " + expectedBalance + " != " + actualBalance);

        System.out.println();
        waitUntilBettingPhaseOpen();
        EventHandler.click(DealerTable.Button.Back);
    }

}
