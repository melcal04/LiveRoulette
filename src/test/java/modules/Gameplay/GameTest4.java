package modules.Gameplay;

import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest4 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 4");
        System.out.println("Actual Results: ");

        String targetTable = getTableName();
        waitUntilBettingPhaseOpen();
        EventHandler.click(DealerTable.Button.Back);
        EventHandler.click(GameLobby.Method.getDealerTable(targetTable), HandleCollection.WithException);

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.PlaceYourBetsPlease, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.WelcomeAndGoodLuck, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.ShowTimer, 5);
        VerificationHandler.verifyIfContained(DealerTable.Container.BettingOptions, "class", "active", "Expanded");
        VerificationHandler.verifyIfNotContained(DealerTable.Button.ExpandShrink, "class", "disabled", "Enabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
