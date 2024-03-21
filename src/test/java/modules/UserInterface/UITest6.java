package modules.UserInterface;

import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class UITest6 extends UserInterface {

    public static void verify() {
        System.out.println();
        System.out.println("Module: PAYOUT");
        System.out.println("Test Case: 1");
        System.out.println("Actual Results: ");

        for (String side : TestVariables.SIDE_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getSide(side), 5);

        for (String dozen : TestVariables.DOZEN_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getDozen(dozen), 5);

        for (int column : TestVariables.COLUMN_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getColumn(column), 5);

        for (int i = 0; i < 37; i++)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getNumber(i), 5);

        for (int[][] split : TestVariables.SPLIT_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getSplit(split), 5);

        for (int[][] street : TestVariables.STREET_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getStreet(street), 5);

        for (int[][] corner : TestVariables.CORNER_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getCorner(corner), 5);

        for (int[][] sixLine : TestVariables.SIX_LINE_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getSixLine(sixLine), 5);

        for (int[][] zeroSection : TestVariables.ZERO_SECTION_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getZeroSection(zeroSection), 5);

        for (int[][] zeroCorner : TestVariables.ZERO_CORNER_LIST)
            VerificationHandler.verifyIfDisplayed(BettingPanel.Option.getZeroCorner(zeroCorner), 5);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
