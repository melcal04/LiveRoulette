package utilities.handlers;

import java.util.*;

public class DataTypeHandler {

    /***************************************************************************************************************
     * These methods handle the conversion of a string array to a string, separated by a space.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String toString(String[] array) {
        try {
            return String.join(" ", array);
        } catch (Exception e) {
            PrintHandler.printError("Failed to convert a string array to a string");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the conversion of an int array to a string, separated by a space.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String toString(int[] array) {
        try {
            StringBuilder result = new StringBuilder();
            for (int value : array) result.append(value).append(" ");
            return result.toString().trim();
        } catch (Exception e) {
            PrintHandler.printError("Failed to convert an integer array to a string");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the conversion of a list of integers to a string, separated by a space.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String toString(List<Integer> list) {
        try {
            StringBuilder result = new StringBuilder();
            for (int value : list) result.append(value).append(" ");
            return result.toString().trim();
        } catch (Exception e) {
            PrintHandler.printError("Failed to convert a list of integers to a string");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the process of checking if there is an equal number for each number in the array.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean findInArray(int num, int[] array) {
        try {
            for (int i : array) if (i == num) return true;
            return false;
        } catch (Exception e) {
            PrintHandler.printError("Failed to find a number from an integer array");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the process of checking if there is an equal string for each string in the array.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean findInArray(String text, String[] array) {
        try {
            for (String str : array) if (Objects.equals(text, str)) return true;
            return false;
        } catch (Exception e) {
            PrintHandler.printError("Failed to find a string from a string array");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the process of checking if each string in the array contains a specified string.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean containInArray(String text, String[] array) {
        try {
            for (String str : array) if (str.contains(text)) return true;
            return false;
        } catch (Exception e) {
            PrintHandler.printError("Failed to check if one of the string array contains a specific text");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the process of checking if two arrays have similar string collections.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isEqual(String[] array1, String[] array2) {
        try {
            if (array1 == null && array2 == null) return true;
            if (array1 == null || array2 == null) return false;
            if (array1.length != array2.length) return false;
            Arrays.sort(array1);
            Arrays.sort(array2);
            for (int i = 0; i < array1.length; i++) if (!array1[i].equals(array2[i])) return false;
            return true;
        } catch (Exception e) {
            PrintHandler.printError("Failed to check if two string arrays are equal");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the removal of a specified integer from the integer array.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int[] removeFromArray(int num, int[] array) {
        try {
            return Arrays.stream(array)
                    .filter(value -> value != num)
                    .toArray();
        } catch (Exception e) {
            PrintHandler.printError("Failed to remove a number from an integer array");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the retrieval of the index of a specified integer from the integer array.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int getIndex(int num, int[] array) {
        try {
            for (int i = 0; i < array.length; i++) if (num == array[i]) return i;
            return -1;
        } catch (Exception e) {
            PrintHandler.printError("Failed to get an index from an integer array");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the retrieval of the first character from the string.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getFirstChar(String text) {
        try {
            return String.valueOf(text.charAt(0));
        } catch (Exception e) {
            PrintHandler.printError("Failed to get a first character from an string");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the retrieval of the last character from the string.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getLastChar(String text) {
        try {
            return String.valueOf(text.charAt(text.length() - 1));
        } catch (Exception e) {
            PrintHandler.printError("Failed to get a last character from an string");
            throw e;
        }
    }

    /***************************************************************************************************************
     * These methods handle the reversal of an int array.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int[] reverseArray(int[] array) {
        List<Integer> numbersList = new ArrayList<>();
        for (int num : array) numbersList.add(num);
        Collections.reverse(numbersList);
        return numbersList.stream().mapToInt(Integer::intValue).toArray();
    }

    /***************************************************************************************************************
     * These methods handle the summation of an integer array.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int sum(int[] array) {
        int total = 0;
        for (int num : array) total += num;
        return total;
    }

}
