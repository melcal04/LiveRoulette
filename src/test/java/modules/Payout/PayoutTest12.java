package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest12 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 12, payoutOdds = 2, bettingOption = TestVariables.THIRD_COLUMN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (is3rdColumnPlaced) return;
        else is3rdColumnPlaced = true;
        EventHandler.click(BettingPanel.Option.getColumn(bettingOption));
    }

    public void checkBettingChip() {
        if (is3rdColumnPlaced) bet = getChipValue(BettingPanel.Chip.getColumn(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (is3rdColumnPlaced && TestConditions.is3rdColumnWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("3rd Column", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (is3rdColumnPlaced && TestConditions.is3rdColumnWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest12 && payout.getTestCase() == testCase);
        }
    }

}
