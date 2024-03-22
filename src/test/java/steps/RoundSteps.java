package steps;

import globals.TestMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import modules.Payout.Payout;
import pages.DealerTable;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;
import utilities.objects.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RoundSteps extends TestMethods {

    static List<PayoutTestCase> payoutTestCaseList;
    static List<PayoutTestCase> ignoredPayoutTestCase;
    static String[] roundResult;

    @Then("I Place A Bet Until There Is A Round Result For All Payouts")
    public void iPlaceABetUntilThereIsARoundResultForAllPayouts(DataTable dataTable) {
        payoutTestCaseList = Payout.getPayoutTestCaseFirstBatch(dataTable.asList(String.class));
        waitUntilWins();
        TextFileFeature.write();
        EventHandler.click(DealerTable.Button.Back);
    }

    private static void waitUntilWins() {
        for (int round = 1; round <= 50; round++) {
            try {

                ignoredPayoutTestCase = new ArrayList<>();
                System.out.println();
                System.out.println("Round #" + round);
                System.out.println();

                setBeforeBetting();
                setBettingOption();
                setAfterBetting();
                setDealingResult();
                setAfterDealing();

                System.out.println("    " + payoutTestCaseList.size() + " Test Cases Left: " + Helper.toString(Payout.getTestCaseList(payoutTestCaseList)));
                System.out.println("    " + ignoredPayoutTestCase.size() + " Ignored Test Cases: " + Helper.toString(Payout.getTestCaseList(ignoredPayoutTestCase)));

                if (payoutTestCaseList.isEmpty()) {
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
        Payout.initializeBeforeBetting();
    }

    private static void setBettingOption() {
        waitBettingPhase(40, false);
        WaitHandler.wait(1);
        processPayoutCases(PayoutTestCase::placeBettingOption);
        EventHandler.click(DealerTable.Button.Confirm, 1);
    }

    private static void setAfterBetting() {
        processPayoutCases(PayoutTestCase::checkBettingChip);
        Payout.initializeAfterBetting();
    }

    private static void setDealingResult() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        roundResult = getRoundResult();
        System.out.println("    Round Result: " + Helper.toString(roundResult));
    }

    private static void setAfterDealing() {
        processPayoutCases(payoutTestCase -> payoutTestCase.computeWinResult(roundResult));
        WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        Payout.initializeAfterDealing(roundResult);
        processPayoutCases(payoutTestCase -> payoutTestCase.saveTestCase(roundResult, payoutTestCaseList));
    }

    private static void processPayoutCases(Consumer<PayoutTestCase> action) {
        for (PayoutTestCase payoutTestCase : new ArrayList<>(payoutTestCaseList)) {
            try {
                if (!ignoredPayoutTestCase.contains(payoutTestCase)) action.accept(payoutTestCase);
            } catch (Exception e) {
                ignoredPayoutTestCase.add(payoutTestCase);
                Printer.printError("Test Case " + payoutTestCase.getTestCase() + ": " + e.getMessage());
            }
        }
    }

}
