package modules.ResultAndStatistics;

import globals.TestConditions;
import utilities.features.TextFileFeature;
import utilities.interfaces.ResAndStatsTestCase;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.TestResult;

import java.util.List;

public class ResAndStatsTest3 extends ResAndStats implements ResAndStatsTestCase {

    private static final int testCase = 3, division = 0;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void checkStatistics() {
        // Test case doesn't require statistics information.
    }

    public void saveTestCase(String[] roundResult, List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        if (!TestConditions.isBlackWin(roundResult)) {
            String[] currentNumberInResultPanel = getFirstNumberInResultPanel();
            String actualColorResult = currentNumberInResultPanel[0];
            String actualNumberResult = currentNumberInResultPanel[1];
            String currentRoundResult = Helper.toString(roundResult);
            String expectedResult = Helper.toString(roundResult);
            String actualResult = actualNumberResult + " " + actualColorResult;

            TextFileFeature.setTestResult("Result And Statistics", testCase, 0, currentRoundResult,
                    expectedResult, actualResult, tableInfo, null);
            resAndStatsTestCaseList.removeIf(resAndStats -> resAndStats instanceof ResAndStatsTest3 && resAndStats.getTestCase() == testCase
                    && resAndStats.getDivision() == division);
        }
    }

    public static void verify() {
        TestResult result = TextFileFeature.getTestResult("Result And Statistics", testCase, division);

        System.out.println();
        System.out.println("Module: RESULT AND STATISTICS");
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Expected Result: " + result.getExpectedResult());

        String message = "Actual Result: " + result.getActualResult();
        CustomAssert.assertEquals(result.getExpectedResult(), result.getActualResult(), message, message);

        System.out.println();
    }

}
