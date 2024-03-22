package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest1 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 1, payoutOdds = 1;
    private final String bettingOption = TestVariables.RED;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isRedPlaced) return;
        else isRedPlaced = true;
        EventHandler.click(BettingPanel.Option.getSide(bettingOption));
    }

    public void checkBettingChip() {
        if (isRedPlaced) bet = getChipValue(BettingPanel.Chip.getSide(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (isRedPlaced && TestConditions.isRedWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("Red", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isRedPlaced && TestConditions.isRedWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest1 && payout.getTestCase() == testCase);
        }
    }

}
