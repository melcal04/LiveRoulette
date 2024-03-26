package modules.Gameplay;

import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest5 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 5");
        System.out.println("Actual Results: ");

        String targetTable = getTableName();
        waitUntilBettingPhaseClose();
        EventHandler.click(DealerTable.Button.Back);
        EventHandler.click(GameLobby.Method.getDealerTable(targetTable), HandleCollection.WithException);

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.NoMoreBets, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.WelcomeAndGoodLuck, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.ShowDealing, 5);
        VerificationHandler.verifyIfNotContained(DealerTable.Container.BettingOptions, "class", "active", "Shrunk");
        VerificationHandler.verifyIfContained(DealerTable.Button.ExpandShrink, "class", "disabled", "Disabled");

        System.out.println();

        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 12");
        System.out.println("Actual Results: ");

        for (String side : TestVariables.SIDE_LIST)
            VerificationHandler.verifyIfContained(BettingPanel.Option.getSide(side), "class", "disabled", "Disabled");
        for (String dozen : TestVariables.DOZEN_LIST)
            VerificationHandler.verifyIfContained(BettingPanel.Option.getDozen(dozen), "class", "disabled", "Disabled");
        for (int column : TestVariables.COLUMN_LIST)
            VerificationHandler.verifyIfContained(BettingPanel.Option.getColumn(column), "class", "disabled", "Disabled");
        for (int number = 0; number < 37; number++)
            VerificationHandler.verifyIfContained(BettingPanel.Option.getStraightUp(number), "class", "disabled", "Disabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
