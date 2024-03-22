package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest4 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 4, payoutOdds = 1;
    private final String bettingOption = TestVariables.ODD;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isOddPlaced) return;
        else isOddPlaced = true;
        EventHandler.click(BettingPanel.Option.getSide(bettingOption));
    }

    public void checkBettingChip() {
        if (isOddPlaced) bet = getChipValue(BettingPanel.Chip.getSide(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (isOddPlaced && TestConditions.isOddWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("Odd", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isOddPlaced && TestConditions.isOddWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest4 && payout.getTestCase() == testCase);
        }
    }

}
