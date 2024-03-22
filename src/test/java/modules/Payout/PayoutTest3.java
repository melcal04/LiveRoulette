package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.List;

public class PayoutTest3 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 3, payoutOdds = 1;
    private final String bettingOption = TestVariables.EVEN;

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isEvenPlaced) return;
        else isEvenPlaced = true;
        EventHandler.click(BettingPanel.Option.getSide(bettingOption));
    }

    public void checkBettingChip() {
        if (isEvenPlaced) bet = getChipValue(BettingPanel.Chip.getSide(bettingOption));
    }

    public void computeWinResult(String[] roundResult) {
        if (isEvenPlaced && TestConditions.isEvenWin(roundResult)) {
            payout = bet + (bet * payoutOdds);
            addWin("Even", bet, payoutOdds);
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isEvenPlaced && TestConditions.isEvenWin(roundResult)) {
            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest3 && payout.getTestCase() == testCase);
        }
    }

}
