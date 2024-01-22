package globals;

import org.openqa.selenium.WebElement;
import pages.ChipSettings;
import pages.DealerTable;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.objects.Component;
import java.util.List;

public class TestMethod {

    /***************************************************************************************************************
     * The 'verifyDisplay' method is used to confirm the visibility of an element and print an error message.
     ***************************************************************************************************************/

    public static void verifyDisplay(Component component) {
        String name = component.getName();
        String type = component.getType();
        String page = component.getPage();
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(component),
                "** \"" + name + "\" " + type + " on " + page + " is Displayed",
                "** \"" + name + "\" " + type + " on " + page + " is Not Displayed");
    }

    /***************************************************************************************************************
     * The 'waitBettingPhase' method is used to wait for the betting phase for a duration within the timer.
     ***************************************************************************************************************/

    public static void waitBettingPhase(int specifiedTime, boolean isExact) {
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        int currentTimerValue = isExact ? 45 : -1;
        while (isExact ? (currentTimerValue != specifiedTime) : (currentTimerValue < specifiedTime))
            currentTimerValue = GetHandler.getInt(DealerTable.Label.ShowTimer, HandleCollection.WithException);
    }

    /***************************************************************************************************************
     * The 'getRoundResult' method is used to fetch the round result from the game.
     ***************************************************************************************************************/

    public static String[] getRoundResult() {
        WaitHandler.waitVisibility(DealerTable.Container.NumberResult, 150);
        return GetHandler.getAttribute(DealerTable.Container.NumberResult, "class")
                .replaceAll("bet_option num_bet_option num_bet_option_|bet_option_| minify win", "")
                .toUpperCase().split(" ");
    }

    /***************************************************************************************************************
     * The 'getChipValue' method is used to retrieve the value of a chip.
     ***************************************************************************************************************/

    public static int getChipValue(Component chip) {
        String chipText = GetHandler.getText(chip);
        if (chipText.endsWith("K")) return GetHandler.getInt(chip) * 1000;
        else if (chipText.endsWith("M")) return GetHandler.getInt(chip) * 1000000;
        return switch (chipText) {
            case "1" -> 1;
            case "5" -> 5;
            case "10" -> 10;
            case "25" -> 25;
            case "100" -> 100;
            case "500" -> 500;
            default -> GetHandler.getInt(chip);
        };
    }

    /***************************************************************************************************************
     * The 'setDefaultChips' method is used to set all chips to the lowest value.
     ***************************************************************************************************************/

    public static void setDefaultChips() {
        EventHandler.click(DealerTable.Button.EditChips);
        List<WebElement> myChips = GetHandler.getElements(ChipSettings.Container.MyChips);
        for (WebElement myChip : myChips) EventHandler.click(ChipSettings.Container.MyChips, myChip);
        EventHandler.click(ChipSettings.Method.getChipSelection("1"));
        EventHandler.click(ChipSettings.Method.getChipSelection("5"));
        EventHandler.click(ChipSettings.Method.getChipSelection("10"));
        EventHandler.click(ChipSettings.Method.getChipSelection("25"));
        EventHandler.click(ChipSettings.Button.Save);
    }

    /***************************************************************************************************************
     * The 'getTableName' method is used to retrieve the table name within the dealer table.
     ***************************************************************************************************************/

    public static String getTableName() {
        String table = GetHandler.getText(DealerTable.Label.TableInfo).split("#")[0];
        String initial = DataTypeHandler.getFirstChar(table);
        return "Roulette " + initial;
    }

    /***************************************************************************************************************
     * The 'getRoundId' method is used to retrieve the round ID within the dealer table.
     ***************************************************************************************************************/

    public static String getRoundId() {
        String tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        return tableInfo.split("#")[1];
    }

    /***************************************************************************************************************
     * The 'getUpdatedBalance' method is used to retrieve the balance after round results.
     ***************************************************************************************************************/

    public static double getUpdatedBalance() {
        WaitHandler.wait(15);
        return GetHandler.getDouble(DealerTable.Label.BalanceValue);
    }

}
