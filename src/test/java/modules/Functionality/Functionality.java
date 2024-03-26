package modules.Functionality;

import globals.TestMethods;
import globals.TestVariables;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Locator;

import java.util.List;

public class Functionality extends TestMethods {

    protected static String roundId;
    protected static double oldBalance;

    public static void goBackToTheGameLobby() {
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back, 1);
    }

    private static void goToMenu() {
        EventHandler.click(DealerTable.Button.Menu, 1);
    }

    public static void goToMyBets() {
        goToMenu();
        EventHandler.click(Menu.Button.MyBets, 3);
    }

    public static void goToTheBetDetails() {
        EventHandler.click(MyBets.Method.getDetailsButton(roundId), HandleCollection.WithScroll);
    }

    public static void goToLimitsAndPayouts() {
        goToMenu();
        EventHandler.click(Menu.Button.LimitPayouts, 3);
    }

    public static void goToHelp() {
        goToMenu();
        EventHandler.click(Menu.Button.Help, 3);
    }

    public static void goToSettings() {
        goToMenu();
        EventHandler.click(Menu.Button.Settings, 3);
    }

    public static void placeABetOnAnyBettingOptions() {
        waitBettingPhase(40, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        roundId = getRoundId();
        oldBalance = GetHandler.getDouble(DealerTable.Label.Balance);
        GetHandler.getElements(DealerTable.Button.ChipOptions).get(1).click();
        EventHandler.click(BettingPanel.Option.getSide(TestVariables.RED));
    }

    public static void placeAndConfirmAnyBettingOptions() {
        placeABetOnAnyBettingOptions();
        EventHandler.click(DealerTable.Button.Confirm);
    }

    public static void waitUntilRoundIsOver() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        waitBettingPhase(0, false);
    }

    public static void clickTheHighTableLimits() {
        Locator tableLimits = GameLobby.Button.TableLimits;
        List<WebElement> elements = GetHandler.getElements(tableLimits);
        EventHandler.click(elements.get(1));
    }

}
