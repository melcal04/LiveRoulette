package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest8 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 8, payoutOdds = 2;
    private final String bettingOption = TestVariables.SECOND_DOZEN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (is2ndDozenPlaced) return;
        else is2ndDozenPlaced = true;
        EventHandler.click(BettingPanel.Option.getDozen(bettingOption));
    }

    public void checkBettingChip() {
        if (is2ndDozenPlaced) bet = getChipValue(BettingPanel.Chip.getDozen(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (is2ndDozenPlaced && TestConditions.is2ndDozenWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("2nd Dozen", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (is2ndDozenPlaced && TestConditions.is2ndDozenWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest8 && payout.getTestCase() == testCase);
        }
    }

}
