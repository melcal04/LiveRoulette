package modules.ResultAndStatistics;

import pages.DealerTable;
import utilities.features.TextFileFeature;
import utilities.handlers.GetHandler;
import utilities.interfaces.ResAndStatsTestCase;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.TestResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResAndStatsTest1 extends ResAndStats implements ResAndStatsTestCase {

    private static final int testCase = 1, division = 0;
    private static int counter = 0;
    private boolean isInitialize = true;
    private final String[] roundResultList = new String[2];
    private String[] oldResultList = new String[12], expectedResultList = new String[12];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void checkStatistics() { /* Test case doesn't require statistics information. */ }

    public void saveTestCase(String[] roundResult, List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        if (isInitialize) {
            oldResultList = GetHandler.getTextArray(DealerTable.Label.NumbersInResultPanel);
            expectedResultList = GetHandler.getTextArray(DealerTable.Label.NumbersInResultPanel);
            isInitialize = false;
        } else {
            expectedResultList = getNewResultList(Integer.parseInt(roundResult[0]), expectedResultList);
            roundResultList[counter] = Helper.toString(roundResult);
            if ((counter++) > 0) {
                String currentRoundResult = Helper.toString(roundResultList);
                String oldResult = Helper.toString(oldResultList);
                String expectedResult = Helper.toString(expectedResultList);
                String actualResult = Helper.toString(GetHandler.getTextArray(DealerTable.Label.NumbersInResultPanel));

                TextFileFeature.setTestResult("Result And Statistics", testCase, 0, currentRoundResult,
                        expectedResult, actualResult, tableInfo, oldResult);
                resAndStatsTestCaseList.removeIf(resAndStats -> resAndStats instanceof ResAndStatsTest1 && resAndStats.getTestCase() == testCase
                        && resAndStats.getDivision() == division);
            }
        }
    }

    private String[] getNewResultList(int numberResult, String[] list) {
        List<String> resultList = new ArrayList<>(Arrays.asList(list));
        resultList.add(0, String.valueOf(numberResult));
        if (resultList.size() > 12) resultList.remove(resultList.size() - 1);
        return resultList.toArray(new String[0]);
    }

    public static void verify() {
        TestResult result = TextFileFeature.getTestResult("Result And Statistics", testCase, division);

        System.out.println();
        System.out.println("Module: RESULT AND STATISTICS");
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Expected Result: " + result.getExpectedResult());

        String message = "Actual Result: " + result.getOtherInfo() + " --> " + result.getActualResult();
        CustomAssert.assertEquals(result.getExpectedResult(), result.getActualResult(), message, message);

        System.out.println();
    }

}
