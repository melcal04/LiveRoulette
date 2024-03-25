package modules.Payout;

import globals.TestMethods;
import pages.DealerTable;
import utilities.features.ScreenshotFeature;
import utilities.features.TextFileFeature;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.interfaces.PayoutTestCase;
import utilities.objects.CustomAssert;
import utilities.objects.Helper;
import utilities.objects.Printer;
import utilities.objects.TestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Payout extends TestMethods {

    private static List<PayoutTestCase> payoutTestCaseList;
    private static List<PayoutTestCase> ignoredPayoutTestCase;

    protected static String tableInfo;
    protected static double totalWinBet, totalWinResult, totalBet, balanceBeforeBetting, balanceAfterBetting, balanceAfterDealing;
    protected static boolean isRedPlaced, isBlackPlaced, isEvenPlaced, isOddPlaced, isLowPlaced, isHighPlaced,
            is1stDozenPlaced, is2ndDozenPlaced, is3rdDozenPlaced, is1stColumnPlaced, is2ndColumnPlaced, is3rdColumnPlaced,
            isStraightUpPlaced, isSplitPlaced, isStreetPlaced, isCornerPlaced, isSixLinePlaced, isZeroSectionPlaced, isZeroCornerPlaced;

    public static void init(List<String> roundResults) {
        payoutTestCaseList = new ArrayList<>();
        for (String roundResult : roundResults) {
            switch (roundResult) {
                case "Red" -> payoutTestCaseList.add(new PayoutTest1());
                case "Black" -> payoutTestCaseList.add(new PayoutTest2());
                case "Even" -> payoutTestCaseList.add(new PayoutTest3());
                case "Odd" -> payoutTestCaseList.add(new PayoutTest4());
                case "Low" -> payoutTestCaseList.add(new PayoutTest5());
                case "High" -> payoutTestCaseList.add(new PayoutTest6());
                case "1st Dozen" -> payoutTestCaseList.add(new PayoutTest7());
                case "2nd Dozen" -> payoutTestCaseList.add(new PayoutTest8());
                case "3rd Dozen" -> payoutTestCaseList.add(new PayoutTest9());
                case "1st Column" -> payoutTestCaseList.add(new PayoutTest10());
                case "2nd Column" -> payoutTestCaseList.add(new PayoutTest11());
                case "3rd Column" -> payoutTestCaseList.add(new PayoutTest12());
                case "Straight Up" -> payoutTestCaseList.add(new PayoutTest13());
                case "Split" -> payoutTestCaseList.add(new PayoutTest14());
                case "Street" -> payoutTestCaseList.add(new PayoutTest15());
                case "Corner" -> payoutTestCaseList.add(new PayoutTest16());
                case "Six Line" -> payoutTestCaseList.add(new PayoutTest17());
                case "Zero Section" -> payoutTestCaseList.add(new PayoutTest18());
                case "Zero Corner" -> payoutTestCaseList.add(new PayoutTest19());
            }
        }
    }

    public static boolean isCompleted() {
        return payoutTestCaseList.isEmpty();
    }

    public static void setBeforeBetting() {
        if (payoutTestCaseList.isEmpty()) return;

        ignoredPayoutTestCase = new ArrayList<>();
        isRedPlaced = isBlackPlaced = isEvenPlaced = isOddPlaced = isLowPlaced = isHighPlaced = is1stDozenPlaced = is2ndDozenPlaced =
                is3rdDozenPlaced = is1stColumnPlaced = is2ndColumnPlaced = is3rdColumnPlaced = isStraightUpPlaced = isSplitPlaced =
                        isStreetPlaced = isCornerPlaced = isSixLinePlaced = isZeroSectionPlaced = isZeroCornerPlaced = false;
        balanceBeforeBetting = balanceAfterBetting = balanceAfterDealing = totalWinBet = totalWinResult = totalBet = 0.0;
        balanceBeforeBetting = GetHandler.getDouble(DealerTable.Label.Balance);
        System.out.println("    Balance Before Betting: " + balanceBeforeBetting);
    }

    public static void setBettingOption() {
        if (payoutTestCaseList.isEmpty()) return;

        processPayoutTestCases(PayoutTestCase::placeBettingOption);
        EventHandler.click(DealerTable.Button.Confirm, 1);
    }

    public static void setAfterBetting() {
        if (payoutTestCaseList.isEmpty()) return;

        processPayoutTestCases(PayoutTestCase::checkBettingChip);
        tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        totalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.Balance);
        System.out.println("    Balance After Betting: " + balanceAfterBetting);
    }

    public static void setAfterDealing(String[] roundResult) {
        if (payoutTestCaseList.isEmpty()) return;

        balanceAfterDealing = getUpdatedBalance();
        System.out.println("    Balance After Dealing: " + balanceAfterDealing);
        ScreenshotFeature.capture("balance", tableInfo + " " + Helper.toString(roundResult));
        processPayoutTestCases(payoutTestCase -> payoutTestCase.computeWinResult(roundResult));
        System.out.println("    Total Win Bet: " + totalWinBet);
        System.out.println("    Total Win Result: " + totalWinResult);
        processPayoutTestCases(payoutTestCase -> payoutTestCase.saveTestCase(roundResult, payoutTestCaseList));

        if (!payoutTestCaseList.isEmpty()) {
            System.out.println("    Payout Test Cases Left: " + Helper.toString(getTestCaseList(payoutTestCaseList)));
            if (!ignoredPayoutTestCase.isEmpty())
                System.out.println("    Ignored Result And Statistics Test Cases: " + Helper.toString(getTestCaseList(ignoredPayoutTestCase)));
        }
    }

    private static int[] getTestCaseList(List<PayoutTestCase> payoutTestCaseList) {
        Set<Integer> uniqueTestCases = payoutTestCaseList.stream().map(PayoutTestCase::getTestCase)
                .filter(testCase -> testCase != 0).collect(Collectors.toSet());
        return uniqueTestCases.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void processPayoutTestCases(Consumer<PayoutTestCase> action) {
        for (PayoutTestCase payoutTestCase : new ArrayList<>(payoutTestCaseList)) {
            try {
                if (!ignoredPayoutTestCase.contains(payoutTestCase)) action.accept(payoutTestCase);
            } catch (Exception e) {
                ignoredPayoutTestCase.add(payoutTestCase);
                Printer.printError("Test Case " + payoutTestCase.getTestCase() + ": " + e.getMessage());
            }
        }
    }

    protected static void addWin(String bettingOption, double chipValue, double payoutOdds) {
        System.out.println("    Bet in " + bettingOption + ": " + chipValue);
        totalWinBet += chipValue;
        totalWinResult += (chipValue * payoutOdds);
    }

    protected static String getExpectedResult() {
        double expectedTotalPayout = totalWinBet + totalWinResult;
        double expectedTotalWinLose = expectedTotalPayout - totalBet;
        double expectedTotalBalance = balanceAfterBetting + expectedTotalPayout;
        return "{" + "Expected Total Balance: " + expectedTotalBalance + "}{" +
                "Expected Total Payout: " + expectedTotalPayout + "}{" +
                "Expected Total Win/Lose: " + expectedTotalWinLose + "}";
    }

    protected static String getActualResult() {
        double actualTotalBalance = balanceAfterDealing;
        double actualTotalPayout = balanceAfterDealing - balanceAfterBetting;
        double actualTotalWinLose = actualTotalPayout - totalBet;
        return "{" + "Actual Total Balance: " + actualTotalBalance + "}{" +
                "Actual Total Payout: " + actualTotalPayout + "}{" +
                "Actual Total Win/Lose: " + actualTotalWinLose + "}";
    }

    protected static String getOtherInfo(double bet, double payoutOdds, double payout) {
        return  "{" + "Balance Before Betting: " + balanceBeforeBetting + "}{" +
                "Balance After Betting: " + balanceAfterBetting + "}{" +
                "Balance After Dealing: " + balanceAfterDealing + "}{" +
                "Payout Odds: " + payoutOdds + "}{" +
                "Bet: " + bet + "}{" +
                "Payout: " + payout + "}{" +
                "Total Bet: " + totalBet + "}";
    }

    public static void verify(int testCase) {
        TestResult result = TextFileFeature.getTestResult("Payout", testCase, 0);

        double[] expectedResult = getArrayFromExpectedResult(result.getExpectedResult());
        double[] actualResult = getArrayFromActualResult(result.getActualResult());
        double[] otherInfo = getArrayFromOtherInfo(result.getOtherInfo());

        double expectedTotalBalance = expectedResult[0];
        double expectedTotalPayout = expectedResult[1];
        double expectedTotalWinLose = expectedResult[2];
        double actualTotalBalance = actualResult[0];
        double actualTotalPayout = actualResult[1];
        double actualTotalWinLose = actualResult[2];
        double balanceBeforeBetting = otherInfo[0];
        double balanceAfterBetting = otherInfo[1];
        double balanceAfterDealing = otherInfo[2];
        double payoutOdds = otherInfo[3];
        double chipValue = otherInfo[4];
        double payout = otherInfo[5];
        double totalBet = otherInfo[6];

        System.out.println();
        System.out.println("Module: PAYOUT");
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Bet: " + chipValue);
        System.out.println("Payout Odds: " + payoutOdds);
        System.out.println("Payout: " + payout);
        System.out.println("Total Bet: " + totalBet);
        System.out.println("Balance Before Betting: " + balanceBeforeBetting);
        System.out.println("Balance After Betting: " + balanceAfterBetting);
        System.out.println("Balance After Dealing: " + balanceAfterDealing);
        System.out.println("Expected Total Balance: " + expectedTotalBalance);
        System.out.println("Expected Total PayoutCase: " + expectedTotalPayout);
        System.out.println("Expected Total Win/Lose: " + expectedTotalWinLose);

        String balanceMessage = "Actual Total Balance: " + actualTotalBalance;
        CustomAssert.assertEquals(expectedTotalBalance, actualTotalBalance, balanceMessage, balanceMessage);

        String payoutMessage = "Actual Total PayoutCase: " + actualTotalPayout;
        CustomAssert.assertEquals(expectedTotalPayout, actualTotalPayout, payoutMessage, payoutMessage);

        String winLoseMessage = "Actual Total Win/Lose: " + actualTotalWinLose;
        CustomAssert.assertEquals(expectedTotalWinLose, actualTotalWinLose, winLoseMessage, winLoseMessage);

        System.out.println();
    }

    @SuppressWarnings("all")
    private static double[] getArrayFromExpectedResult(String expectedResult) {
        double expectedTotalBalance = 0.0;
        double expectedTotalPayout = 0.0;
        double expectedTotalWinLose = 0.0;

        expectedResult = expectedResult.substring(1, expectedResult.length() - 1);
        String[] parts = expectedResult.split("\\}\\{");
        for (String part : parts) {
            String[] keyValue = part.split(": ");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                    case "Expected Total Balance" -> expectedTotalBalance = Double.parseDouble(value);
                    case "Expected Total Payout" -> expectedTotalPayout = Double.parseDouble(value);
                    case "Expected Total Win/Lose" -> expectedTotalWinLose = Double.parseDouble(value);
                }
            }
        }
        return new double[]{expectedTotalBalance, expectedTotalPayout, expectedTotalWinLose};
    }

    @SuppressWarnings("all")
    private static double[] getArrayFromActualResult(String actualResult) {
        double actualTotalBalance = 0.0;
        double actualTotalPayout = 0.0;
        double actualTotalWinLose = 0.0;

        actualResult = actualResult.substring(1, actualResult.length() - 1);
        String[] parts = actualResult.split("\\}\\{");

        for (String part : parts) {
            String[] keyValue = part.split(": ");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                    case "Actual Total Balance" -> actualTotalBalance = Double.parseDouble(value);
                    case "Actual Total Payout" -> actualTotalPayout = Double.parseDouble(value);
                    case "Actual Total Win/Lose" -> actualTotalWinLose = Double.parseDouble(value);
                }
            }
        }
        return new double[]{actualTotalBalance, actualTotalPayout, actualTotalWinLose};
    }

    @SuppressWarnings("all")
    private static double[] getArrayFromOtherInfo(String otherInfo) {
        double balanceBeforeBetting = 0.0;
        double balanceAfterBetting = 0.0;
        double balanceAfterDealing = 0.0;
        double payoutOdds = 0.0;
        double chipValue = 0.0;
        double payout = 0.0;
        double totalBet = 0.0;

        otherInfo = otherInfo.substring(1, otherInfo.length() - 1);
        String[] parts = otherInfo.split("\\}\\{");
        for (String part : parts) {
            String[] keyValue = part.split(": ");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                    case "Balance Before Betting" -> balanceBeforeBetting = Double.parseDouble(value);
                    case "Balance After Betting" -> balanceAfterBetting = Double.parseDouble(value);
                    case "Balance After Dealing" -> balanceAfterDealing = Double.parseDouble(value);
                    case "Payout Odds" -> payoutOdds = Double.parseDouble(value);
                    case "Bet" -> chipValue = Double.parseDouble(value);
                    case "Payout" -> payout = Double.parseDouble(value);
                    case "Total Bet" -> totalBet = Double.parseDouble(value);
                }
            }
        }
        return new double[]{balanceBeforeBetting, balanceAfterBetting, balanceAfterDealing, payoutOdds, chipValue, payout, totalBet};
    }

}
