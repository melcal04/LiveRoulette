package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest2 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 2, payoutOdds = 1;
    private final String bettingOption = TestVariables.BLACK;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isBlackPlaced) return;
        else isBlackPlaced = true;
        EventHandler.click(BettingPanel.Option.getSide(bettingOption));
    }

    public void checkBettingChip() {
        if (isBlackPlaced) bet = getChipValue(BettingPanel.Chip.getSide(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (isBlackPlaced && TestConditions.isBlackWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("Black", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isBlackPlaced && TestConditions.isBlackWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest2 && payout.getTestCase() == testCase);
        }
    }

}
