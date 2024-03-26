package modules.BetInformation;

import globals.TestMethods;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Locator;

import java.util.List;

public class BetInformation extends TestMethods {

    protected static String[] roundResult;
    protected static double totalBet;
    protected static String roundID, tableName;

    protected static void placeBet(Locator bettingOption) {
        waitBettingPhase(10, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        EventHandler.click(bettingOption);
        EventHandler.click(DealerTable.Button.Confirm);
    }

    protected static void waitRoundResult() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        totalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        tableName = getTableName();
        roundID = getRoundId();
        roundResult = getRoundResult();
    }

    protected static double getCurrentStake() {
        WaitHandler.wait(2);
        return GetHandler.getDouble(BetDetails.Label.Stake);
    }

    public static void goToBetDetails() {
        EventHandler.click(DealerTable.Button.Menu);
        EventHandler.click(Menu.Button.MyBets);
        EventHandler.click(MyBets.Method.getDetailsButton(roundID), HandleCollection.WithScroll);
    }

    public static boolean isWins(List<WebElement> winBettingOptions, String betOption) {
        for (WebElement winBettingOption : winBettingOptions)
            if (winBettingOption.getAttribute("class").contains(betOption)) return true;
        return false;
    }

}
