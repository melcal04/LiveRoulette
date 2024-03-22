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

public class PayoutTest14 extends Payout implements PayoutTestCase {

    private double bet, payout;
    private final int testCase = 14, payoutOdds = 17;
    private final int[][][] betOptionList = Arrays.copyOf(TestVariables.SPLIT_LIST, TestVariables.SPLIT_LIST.length);
    private final double[] chipValueList = new double[betOptionList.length];

    public int getTestCase() { return testCase; }

    public void placeBettingOption() {
        if (isSplitPlaced) return;
        else isSplitPlaced = true;
        for (int[][] betOption : betOptionList)
            EventHandler.click(BettingPanel.Option.getSplit(betOption));
    }

    public void checkBettingChip() {
        if (isSplitPlaced) {
            int i = 0;
            for (int[][] betOption : betOptionList)
                chipValueList[i++] = getChipValue(BettingPanel.Chip.getSplit(betOption));
        }
    }

    public void computeWinResult(String[] roundResult) {
        if (isSplitPlaced) {
            if (TestConditions.isPosBetLose(roundResult, betOptionList)) return;

            byte i = 0;
            for (int[][] betOption : betOptionList) {
                if (TestConditions.isPosBetWin(roundResult, betOption)) {
                    bet = chipValueList[i++];
                    payout += bet + (bet * payoutOdds);
                    addWin("Split #" + betOption[1][0] + " & #" + betOption[1][1], bet, payoutOdds);
                }
            }
        }
    }

    public void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList) {
        if (isSplitPlaced) {
            if (TestConditions.isPosBetLose(roundResult, betOptionList)) return;

            String expectedResult = getExpectedResult();
            String actualResult = getActualResult();
            String otherInfo = getOtherInfo(bet, payoutOdds, payout);
            TextFileFeature.setTestResult("Payout", testCase, 0, Helper.toString(roundResult),
                    expectedResult, actualResult, tableInfo, otherInfo);
            payoutTestCaseList.removeIf(payout -> payout instanceof PayoutTest14 && payout.getTestCase() == testCase);
        }
    }

}
