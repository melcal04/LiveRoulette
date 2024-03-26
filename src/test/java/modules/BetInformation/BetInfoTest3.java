package modules.BetInformation;

import globals.TestConditions;
import globals.TestVariables;
import pages.BetDetails;
import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.Locator;
import utilities.objects.Printer;

public class BetInfoTest3 extends BetInformation {

    static int numberBet = 4, columnBet = TestVariables.FIRST_COLUMN;
    static String colorBet = TestVariables.BLACK, evenBet = TestVariables.EVEN, highBet = TestVariables.HIGH, dozenBet = TestVariables.FIRST_DOZEN;
    static int[][] sixLineBet = TestVariables.SIX_LINE_LIST[0], splitBet = TestVariables.SPLIT_LIST[3], streetBet = TestVariables.STREET_LIST[1];

    public static void placeBet() {
        boolean isError = true;
        do {
            try {
                waitBettingPhase(30, false);
                WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
                EventHandler.click(BettingPanel.Option.getStraightUp(numberBet));
                EventHandler.click(BettingPanel.Option.getSixLine(sixLineBet));
                EventHandler.click(BettingPanel.Option.getSplit(splitBet));
                EventHandler.click(BettingPanel.Option.getStreet(streetBet));
                EventHandler.click(BettingPanel.Option.getSide(colorBet));
                EventHandler.click(BettingPanel.Option.getSide(evenBet));
                EventHandler.click(BettingPanel.Option.getSide(highBet));
                EventHandler.click(BettingPanel.Option.getDozen(dozenBet));
                EventHandler.click(BettingPanel.Option.getColumn(columnBet));
                EventHandler.click(DealerTable.Button.Confirm);
                waitRoundResult();
                isError = false;
            } catch (Exception e) { Printer.printError("Failed to place a multiple bets"); }
        } while (isError);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: BET INFORMATION");
        System.out.println("Test Case: 3");
        System.out.println("Other Information: " + tableName + " " + roundID + " " + Helper.toString(roundResult));
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(BetDetails.Label.BetDetails, 150);
        VerificationHandler.verifyIfDisplayed(BetDetails.Button.Back, 5);

        double expectedStake = totalBet;
        double actualStake = getCurrentStake();
        CustomAssert.assertEquals(expectedStake, actualStake,
                "** Stake is Correct: " + expectedStake + " == " + actualStake,
                "** Stake is Incorrect: " + expectedStake + " != " + actualStake);

        double expectedWinLoss = getExpectedPayout() - totalBet;
        double actualWinLoss = GetHandler.getDouble(BetDetails.Label.WinLoss);
        CustomAssert.assertEquals(expectedWinLoss, actualWinLoss,
                "** Win/Loss is Correct: " + expectedWinLoss + " == " + actualWinLoss,
                "** Win/Loss is Incorrect: " + expectedWinLoss + " != " + actualWinLoss);

        VerificationHandler.verifyIfDisplayed(BetDetails.Container.BettingOptions, 5);

        int expectedBetSize = 9;
        int actualBetSize = GetHandler.getElements(BetDetails.Label.BettingChips).size();
        CustomAssert.assertEquals(expectedBetSize, actualBetSize,
                "** Betting Chips is Correct: " + expectedBetSize + " == " + actualBetSize,
                "** Betting Chips is Incorrect: " + expectedBetSize + " != " + actualBetSize);

        int winCount = GetHandler.getElements(BetDetails.Container.WinBettingOptions).size();
        CustomAssert.assertNotEquals(0, winCount,
                "** Win Betting Options is Correct: " + winCount,
                "** Win Betting Options is Incorrect: " + 0);

        System.out.println();
    }

    private static double getExpectedPayout() {
        double expectedWinLoss = 0.0;
        expectedWinLoss += getPayout(35, TestConditions.isStraightUpWin(roundResult, numberBet), BettingPanel.Chip.getStraightUp(numberBet));
        expectedWinLoss += getPayout(5, TestConditions.isPosBetWin(roundResult, sixLineBet), BettingPanel.Chip.getSixLine(sixLineBet));
        expectedWinLoss += getPayout(17, TestConditions.isPosBetWin(roundResult, splitBet), BettingPanel.Chip.getSplit(splitBet));
        expectedWinLoss += getPayout(11, TestConditions.isPosBetWin(roundResult, streetBet), BettingPanel.Chip.getStreet(streetBet));
        expectedWinLoss += getPayout(1, TestConditions.isBlackWin(roundResult), BettingPanel.Chip.getSide(colorBet));
        expectedWinLoss += getPayout(1, TestConditions.isEvenWin(roundResult), BettingPanel.Chip.getSide(evenBet));
        expectedWinLoss += getPayout(1, TestConditions.isHighWin(roundResult), BettingPanel.Chip.getSide(highBet));
        expectedWinLoss += getPayout(2, TestConditions.is1stDozenWin(roundResult), BettingPanel.Chip.getDozen(dozenBet));
        expectedWinLoss += getPayout(2, TestConditions.is1stColumnWin(roundResult), BettingPanel.Chip.getColumn(columnBet));
        return expectedWinLoss;
    }

    private static double getPayout(int multiplier, boolean condition, Locator chipValue) {
        if (condition) {
            int bet = getChipValue(chipValue);
            return bet * multiplier + bet;
        }
        return 0;
    }

}
