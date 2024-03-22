package globals;

import utilities.objects.Helper;

import java.util.Objects;

public class TestConditions {

    /*********************************************************************************************************************
     ** These methods checks the results of each round in the Live Roulette Mobile Revamp.
     *********************************************************************************************************************/

    public static boolean isStraightUpWin(String[] result, int number) {
        int numberResult = Integer.parseInt(result[0]);
        return number == numberResult;
    }

    public static boolean isPosBetWin(String[] result, int[][] bettingOption) {
        int[] bettingOptions = bettingOption[1];
        int numberResult = Integer.parseInt(result[0]);
        return Helper.find(numberResult, bettingOptions);
    }

    public static boolean isPosBetLose(String[] result, int[][][] bettingOptionList) {
        int numberResult = Integer.parseInt(result[0]);
        for (int[][] bettingOption : bettingOptionList) {
            int[] bettingResult = bettingOption[1];
            if (Helper.find(numberResult, bettingResult)) return false;
        }
        return true;
    }

    public static boolean isRedWin(String[] result) {
        String colorResult = result[1];
        return Objects.equals(colorResult, "RED");
    }

    public static boolean isBlackWin(String[] result) {
        String colorResult = result[1];
        return Objects.equals(colorResult, "BLACK");
    }

    public static boolean isZeroLose(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult != 0;
    }

    public static boolean isEvenWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult % 2 == 0 && numberResult != 0;
    }

    public static boolean isOddWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult % 2 != 0;
    }

    public static boolean isLowWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult <= 18 && numberResult != 0;
    }

    public static boolean isHighWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult >= 19;
    }

    public static boolean is1stDozenWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult <= 12 & numberResult != 0;
    }

    public static boolean is2ndDozenWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult >= 13 & numberResult <= 24;
    }

    public static boolean is3rdDozenWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return numberResult >= 25;
    }

    public static boolean is1stColumnWin(String[] result) {
        int numberResult = Integer.parseInt(result[0]);
        return Helper.find(numberResult, TestVariables.FIRST_COLUMN_NUMBERS);
    }

    public static boolean is2ndColumnWin(String[] result) {
        int number = Integer.parseInt(result[0]);
        return Helper.find(number, TestVariables.SECOND_COLUMN_NUMBERS);
    }

    public static boolean is3rdColumnWin(String[] result) {
        int number = Integer.parseInt(result[0]);
        return Helper.find(number, TestVariables.THIRD_COLUMN_NUMBERS);
    }

}
