package modules.ResultAndStatistics;

import globals.TestConditions;
import pages.Statistics;
import utilities.features.TextFileFeature;
import utilities.interfaces.ResAndStatsTestCase;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.TestResult;

import java.util.List;

public class ResAndStatsTest5_5 extends ResAndStats implements ResAndStatsTestCase {

    public static final int testCase = 5, division = 5;
    private double oldEvenPercentage = 0.0, actualEvenPercentage = 0.0, expectedEvenPercentage = 0.0;
    private static int size;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void checkStatistics() {
        size = getSize(Statistics.Container.EvenResults);
        expectedEvenPercentage = Math.round(((float) size / totalResultHistory) * 100.0 * 100.0) / 100.0;
        oldEvenPercentage = actualEvenPercentage;
        actualEvenPercentage = getPercentage(Statistics.Label.EvenPercentage);
    }

    public void saveTestCase(String[] roundResult, List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        if (TestConditions.isEvenWin(roundResult)) {
            String currentRoundResult = Helper.toString(roundResult);
            String tableInformation = tableInfo + " " + totalResultHistory + " " + size;
            String oldResult = Double.toString(oldEvenPercentage);
            String expectedResult = Double.toString(expectedEvenPercentage);
            String actualResult = Double.toString(actualEvenPercentage);

            TextFileFeature.setTestResult("Result And Statistics", testCase, division, currentRoundResult,
                    expectedResult, actualResult, tableInformation, oldResult);
            resAndStatsTestCaseList.removeIf(resAndStats -> resAndStats instanceof ResAndStatsTest5_5 && resAndStats.getTestCase() == testCase
                    && resAndStats.getDivision() == division);
        }
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
        double expectedPercentage = Double.parseDouble(result.getExpectedResult());
        double actualPercentage = Double.parseDouble(result.getActualResult());
        CustomAssert.assertEquals(expectedPercentage, actualPercentage, message, message);

        System.out.println();
    }

}
