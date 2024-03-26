package modules.Gameplay;

import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.CustomAssert;

public class GameTest7 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 7");
        System.out.println("Actual Results: ");

        int actualStartTime = GetHandler.getInt(DealerTable.Label.ShowTimer);
        int expectedStartTime = 45;
        CustomAssert.assertEquals(expectedStartTime, actualStartTime,
                "** Start Time of Betting Timer is Correct: " + expectedStartTime + " == " + actualStartTime,
                "** Start Time of Betting Timer is Incorrect: " + expectedStartTime + " != " + actualStartTime);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.PlaceYourBetsPlease, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.ShowTimer, 5);
        VerificationHandler.verifyIfContained(DealerTable.Container.BettingOptions, "class", "active", "Expanded");
        VerificationHandler.verifyIfNotContained(DealerTable.Button.ExpandShrink, "class", "disabled", "Enabled");
        String bettingOption = TestVariables.EVEN;
        VerificationHandler.verifyIfPlacedBet(BettingPanel.Option.getSide(bettingOption), BettingPanel.Chip.getSide(bettingOption));

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
