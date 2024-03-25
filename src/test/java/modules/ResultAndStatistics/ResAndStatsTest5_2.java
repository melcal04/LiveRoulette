package modules.ResultAndStatistics;

import globals.TestConditions;
import pages.Statistics;
import utilities.features.TextFileFeature;
import utilities.interfaces.ResAndStatsTestCase;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.TestResult;

import java.util.List;

public class ResAndStatsTest5_2 extends ResAndStats implements ResAndStatsTestCase {

    public static final int testCase = 5, division = 2;
    private double oldZeroPercentage = 0.0, actualZeroPercentage = 0.0, expectedZeroPercentage = 0.0;
    private static int size;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void checkStatistics() {
        size = getSize(Statistics.Container.ZeroResults);
        double redPercentage = Math.round(((float) getSize(Statistics.Container.RedResults) / totalResultHistory)
                * 100.0 * 100.0) / 100.0;
        double blackPercentage = Math.round(((float) getSize(Statistics.Container.BlackResults) / totalResultHistory)
                * 100.0 * 100.0) / 100.0;
        expectedZeroPercentage = Math.round((100.0 - (redPercentage + blackPercentage)) * 100.0) / 100.0;
        oldZeroPercentage = actualZeroPercentage;
        actualZeroPercentage = getPercentage(Statistics.Label.ZeroPercentage);
    }

    public void saveTestCase(String[] roundResult, List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        if (TestConditions.isZeroWin(roundResult)) {
            String currentRoundResult = Helper.toString(roundResult);
            String tableInformation = tableInfo + " " + totalResultHistory + " " + size;
            String oldResult = Double.toString(oldZeroPercentage);
            String expectedResult = Double.toString(expectedZeroPercentage);
            String actualResult = Double.toString(actualZeroPercentage);

            TextFileFeature.setTestResult("Result And Statistics", testCase, division, currentRoundResult,
                    expectedResult, actualResult, tableInformation, oldResult);
            resAndStatsTestCaseList.removeIf(resAndStats -> resAndStats instanceof ResAndStatsTest5_2 && resAndStats.getTestCase() == testCase
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
