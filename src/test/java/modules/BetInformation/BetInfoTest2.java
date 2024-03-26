package modules.BetInformation;

import globals.TestConditions;
import globals.TestVariables;
import org.openqa.selenium.WebElement;
import pages.BetDetails;
import pages.BettingPanel;
import utilities.handlers.GetHandler;
import utilities.handlers.VerificationHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.Locator;
import utilities.objects.Printer;

import java.util.List;

public class BetInfoTest2 extends BetInformation {

    static String sideBet = TestVariables.BLACK;
    static Locator bettingOption = BettingPanel.Option.getSide(sideBet);
    static Locator bettingChip = BettingPanel.Chip.getSide(sideBet);

    public static void placeBetUntilLose() {
        boolean isError = true;
        do {
            try {
                placeBet(bettingOption);
                waitRoundResult();
                isError = false;
            } catch (Exception e) { Printer.printError("Failed to place a bet on " + bettingOption.getName()); }
        } while (isError || TestConditions.isBlackWin(roundResult));
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: BET INFORMATION");
        System.out.println("Test Case: 2");
        System.out.println("Other Information: " + tableName + " " + roundID + " " + Helper.toString(roundResult));
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(BetDetails.Label.BetDetails, 150);
        VerificationHandler.verifyIfDisplayed(BetDetails.Button.Back, 5);

        double expectedStake = totalBet;
        double actualStake = getCurrentStake();
        CustomAssert.assertEquals(expectedStake, actualStake,
                "** Stake is Correct: " + expectedStake + " == " + actualStake,
                "** Stake is Incorrect: " + expectedStake + " != " + actualStake);

        double expectedWinLoss = - (totalBet);
        double actualWinLoss = GetHandler.getDouble(BetDetails.Label.WinLoss);
        CustomAssert.assertEquals(expectedWinLoss, actualWinLoss,
                "** Win/Loss is Correct: " + expectedWinLoss + " == " + actualWinLoss,
                "** Win/Loss is Incorrect: " + expectedWinLoss + " != " + actualWinLoss);

        VerificationHandler.verifyIfDisplayed(BetDetails.Container.BettingOptions, 5);
        VerificationHandler.verifyIfDisplayed(bettingChip, 5);

        List<WebElement> winBettingOptions = GetHandler.getElements(BetDetails.Container.WinBettingOptions);
        int winCount = winBettingOptions.size();
        CustomAssert.assertNotEquals(0, winCount,
                "** Win Betting Options is Correct: " + winCount,
                "** Win Betting Options is Incorrect: " + 0);

        CustomAssert.assertFalse(isWins(winBettingOptions, sideBet),
                "** " + bettingOption.getName() + " Loses",
                "** " + bettingOption.getName() + " Wins");

        System.out.println();
    }

}
