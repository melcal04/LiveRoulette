package modules.Gameplay;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.CustomAssert;
import utilities.objects.Locator;

import java.util.ArrayList;
import java.util.List;

public class GameTest15 extends Gameplay {

    static int[] rouletteNumbers = new int[]
            {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 15");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Container.RoundResult, 150);
        int actualNumberResult = GetHandler.getInt(DealerTable.Label.RoundResultNumber);
        int actualNumberLeft = GetHandler.getInt(DealerTable.Label.RoundResultLeftNumber);
        int actualNumberRight = GetHandler.getInt(DealerTable.Label.RoundResultRightNumber);
        String[] roundResult = getRoundResult();

        int expectedNumberResult = Integer.parseInt(roundResult[0]);
        CustomAssert.assertEquals(expectedNumberResult, actualNumberResult,
                "** Number Result is Correct: " + expectedNumberResult + " == " + actualNumberResult,
                "** Number Result is Incorrect: " + expectedNumberResult + " != " + actualNumberResult);

        int expectedNumberLeft = getNumberToLeft(expectedNumberResult);
        CustomAssert.assertEquals(expectedNumberLeft, actualNumberLeft,
                "** Left Number is Correct: " + expectedNumberLeft + " == " + actualNumberLeft,
                "** Left Number is Incorrect: " + expectedNumberLeft + " != " + actualNumberLeft);

        int expectedNumberRight = getNumberToRight(expectedNumberResult);
        CustomAssert.assertEquals(expectedNumberRight, actualNumberRight,
                "** Right Number is Correct: " + expectedNumberRight + " == " + actualNumberRight,
                "** Right Number is Incorrect: " + expectedNumberRight + " != " + actualNumberRight);

        CustomAssert.assertTrue(isHighLighted(roundResult),
                "** All Winning Betting Options is Highlighted",
                "** All Winning Betting Options is Not Highlighted");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

    public static int getNumberToLeft(int targetNumber) {
        int targetIndex = findIndex(targetNumber);
        int leftIndex = (targetIndex + rouletteNumbers.length - 1) % rouletteNumbers.length;
        return rouletteNumbers[leftIndex];
    }

    public static int getNumberToRight(int targetNumber) {
        int targetIndex = findIndex(targetNumber);
        int rightIndex = (targetIndex + 1) % rouletteNumbers.length;
        return rouletteNumbers[rightIndex];
    }

    private static int findIndex(int targetNumber) {
        for (int i = 0; i < rouletteNumbers.length; i++) if (rouletteNumbers[i] == targetNumber) return i;
        return -1;
    }

    private static boolean isHighLighted(String[] roundResult) {
        for (Locator locator : getBettingOptions(roundResult))
            if(!GetHandler.getAttribute(locator, "class").contains("win")) return false;
        return true;
    }

    private static List<Locator> getBettingOptions(String[] roundResult) {
        List<Locator> bettingOptions = new ArrayList<>();
        if(TestConditions.isRedWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getSide(TestVariables.RED));
        if(TestConditions.isBlackWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getSide(TestVariables.BLACK));
        if(TestConditions.isEvenWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getSide(TestVariables.EVEN));
        if(TestConditions.isOddWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getSide(TestVariables.ODD));
        if(TestConditions.isLowWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getSide(TestVariables.LOW));
        if(TestConditions.isHighWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getSide(TestVariables.HIGH));
        if(TestConditions.is1stDozenWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getDozen(TestVariables.FIRST_DOZEN));
        if(TestConditions.is2ndDozenWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getDozen(TestVariables.SECOND_DOZEN));
        if(TestConditions.is3rdDozenWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getDozen(TestVariables.THIRD_DOZEN));
        if(TestConditions.is1stColumnWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getColumn(TestVariables.FIRST_COLUMN));
        if(TestConditions.is2ndColumnWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getColumn(TestVariables.SECOND_COLUMN));
        if(TestConditions.is3rdColumnWin(roundResult))
            bettingOptions.add(BettingPanel.Option.getColumn(TestVariables.THIRD_COLUMN));
        return bettingOptions;
    }

}
