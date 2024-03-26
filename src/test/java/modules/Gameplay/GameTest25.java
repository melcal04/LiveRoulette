package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;
import utilities.objects.CustomAssert;

public class GameTest25 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 25");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.YourBetsAreBeingSettled, 5);
        CustomAssert.assertTrue(ConditionHandler.isUrlContains("/roulette", 5),
                "** Player is Seated on the Current Table",
                "** Player is Not Seated on the Current Table");

        System.out.println();
        waitUntilBettingPhaseOpen();
        EventHandler.click(DealerTable.Button.Back);
    }

}
