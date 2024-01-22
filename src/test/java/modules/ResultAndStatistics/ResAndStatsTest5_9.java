package modules.ResultAndStatistics;

import globals.RoundCondition;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

public class ResAndStatsTest5_9 extends ResAndStats implements ResAndStatsCase {

    public static final int testCase = 5, division = 9;
    private double oldSecondDozenPercentage = 0.0, secondDozenPercentage = 0.0;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setResult() {
        // Test case doesn't require result information.
    }

    public void setStatistics() {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;

        oldSecondDozenPercentage = secondDozenPercentage;
        secondDozenPercentage = getPercentage(Statistics.Label.SecondDozenPercentage);
    }

    public void saveTestCase(String[] roundResult) {
        if (!DataTypeHandler.findInArray(testCase, testCaseList)) return;
        if (!DataTypeHandler.findInArray(division, divisionList)) return;
        if (!RoundCondition.isSecondDozenWin(roundResult)) return;
        if (oldSecondDozenPercentage == secondDozenPercentage) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = Double.toString(oldSecondDozenPercentage);
        String expectedResult = "2nd Dozen Percentage Must Increase";
        String actualResult = Double.toString(secondDozenPercentage);

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
        double actualPercentage = Double.parseDouble(result.getActualResult());
        double oldPercentage = Double.parseDouble(result.getOtherInfo());
        AssertHandler.assertTrue(actualPercentage > oldPercentage, message, message);

        System.out.println();
    }

}