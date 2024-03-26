package globals;

import pages.DealerTable;
import utilities.enums.HandleCollection;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Helper;
import utilities.objects.Locator;

public class TestMethods {

    /*********************************************************************************************************************
     ** The 'waitBettingPhase' method is used to wait for the betting phase for a duration within the timer.
     *********************************************************************************************************************/

    public static void waitBettingPhase(int specifiedTime, boolean isExact) {
        int currentTimerValue = isExact ? 100 : -1;
        while (isExact ? (currentTimerValue != specifiedTime) : (currentTimerValue < specifiedTime))
            currentTimerValue = GetHandler.getInt(DealerTable.Label.ShowTimer, HandleCollection.WithException);
    }

    /*********************************************************************************************************************
     ** The 'getRoundResult' method is used to fetch the round result from the Live Roulette Mobile Revamp.
     *********************************************************************************************************************/

    public static String[] getRoundResult() {
        WaitHandler.waitVisibility(DealerTable.Container.WinResult, 150);
        return GetHandler.getAttribute(DealerTable.Container.WinResult, "class")
                .replaceAll("bet_option num_bet_option num_bet_option_|bet_option_| minify win", "")
                .toUpperCase().split(" ");
    }

    /*********************************************************************************************************************
     ** The 'getUpdatedBalance' method is used to retrieve the balance after round results.
     *********************************************************************************************************************/

    public static double getUpdatedBalance() {
        WaitHandler.wait(3);
        return GetHandler.getDouble(DealerTable.Label.Balance);
    }

    /*********************************************************************************************************************
     ** The 'getChipValue' method is used to retrieve the value of a chip.
     *********************************************************************************************************************/

    public static int getChipValue(Locator chip) {
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
     * The 'getTableName' method is used to retrieve the table name within the dealer table.
     ***************************************************************************************************************/

    public static String getTableName() {
        String table = GetHandler.getText(DealerTable.Label.TableInfo).split("#")[0];
        String initial = Helper.getFirstChar(table);
        return "Roulette " + initial;
    }

    /***************************************************************************************************************
     * The 'getRoundId' method is used to retrieve the round ID within the dealer table.
     ***************************************************************************************************************/

    public static String getRoundId() {
        String tableInfo = GetHandler.getText(DealerTable.Label.TableInfo).split("#")[1];
        return "#" + tableInfo;
    }

}
