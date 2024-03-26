package modules.Gameplay;

import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;
import utilities.handlers.WaitHandler;

public class GameTest8 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 8");
        System.out.println("Actual Results: ");

        waitUntilBettingPhaseOpen();
        WaitHandler.wait(1);

        for (String side : TestVariables.SIDE_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getSide(side), BettingPanel.Chip.getSide(side));

        for (String dozen : TestVariables.DOZEN_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getDozen(dozen), BettingPanel.Chip.getDozen(dozen));

        for (int column : TestVariables.COLUMN_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getColumn(column), BettingPanel.Chip.getColumn(column));

        for (int number = 0; number < 37; number++)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getStraightUp(number), BettingPanel.Chip.getStraightUp(number));

        for (int[][] split : TestVariables.SPLIT_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getSplit(split), BettingPanel.Chip.getSplit(split));

        for (int[][] street : TestVariables.STREET_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getStreet(street), BettingPanel.Chip.getStreet(street));

        for (int[][] corner : TestVariables.CORNER_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getCorner(corner), BettingPanel.Chip.getCorner(corner));

        for (int[][] sixLine : TestVariables.SIX_LINE_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getSixLine(sixLine), BettingPanel.Chip.getSixLine(sixLine));

        for (int[][] zeroSection : TestVariables.ZERO_SECTION_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getZeroSection(zeroSection), BettingPanel.Chip.getZeroSection(zeroSection));

        for (int[][] zeroCorner : TestVariables.ZERO_CORNER_LIST)
            VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getZeroCorner(zeroCorner), BettingPanel.Chip.getZeroCorner(zeroCorner));

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
