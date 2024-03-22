package modules.Payout;

import globals.TestConditions;
import globals.TestVariables;
import pages.BettingPanel;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.Helper;

import java.util.Arrays;
import java.util.List;

public class PayoutTest17 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 17, payoutOdds = 5;
    private final int[][][] betOptionList = Arrays.copyOf(TestVariables.SIX_LINE_LIST, TestVariables.SIX_LINE_LIST.length);
    private final double[] chipValueList = new double[betOptionList.length];

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isSixLinePlaced) return;
        else isSixLinePlaced = true;
        for (int[][] betOption : betOptionList)
            EventHandler.click(BettingPanel.Option.getSixLine(betOption));
    }

    public void checkBettingChip() {
        if (isSixLinePlaced) {
            int i = 0;
            for (int[][] betOption : betOptionList)
                chipValueList[i++] = getChipValue(BettingPanel.Chip.getSixLine(betOption));
        }
    }

    public void computeWinResult(String[] roundResult) {
        if (isSixLinePlaced) {
            if (TestConditions.isPosBetLose(roundResult, betOptionList)) return;

            byte i = 0;
            for (int[][] betOption : betOptionList) {
                if (TestConditions.isPosBetWin(roundResult, betOption)) {
                    bet = chipValueList[i++];
                    payout += bet + (bet * payoutOdds);
                    addWin("Six Line #" + betOption[1][0] + ", #" + betOption[1][1]  +
                            ", #" + betOption[1][2] + ", #" + betOption[1][3]  + ", #" + betOption[1][4] +
                            ", & #" + betOption[1][5], bet, payoutOdds);
                }
            }
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isSixLinePlaced) {
            if (TestConditions.isPosBetLose(roundResult, betOptionList)) return;

            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest17 && payout.getTestCase() == testCase);
        }
    }

}
