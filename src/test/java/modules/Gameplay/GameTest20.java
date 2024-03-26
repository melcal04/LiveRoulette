package modules.Gameplay;

import pages.DealerTable;
import pages.GameLobby;
import utilities.handlers.ConditionHandler;
import utilities.handlers.VerificationHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;

public class GameTest20 extends Gameplay {

    public static void verify() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        System.out.println("#9 Round Result: " + Helper.toString(getRoundResult()));

        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 20");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(GameLobby.Label.FindATable, 150);
        CustomAssert.assertTrue(ConditionHandler.isUrlContains("/dealerPage", 5),
                "** Player is on the Lobby",
                "** Player is Not on the Lobby");

        System.out.println();
    }

}
