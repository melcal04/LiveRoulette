package modules.ResultAndStatistics;

import globals.TestMethods;
import globals.TestVariables;
import org.openqa.selenium.WebElement;
import pages.BettingPanel;
import pages.DealerTable;
import pages.Statistics;
import utilities.features.ScreenshotFeature;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.interfaces.ResAndStatsTestCase;
import utilities.objects.Helper;
import utilities.objects.Locator;
import utilities.objects.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ResAndStats extends TestMethods {

    private static List<ResAndStatsTestCase> resAndStatsTestCaseList;
    private static List<ResAndStatsTestCase> ignoredResAndStatsTestCase;
    protected static String tableInfo;
    protected static double totalResultHistory;

    public static void init(List<String> displays) {
        resAndStatsTestCaseList = new ArrayList<>();
        for (String display : displays) {
            switch (display) {
                case "Result Panel" -> resAndStatsTestCaseList.add(new ResAndStatsTest1());
                case "Red Result" -> resAndStatsTestCaseList.add(new ResAndStatsTest2());
                case "Black Result" -> resAndStatsTestCaseList.add(new ResAndStatsTest3());
                case "Zero Result" -> resAndStatsTestCaseList.add(new ResAndStatsTest4());
                case "Red Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_1());
                case "Zero Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_2());
                case "Black Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_3());
                case "Odd Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_4());
                case "Even Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_5());
                case "High Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_6());
                case "Low Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_7());
                case "1st Dozen Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_8());
                case "2nd Dozen Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_9());
                case "3rd Dozen Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_10());
                case "1st Column Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_11());
                case "2nd Column Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_12());
                case "3rd Column Percentage" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_13());
                case "Hot Numbers Win" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_14());
                case "Cold Numbers Lose" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_15());
                case "Cold Numbers Win" -> resAndStatsTestCaseList.add(new ResAndStatsTest5_16());
            }
        }
    }

    public static boolean isCompleted() {
        return resAndStatsTestCaseList.isEmpty();
    }

    public static void setBettingOption() {
        if (resAndStatsTestCaseList.isEmpty()) return;

        EventHandler.click(BettingPanel.Option.getSide(TestVariables.RED));
        EventHandler.click(DealerTable.Button.Confirm, 1);
    }

    public static void setAfterDealing(String[] roundResult) {
        if (resAndStatsTestCaseList.isEmpty()) return;

        ignoredResAndStatsTestCase = new ArrayList<>();
        tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        EventHandler.click(DealerTable.Button.Statistics);
        totalResultHistory = getSize(Statistics.Container.AllResults);
        processResAndStatsCases(ResAndStatsTestCase::checkStatistics);
        ScreenshotFeature.capture("statistics", tableInfo + " " + (roundResult == null ? "" : Helper.toString(roundResult)));
        EventHandler.click(Statistics.Button.CloseStatistics);
        processResAndStatsCases(resAndStatsTestCase -> resAndStatsTestCase.saveTestCase(roundResult, resAndStatsTestCaseList));

        if (!resAndStatsTestCaseList.isEmpty()) {
            System.out.println("    Result And Statistics Test Cases Left: " + Helper.toString(getTestCaseList(resAndStatsTestCaseList)));
            System.out.println("    Result And Statistics Divisions Left: " + Helper.toString(getDivisionList(resAndStatsTestCaseList)));
            if (!ignoredResAndStatsTestCase.isEmpty()) {
                System.out.println("    Ignored Result And Statistics Test Cases: " + Helper.toString(getTestCaseList(ignoredResAndStatsTestCase)));
                System.out.println("    Ignored Result And Statistics Divisions: " + Helper.toString(getDivisionList(ignoredResAndStatsTestCase)));
            }
        }
    }

    public static int[] getTestCaseList(List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        Set<Integer> uniqueTestCases = resAndStatsTestCaseList.stream().map(ResAndStatsTestCase::getTestCase)
                .filter(testCase -> testCase != 0).collect(Collectors.toSet());
        return uniqueTestCases.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getDivisionList(List<ResAndStatsTestCase> resAndStatsTestCaseList) {
        Set<Integer> uniqueDivisions = resAndStatsTestCaseList.stream().map(ResAndStatsTestCase::getDivision)
                .filter(division -> division != 0).collect(Collectors.toSet());
        return uniqueDivisions.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void processResAndStatsCases(Consumer<ResAndStatsTestCase> action) {
        for (ResAndStatsTestCase resAndStatsTestCase : new ArrayList<>(resAndStatsTestCaseList)) {
            try {
                if (!ignoredResAndStatsTestCase.contains(resAndStatsTestCase)) action.accept(resAndStatsTestCase);
            } catch (Exception e) {
                ignoredResAndStatsTestCase.add(resAndStatsTestCase);
                Printer.printError("Test Case " + (resAndStatsTestCase.getDivision() == 0 ? "" : resAndStatsTestCase.getDivision() + " Of ") +
                        resAndStatsTestCase.getTestCase() + ": " + e.getMessage());
            }
        }
    }

    protected static int getSize(Locator locator) {
        if (!ConditionHandler.isPresent(locator, 1)) return 0;
        List<WebElement> elements = GetHandler.getElements(locator);
        return elements.size();
    }

    protected String[] getFirstNumberInResultPanel() {
        return GetHandler.getAttribute(DealerTable.Label.FirstNumberInResultPanel, "class")
                .replace("number_","").toUpperCase().split(" ");
    }

    protected double getPercentage(Locator locator) {
        double percentage;
        do percentage = GetHandler.getDouble(locator);
        while (percentage == 0.0);
        return percentage;
    }

    protected static String getResultFromArray(int[] numberList, int[] counterList) {
        int capacity = (numberList.length + counterList.length) * 10;
        StringBuilder result = new StringBuilder(capacity);
        for (byte i = 0; i < numberList.length; i++) result.append('{').append(numberList[i]).append('-').append(counterList[i]).append('}');
        return result.toString();
    }

    @SuppressWarnings("all")
    protected static int[][] getArrayFromResult(String result) {
        result = result.substring(1, result.length() - 1);
        String[] parts = result.split("\\}\\{");
        List<Integer> numberList = new ArrayList<>();
        List<Integer> counterList = new ArrayList<>();
        for (String part : parts) {
            String[] tokens = part.split("-");
            if (tokens.length == 2) {
                numberList.add(Integer.parseInt(tokens[0]));
                counterList.add(Integer.parseInt(tokens[1]));
            }
        }
        int[] numbers = numberList.stream().mapToInt(Integer::intValue).toArray();
        int[] counters = counterList.stream().mapToInt(Integer::intValue).toArray();
        return new int[][] { numbers, counters };
    }

}
