package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest10 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 10, payoutOdds = 2, bettingOption = TestVariables.FIRST_COLUMN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (is1stColumnPlaced) return;
        else is1stColumnPlaced = true;
        EventHandler.click(BettingPanel.Option.getColumn(bettingOption));
    }

    public void checkBettingChip() {
        if (is1stColumnPlaced) bet = getChipValue(BettingPanel.Chip.getColumn(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (is1stColumnPlaced && TestConditions.is1stColumnWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("1st Column", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (is1stColumnPlaced && TestConditions.is1stColumnWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest10 && payout.getTestCase() == testCase);
        }
    }

}
