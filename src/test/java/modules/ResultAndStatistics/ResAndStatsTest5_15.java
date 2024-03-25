package modules.ResultAndStatistics;

import pages.Statistics;
import utilities.features.TextFileFeature;
import utilities.handlers.GetHandler;
import utilities.interfaces.ResAndStatsTestCase;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.TestResult;

import java.util.Arrays;
import java.util.List;

public class ResAndStatsTest5_15 extends ResAndStats implements ResAndStatsTestCase {

    public static final int testCase = 5, division = 15;
    private boolean isInitialize = true;
    private int[] oldColdNumberList = new int[5], oldColdCounterList = new int[5], actualColdNumberList = new int[5], actualColdCounterList = new int[5];
    private final int[] expectedColdCounterList = new int[5];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void checkStatistics() {
        oldColdNumberList = Arrays.copyOf(actualColdNumberList, actualColdNumberList.length);
        oldColdCounterList = Arrays.copyOf(actualColdCounterList, actualColdCounterList.length);
        actualColdNumberList = GetHandler.getIntArray(Statistics.Label.ColdNumbers);
        actualColdCounterList = GetHandler.getIntArray(Statistics.Label.ColdCounters);
        for (int i = 0; i < actualColdNumberList.length; i++)
            expectedColdCounterList[i] = getSize(Statistics.Method.getColdResults(actualColdNumberList[i]));
    }

    public void saveTestCase(String[] roundResult, List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        if (!Helper.find(Integer.parseInt(roundResult[0]), oldColdNumberList) && !isInitialize) {
            String currentRoundResult = Helper.toString(roundResult);
            String oldResult = getResultFromArray(oldColdNumberList, oldColdCounterList);
            String expectedResult = getResultFromArray(actualColdNumberList, expectedColdCounterList);
            String actualResult = getResultFromArray(actualColdNumberList, actualColdCounterList);

            TextFileFeature.setTestResult("Result And Statistics", testCase, division, currentRoundResult,
                    expectedResult, actualResult, tableInfo, oldResult);
            resAndStatsTestCaseList.removeIf(resAndStats -> resAndStats instanceof ResAndStatsTest5_15 && resAndStats.getTestCase() == testCase
                    && resAndStats.getDivision() == division);
        }
        isInitialize = false;
    }

    public static void verify() {
        TestResult result = TextFileFeature.getTestResult("Result And Statistics", testCase, division);

        System.out.println();
        System.out.println("Module: RESULT AND STATISTICS");
        System.out.println("Division: " + result.getDivision());
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Expected Result: " + result.getExpectedResult());

        String message = "Actual Result: " + result.getOtherInfo() + " --> " + result.getActualResult();
        CustomAssert.assertTrue(isPassed(result), message, message);

        System.out.println();
    }

    private static boolean isPassed(TestResult result) {
        int[][] actualResult = Arrays.copyOf(getArrayFromResult(result.getActualResult()), getArrayFromResult(result.getActualResult()).length);
        int[] actualNumberResultList = actualResult[0];
        int[] actualCounterResultList = actualResult[1];

        int[][] expectedResult = Arrays.copyOf(getArrayFromResult(result.getExpectedResult()), getArrayFromResult(result.getExpectedResult()).length);
        int[] expectedNumberResultList = expectedResult[0];
        int[] expectedCounterResultList = expectedResult[1];

        int[][] oldResult = Arrays.copyOf(getArrayFromResult(result.getOtherInfo()), getArrayFromResult(result.getOtherInfo()).length);
        int[] oldNumberResultList = oldResult[0];
        int[] oldCounterResultList = oldResult[1];

        for (byte i = 0; i < actualNumberResultList.length; i++) {
            int actualIndex = Helper.getIndex(actualNumberResultList[i], actualNumberResultList);
            int oldIndex = Helper.getIndex(oldNumberResultList[i], oldNumberResultList);
            int expectedIndex = Helper.getIndex(expectedNumberResultList[i], expectedNumberResultList);
            if (oldCounterResultList[oldIndex] == 999 && actualCounterResultList[actualIndex] != 999) return false;
            if (actualCounterResultList[actualIndex] <= oldCounterResultList[oldIndex]) return false;
            if (expectedCounterResultList[expectedIndex] != actualCounterResultList[actualIndex]) return false;
        }

        return true;
    }

}