package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest6 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 6, payoutOdds = 1;
    private final String bettingOption = TestVariables.HIGH;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isHighPlaced) return;
        else isHighPlaced = true;
        EventHandler.click(BettingPanel.Option.getSide(bettingOption));
    }

    public void checkBettingChip() {
        if (isHighPlaced) bet = getChipValue(BettingPanel.Chip.getSide(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (isHighPlaced && TestConditions.isHighWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("High", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isHighPlaced && TestConditions.isHighWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest6 && payout.getTestCase() == testCase);
        }
    }

}
