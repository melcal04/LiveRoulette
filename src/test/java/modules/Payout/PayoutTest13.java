package modules.Payout;

import globals.TestConditions;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest13 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 13, payoutOdds = 35, bettingOption = 37;
    private final double[] chipValueList = new double[bettingOption];

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isStraightUpPlaced) return;
        else isStraightUpPlaced = true;
        for (int i = 0; i < bettingOption; i++)
            EventHandler.click(BettingPanel.Option.getStraightUp(i));
    }

    public void checkBettingChip() {
        if (isStraightUpPlaced)
            for (int i = 0; i < bettingOption; i++)
                chipValueList[i] = getChipValue(BettingPanel.Chip.getStraightUp(i));
    }

    public void computeWinResult(String[] roundResult) {
        if (isStraightUpPlaced) {
            for (int i = 0; i < bettingOption; i++) {
                if (TestConditions.isStraightUpWin(roundResult, i)) {
                    bet = chipValueList[i];
                    payout = bet + (bet * payoutOdds);
                    addWin("Straight Up #" + i, bet, payoutOdds);
                }
            }
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isStraightUpPlaced) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest13 && payout.getTestCase() == testCase);
        }
    }

}
