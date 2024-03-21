package utilities.objects;

import java.util.*;
import java.util.stream.Collectors;

/*********************************************************************************************************************
 ** This object class is utilized to contain simple methods that process data, such as arrays, strings, lists, etc.
 *********************************************************************************************************************/

@SuppressWarnings("unused")
public class Helper {

    /* ? *******************************************************************************************************************
    ? THESE ARE THE LIST OF HELPER METHODS FOR STRING, ARRAY, AND LIST
    ? - public static boolean find(String text, String[] array)
    ? - public static boolean find(int number, int[] array)
    ? - public static boolean find(String text, List<String> array)
    ? - public static boolean contains(String text, String[] array)
    ? - public static boolean contains(String text, List<String> array)
    ? - public static boolean isEqual(String[] array1, String[] array2)
    ? - public static boolean isEqual(int[] array1, int[] array2)
    ? - public static String getFirstChar(String text)
    ? - public static String getLastChar(String text)
    ? - public static String toString(String[] array)
    ? - public static String toString(int[] array)
    ? - public static String toString(List<?> inputList)
    ? - public static int sum(int[] array)
    ? - public static int getIndex(int number, int[] array)
    ? - public static String[] reverse(String[] array)
    ? - public static String[] remove(String text, String[] array)
    ? - public static String[] add(String text, String[] array)
    ? - public static String[] toArray(List<?> list)
    ? - public static int[] reverse(int[] array)
    ? - public static int[] remove(int number, int[] array)
    ? - public static int[] add(int number, int[] array)
    ? - public static int[] toArray(String input, String delimiter)
    ? - public static List<Integer> toList(String input, String delimiter)
    ? **********************************************************************************************************************/

    /*********************************************************************************************************************
     ** The 'find' method handles the process of checking if there is an equal string for each string in the array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean find(String text, String[] array) {
        for (String str : array) if (Objects.equals(text, str)) return true;
        return false;
    }

    /*********************************************************************************************************************
     ** The 'find' method handles the process of checking if there is an equal number for each integer in the array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean find(int number, int[] array) {
        for (int i : array) if (i == number) return true;
        return false;
    }

    /*********************************************************************************************************************
     ** The 'find' method handles the process of checking if there is an equal string for each string in the list.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean find(String text, List<String> array) {
        for (String str : array) if (Objects.equals(text, str)) return true;
        return false;
    }

    /*********************************************************************************************************************
     ** The 'contains' method handles the process of checking if each string in the array contains a specified string.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean contains(String text, String[] array) {
        for (String str : array) if (str.contains(text)) return true;
        return false;
    }

    /*********************************************************************************************************************
     ** The 'contains' method handles the process of checking if each string in the list contains a specified string.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean contains(String text, List<String> array) {
        for (String str : array) if (str.contains(text)) return true;
        return false;
    }

    /*********************************************************************************************************************
     ** The 'isEqual' method handles the process of checking if two arrays have similar string collections.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isEqual(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) return true;
        if (array1 == null || array2 == null) return false;
        if (array1.length != array2.length) return false;
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) if (!array1[i].equals(array2[i])) return false;
        return true;
    }

    /*********************************************************************************************************************
     ** The 'isEqual' method handles the process of checking if two arrays have similar integer collections.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isEqual(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) return true;
        if (array1 == null || array2 == null) return false;
        if (array1.length != array2.length) return false;
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) if (array1[i] == array2[i]) return false;
        return true;
    }

    /*********************************************************************************************************************
     ** The 'getFirstChar' method handles the retrieval of the first character from the string.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getFirstChar(String text) {
        return String.valueOf(text.charAt(0));
    }

    /*********************************************************************************************************************
     ** The 'getLastChar' method handles the retrieval of the last character from the string.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getLastChar(String text) {
        return String.valueOf(text.charAt(text.length() - 1));
    }

    /*********************************************************************************************************************
     ** The 'toString' method handles the conversion of a string array into a string, separated by a space.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String toString(String[] array) {
        return String.join(" ", array);
    }

    /*********************************************************************************************************************
     ** The 'toString' method handles the conversion of an integer array into a string, separated by a space.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String toString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) result.append(value).append(" ");
        return result.toString().trim();
    }

    /*********************************************************************************************************************
     ** // The 'toString' method handles the conversion of a list of objects into a string, separated by a space.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String toString(List<?> inputList) {
        return inputList.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    /*********************************************************************************************************************
     ** The 'sum' method handles the summation of an integer array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int sum(int[] array) {
        int total = 0;
        for (int num : array) total += num;
        return total;
    }

    /*********************************************************************************************************************
     ** The 'getIndex' method handles the retrieval of the index of a specified integer from the integer array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int getIndex(int number, int[] array) {
        for (int i = 0; i < array.length; i++) if (number == array[i]) return i;
        return -1;
    }

    /*********************************************************************************************************************
     ** The 'reverse' method handles the reversal of a string array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String[] reverse(String[] array) {
        if (array == null) return null;
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        Collections.reverse(stringList);
        return stringList.toArray(new String[0]);
    }

    /*********************************************************************************************************************
     ** The 'remove' method handles the removal of a specified string from the string array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String[] remove(String text, String[] array) {
        if (array == null) return null;
        return Arrays.stream(array).filter(s -> !s.equals(text)).toArray(String[]::new);
    }

    /*********************************************************************************************************************
     ** The 'add' method handles the adding of a specified string to the string array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String[] add(String text, String[] array) {
        if (array == null) return null;
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = text;
        return newArray;
    }

    /*********************************************************************************************************************
     ** The 'toArray' method handles the conversion of a list of objects to a string array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String[] toArray(List<?> list) {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = String.valueOf(list.get(i));
        return result;
    }

    /*********************************************************************************************************************
     ** The 'reverse' method handles the reversal of an integer array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int[] reverse(int[] array) {
        if (array == null) return null;
        List<Integer> numbersList = new ArrayList<>();
        for (int num : array) numbersList.add(num);
        Collections.reverse(numbersList);
        return numbersList.stream().mapToInt(Integer::intValue).toArray();
    }

    /*********************************************************************************************************************
     ** The 'remove' method handles the removal of a specified integer from the integer array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int[] remove(int number, int[] array) {
        if (array == null) return null;
        return Arrays.stream(array).filter(value -> value != number).toArray();
    }

    /*********************************************************************************************************************
     ** The 'add' method handles the adding of a specified integer to the integer array.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int[] add(int number, int[] array) {
        if (array == null) return null;
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = number;
        return newArray;
    }

    /*********************************************************************************************************************
     ** The 'toArray' method handles the conversion of a string into an integer array, splitting it by a delimiter.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static int[] toArray(String input, String delimiter) {
        String[] parts = input.split(delimiter);
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) result[i] = Integer.parseInt(parts[i].trim());
        return result;
    }

    /*********************************************************************************************************************
     ** The 'toList' method handles the conversion of a string to a list of integers, separated by a delimiter.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static List<Integer> toList(String input, String delimiter) {
        String[] parts = input.split(delimiter);
        List<Integer> result = new ArrayList<>();
        for (String part : parts) result.add(Integer.parseInt(part.trim()));
        return result;
    }

}
