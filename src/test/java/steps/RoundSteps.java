package steps;

import globals.TestMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import modules.Payout.Payout;
import modules.ResultAndStatistics.ResAndStats;
import pages.DealerTable;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Helper;
import utilities.objects.Printer;

public class RoundSteps extends TestMethods {

    static String[] roundResult;

    @Then("I Place A Bet Until There Is A Round Result For All Payouts")
    public void iPlaceABetUntilThereIsARoundResultForAllPayouts(DataTable dataTable) {
        Payout.init(dataTable.asList(String.class));
        ResAndStats.init(dataTable.asList(String.class));
        waitUntilWins();
        TextFileFeature.write();
        EventHandler.click(DealerTable.Button.Back);
    }

    private static void waitUntilWins() {
        waitBettingPhase(45, true);
        for (int round = 1; round <= 50; round++) {
            try {

                System.out.println();
                System.out.println("Round #" + round);
                System.out.println();

                setBeforeBetting();
                setBettingOption();
                setAfterBetting();
                setDealingResult();
                setAfterDealing();

                if (Payout.isCompleted() && ResAndStats.isCompleted()) {
                    System.out.println();
                    System.out.println("Total Rounds To Complete: " + round);
                    System.out.println();
                    break;
                }

            } catch (Exception e) {
                Printer.printError("Failed on round #" + round + " due to the following cause: " + e.getMessage());
                throw e;
            }
        }
    }

    private static void setBeforeBetting() {
        Payout.setBeforeBetting();
    }

    private static void setBettingOption() {
        waitBettingPhase(10, false);
        WaitHandler.wait(1);
        Payout.setBettingOption();
        if (Payout.isCompleted()) ResAndStats.setBettingOption();
    }

    private static void setAfterBetting() {
        Payout.setAfterBetting();
    }

    private static void setDealingResult() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        roundResult = getRoundResult();
        System.out.println("    Round Result: " + Helper.toString(roundResult));
    }

    private static void setAfterDealing() {
        WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        Payout.setAfterDealing(roundResult);
        ResAndStats.setAfterDealing(roundResult);
    }

}
