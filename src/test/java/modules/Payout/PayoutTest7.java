package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest7 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 7, payoutOdds = 2;
    private final String bettingOption = TestVariables.FIRST_DOZEN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (is1stDozenPlaced) return;
        else is1stDozenPlaced = true;
        EventHandler.click(BettingPanel.Option.getDozen(bettingOption));
    }

    public void checkBettingChip() {
        if (is1stDozenPlaced) bet = getChipValue(BettingPanel.Chip.getDozen(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (is1stDozenPlaced && TestConditions.is1stDozenWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("1st Dozen", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (is1stDozenPlaced && TestConditions.is1stDozenWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest7 && payout.getTestCase() == testCase);
        }
    }

}
