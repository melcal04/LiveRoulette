package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.objects.CustomAssert;

public class GameTest9 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 9");
        System.out.println("Actual Results: ");

        CustomAssert.assertTrue(ConditionHandler.isDisplayed(DEFAULT_BETTING_CHIP, 5),
                "** " + DEFAULT_BETTING_CHIP.getName() + " is Placed on " + DEFAULT_BETTING_OPTION.getName(),
                "** " + DEFAULT_BETTING_CHIP.getName() + " is Not Placed on " + DEFAULT_BETTING_OPTION.getName());

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
