package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.ConditionHandler;
import utilities.handlers.VerificationHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;

public class GameTest19 extends Gameplay {

    public static void verify() {
        System.out.println();

        byte count = 0;
        do {
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            System.out.println("#" + (++count) + " Round Result: " + Helper.toString(getRoundResult()));
            WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        } while (count < 8);

        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 19");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(DealerTable.Label.GiveItATry, 5);
        CustomAssert.assertTrue(ConditionHandler.isUrlContains("/roulette", 5),
                "** Player is Seated on the Current Table",
                "** Player is Not Seated on the Current Table");

        System.out.println();
    }

}
