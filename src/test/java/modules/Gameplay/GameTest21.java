package modules.Gameplay;

import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest21 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 21");
        System.out.println("Actual Results: ");

        placeAMaximumBetOnAnyBettingOptions();
        EventHandler.click(BettingPanel.Option.getStraightUp(4));
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.ExceededTheMaxBet, 150);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
