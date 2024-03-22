package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest5 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 5, payoutOdds = 1;
    private final String bettingOption = TestVariables.LOW;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isLowPlaced) return;
        else isLowPlaced = true;
        EventHandler.click(BettingPanel.Option.getSide(bettingOption));
    }

    public void checkBettingChip() {
        if (isLowPlaced) bet = getChipValue(BettingPanel.Chip.getSide(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (isLowPlaced && TestConditions.isLowWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("Low", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isLowPlaced && TestConditions.isLowWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest5 && payout.getTestCase() == testCase);
        }
    }

}
