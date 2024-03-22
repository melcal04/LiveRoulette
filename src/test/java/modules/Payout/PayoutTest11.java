package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest11 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 11, payoutOdds = 2, bettingOption = TestVariables.SECOND_COLUMN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (is2ndColumnPlaced) return;
        else is2ndColumnPlaced = true;
        EventHandler.click(BettingPanel.Option.getColumn(bettingOption));
    }

    public void checkBettingChip() {
        if (is2ndColumnPlaced) bet = getChipValue(BettingPanel.Chip.getColumn(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (is2ndColumnPlaced && TestConditions.is2ndColumnWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("2nd Column", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (is2ndColumnPlaced && TestConditions.is2ndColumnWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest11 && payout.getTestCase() == testCase);
        }
    }

}
