package modules.Gameplay;

import globals.TestMethods;
import globals.TestVariables;
import pages.BettingPanel;
import pages.DealerTable;
import pages.LimitsAndPayouts;
import pages.Menu;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Locator;

public class Gameplay extends TestMethods {

    protected static final Locator DEFAULT_BETTING_OPTION = BettingPanel.Option.getSide(TestVariables.RED);
    protected static final Locator DEFAULT_BETTING_CHIP = BettingPanel.Chip.getSide(TestVariables.RED);
    protected static double balanceBeforeBetting;

    public static void waitUntilBettingPhaseOpen() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
    }

    public static void waitUntilBettingPhaseClose() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
    }

    public static void placeABetOnAnyBettingOptions() {
        balanceBeforeBetting = GetHandler.getDouble(DealerTable.Label.Balance);
        waitBettingPhase(40, false);
        WaitHandler.wait(1);
        EventHandler.click(DEFAULT_BETTING_OPTION);
    }

    public static void placeAndConfirmAnyBettingOptions() {
        placeABetOnAnyBettingOptions();
        EventHandler.click(DealerTable.Button.Confirm);
    }

    public static void placeAMaximumBetOnAnyBettingOptions() {
        double max = getBetLimit()[1];
        waitBettingPhase(40, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        WaitHandler.wait(1);
        double bet;
        do {
            EventHandler.click(BettingPanel.Option.getStraightUp(4));
            bet = getChipValue(BettingPanel.Chip.getStraightUp(4));
        } while (bet < max);
    }

    public static void placeAMinimumBetOnAnyBettingOptions() {
        double min = getBetLimit()[0];
        waitBettingPhase(40, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        WaitHandler.wait(1);
        double bet;
        do {
            EventHandler.click(BettingPanel.Option.getStraightUp(4));
            bet = getChipValue(BettingPanel.Chip.getStraightUp(4));
        } while (bet < min);
    }

    private static double[] getBetLimit() {
        EventHandler.click(DealerTable.Button.Menu);
        EventHandler.click(Menu.Button.LimitPayouts);
        String[] limitText = GetHandler.getText(LimitsAndPayouts.Label.StraightUpLimit).split(" - ");
        double min = Double.parseDouble(limitText[0]);
        double max = Double.parseDouble(limitText[1]);
        EventHandler.click(LimitsAndPayouts.Button.Back);
        EventHandler.click(50, 50);
        return new double[]{ min, max };
    }

}
