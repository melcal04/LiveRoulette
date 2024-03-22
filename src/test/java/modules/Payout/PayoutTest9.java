package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest9 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 9, payoutOdds = 2;
    private final String bettingOption = TestVariables.THIRD_DOZEN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (is3rdDozenPlaced) return;
        else is3rdDozenPlaced = true;
        EventHandler.click(BettingPanel.Option.getDozen(bettingOption));
    }

    public void checkBettingChip() {
        if (is3rdDozenPlaced) bet = getChipValue(BettingPanel.Chip.getDozen(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (is3rdDozenPlaced && TestConditions.is3rdDozenWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("3rd Dozen", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (is3rdDozenPlaced && TestConditions.is3rdDozenWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest9 && payout.getTestCase() == testCase);
        }
    }

}
