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

public class ResAndStatsTest5_14 extends ResAndStats implements ResAndStatsTestCase {

    public static final int testCase = 5, division = 14;
    private boolean isInitialize = true;
    private int[] oldHotNumberList = new int[5], oldHotCounterList = new int[5], actualHotNumberList = new int[5], actualHotCounterList = new int[5];
    private final int[] expectedHotCounterList = new int[5];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void checkStatistics() {
        oldHotNumberList = Arrays.copyOf(actualHotNumberList, actualHotNumberList.length);
        oldHotCounterList = Arrays.copyOf(actualHotCounterList, actualHotCounterList.length);
        actualHotNumberList = GetHandler.getIntArray(Statistics.Label.HotNumbers);
        actualHotCounterList = GetHandler.getIntArray(Statistics.Label.HotCounters);
        for (int i = 0; i < actualHotNumberList.length; i++) expectedHotCounterList[i] = getSize(Statistics.Method.getHotResults(actualHotNumberList[i]));
    }

    public void saveTestCase(String[] roundResult, List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        if (Helper.find(Integer.parseInt(roundResult[0]), oldHotNumberList) && !isInitialize) {
            String currentRoundResult = Helper.toString(roundResult);
            String oldResult = getResultFromArray(oldHotNumberList, oldHotCounterList);
            String expectedResult = getResultFromArray(actualHotNumberList, expectedHotCounterList);
            String actualResult = getResultFromArray(actualHotNumberList, actualHotCounterList);

            TextFileFeature.setTestResult("Result And Statistics", testCase, division, currentRoundResult,
                    expectedResult, actualResult, tableInfo, oldResult);
            resAndStatsTestCaseList.removeIf(resAndStats -> resAndStats instanceof ResAndStatsTest5_14 && resAndStats.getTestCase() == testCase
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

        int[][] actualResult = Arrays.copyOf(getArrayFromResult(result.getActualResult()), getArrayFromResult(result.getActualResult()).length);
        int[] actualNumberResultList = actualResult[0];
        int[] actualCounterResultList = actualResult[1];

        int[][] expectedResult = Arrays.copyOf(getArrayFromResult(result.getExpectedResult()), getArrayFromResult(result.getExpectedResult()).length);
        int[] expectedNumberResultList = expectedResult[0];
        int[] expectedCounterResultList = expectedResult[1];

        int numberResult = Integer.parseInt(result.getRoundResult().split(" ")[0]);
        int actualIndex = Helper.getIndex(numberResult, actualNumberResultList);
        int expectedIndex = Helper.getIndex(numberResult, expectedNumberResultList);

        CustomAssert.assertEquals(expectedCounterResultList[expectedIndex], actualCounterResultList[actualIndex], message, message);

        System.out.println();
    }

}