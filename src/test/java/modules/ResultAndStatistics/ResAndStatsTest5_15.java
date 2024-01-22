package modules.ResultAndStatistics;

import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

import java.util.Arrays;

public class ResAndStatsTest5_15 extends ResAndStats implements ResAndStatsCase {

    public static final int testCase = 5, division = 15;
    private int[] oldColdNumberList, oldColdCounterList, coldNumberList = new int[5], coldCounterList = new int[5];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setResult() {
        // Test case doesn't require result information.
    }

    public void setStatistics() {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;

        oldColdNumberList = Arrays.copyOf(coldNumberList, coldNumberList.length);
        oldColdCounterList = Arrays.copyOf(coldCounterList, coldCounterList.length);
        coldNumberList = GetHandler.getIntArray(Statistics.Label.ColdNumbers);
        coldCounterList = GetHandler.getIntArray(Statistics.Label.ColdCounters);
    }

    public void saveTestCase(String[] roundResult) {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;
        if (DataTypeHandler.findInArray(Integer.parseInt(roundResult[0]), oldColdNumberList)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = getResultFromArray(oldColdNumberList, oldColdCounterList);
        String expectedResult = "All Counters in Cold Numbers Must Increase";
        String actualResult = getResultFromArray(coldNumberList, coldCounterList);

        System.out.println("    - " + expectedResult + ": " + oldResult + " --> " + actualResult);
        ResultHandler.setTestResult(testCase, division, currentRoundResult, expectedResult, actualResult, tableInfo, oldResult);
        divisionList = DataTypeHandler.removeFromArray(division, divisionList);

        if (divisionList.length != 0) return;
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

    public static void verify() {
        TestResult result = ResultHandler.getTestResult(testCase, division, Constants.Directory.RESULT_AND_STATS_PATH);

        System.out.println();
        System.out.println("Module: RESULT AND STATISTICS");
        System.out.println("Division: " + result.getDivision());
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Expected Result: " + result.getExpectedResult());

        String message = "Actual Result: " + result.getOtherInfo() + " --> " + result.getActualResult();
        int[][] actualResult = Arrays.copyOf(getArrayFromResult(result.getActualResult()), getArrayFromResult(result.getActualResult()).length);
        int[] actualNumberResultList = actualResult[0];
        int[] actualCounterResultList = actualResult[1];
        int[][] oldResult = Arrays.copyOf(getArrayFromResult(result.getOtherInfo()), getArrayFromResult(result.getOtherInfo()).length);
        int[] oldNumberResultList = oldResult[0];
        int[] oldCounterResultList = oldResult[1];

        boolean isPassed = true;
        for (byte i = 0; i < actualNumberResultList.length; i++) {
            int actualIndex = DataTypeHandler.getIndex(actualNumberResultList[i], actualNumberResultList);
            int oldIndex = DataTypeHandler.getIndex(oldNumberResultList[i], oldNumberResultList);
            if (oldCounterResultList[oldIndex] == 999) {
                if (actualCounterResultList[actualIndex] != 999) {
                    isPassed = false;
                    break;
                }
            } else {
                if (actualCounterResultList[actualIndex] <= oldCounterResultList[oldIndex]) {
                    isPassed = false;
                    break;
                }
            }
        }
        AssertHandler.assertTrue(isPassed, message, message);

        System.out.println();
    }

}