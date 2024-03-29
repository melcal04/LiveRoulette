package globals;

import pages.DealerTable;
import utilities.objects.Locator;

public class TestVariables {

    /*********************************************************************************************************************
     ** These constants and variables are used to find specific betting options in the Live Roulette Mobile Revamp.
     *********************************************************************************************************************/

    public static final String RED = "red", BLACK = "black", EVEN = "even", ODD = "odd", LOW = "1to18", HIGH = "19to36";
    public static final String[] SIDE_LIST = { RED, BLACK, EVEN, ODD, LOW, HIGH };
    public static final String FIRST_DOZEN = "1st12", SECOND_DOZEN = "2nd12", THIRD_DOZEN = "3rd12";
    public static final String[] DOZEN_LIST = { FIRST_DOZEN, SECOND_DOZEN, THIRD_DOZEN };
    public static final int FIRST_COLUMN = 1, SECOND_COLUMN = 2, THIRD_COLUMN = 3;
    public static final int[] COLUMN_LIST = { FIRST_COLUMN, SECOND_COLUMN, THIRD_COLUMN };
    public static final int[] FIRST_COLUMN_NUMBERS = new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
    public static final int[] SECOND_COLUMN_NUMBERS = new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
    public static final int[] THIRD_COLUMN_NUMBERS = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
    public static final int[][][] SPLIT_LIST = {
            {{1, 2}, {0, 1}},
            {{2, 2}, {0, 2}},
            {{3, 2}, {0, 3}},
            {{4, 2}, {1, 4}},
            {{5, 2}, {2, 5}},
            {{6, 2}, {3, 6}},
            {{7, 2}, {4, 7}},
            {{8, 2}, {5, 8}},
            {{9, 2}, {6, 9}},
            {{10, 2}, {7, 10}},
            {{11, 2}, {8, 11}},
            {{12, 2}, {9, 12}},
            {{13, 2}, {10, 13}},
            {{14, 2}, {11, 14}},
            {{15, 2}, {12, 15}},
            {{16, 2}, {13, 16}},
            {{17, 2}, {14, 17}},
            {{18, 2}, {15, 18}},
            {{19, 2}, {16, 19}},
            {{20, 2}, {17, 20}},
            {{21, 2}, {18, 21}},
            {{22, 2}, {19, 22}},
            {{23, 2}, {20, 23}},
            {{24, 2}, {21, 24}},
            {{25, 2}, {22, 25}},
            {{26, 2}, {23, 26}},
            {{27, 2}, {24, 27}},
            {{28, 2}, {25, 28}},
            {{29, 2}, {26, 29}},
            {{30, 2}, {27, 30}},
            {{31, 2}, {28, 31}},
            {{32, 2}, {29, 32}},
            {{33, 2}, {30, 33}},
            {{34, 2}, {31, 34}},
            {{35, 2}, {32, 35}},
            {{36, 2}, {33, 36}},
            {{2, 3}, {1, 2}},
            {{3, 3}, {2, 3}},
            {{5, 3}, {4, 5}},
            {{6, 3}, {5, 6}},
            {{8, 3}, {7, 8}},
            {{9, 3}, {8, 9}},
            {{11, 3}, {10, 11}},
            {{12, 3}, {11, 12}},
            {{14, 3}, {13, 14}},
            {{15, 3}, {14, 15}},
            {{17, 3}, {16, 17}},
            {{18, 3}, {17, 18}},
            {{20, 3}, {19, 20}},
            {{21, 3}, {20, 21}},
            {{23, 3}, {22, 23}},
            {{24, 3}, {23, 24}},
            {{26, 3}, {25, 26}},
            {{27, 3}, {26, 27}},
            {{29, 3}, {28, 29}},
            {{30, 3}, {29, 30}},
            {{32, 3}, {31, 32}},
            {{33, 3}, {32, 33}},
            {{35, 3}, {34, 35}},
            {{36, 3}, {35, 36}}
    };
    public static final int[][][] STREET_LIST = {
            {{1, 3}, {1, 2, 3}},
            {{4, 3}, {4, 5, 6}},
            {{7, 3}, {7, 8, 9}},
            {{10, 3}, {10, 11, 12}},
            {{13, 3}, {13, 14, 15}},
            {{16, 3}, {16, 17, 18}},
            {{19, 3}, {19, 20, 21}},
            {{22, 3}, {22, 23, 24}},
            {{25, 3}, {25, 26, 27}},
            {{28, 3}, {28, 29, 30}},
            {{31, 3}, {31, 32, 33}},
            {{34, 3}, {34, 35, 36}}
    };
    public static final int[][][] CORNER_LIST = {
            {{5, 1}, {1, 2, 4, 5}},
            {{6, 1}, {2, 3, 5, 6}},
            {{8, 1}, {4, 5, 7, 8}},
            {{9, 1}, {5, 6, 8, 9}},
            {{11, 1}, {7, 8, 10, 11}},
            {{12, 1}, {8, 9, 11, 12}},
            {{14, 1}, {10, 11, 13, 14}},
            {{15, 1}, {11, 12, 14, 15}},
            {{17, 1}, {13, 14, 16, 17}},
            {{18, 1}, {14, 15, 17, 18}},
            {{20, 1}, {16, 17, 19, 20}},
            {{21, 1}, {17, 18, 20, 21}},
            {{23, 1}, {19, 20, 22, 23}},
            {{24, 1}, {20, 21, 23, 24}},
            {{26, 1}, {22, 23, 25, 26}},
            {{27, 1}, {23, 24, 26, 27}},
            {{29, 1}, {25, 26, 28, 29}},
            {{30, 1}, {26, 27, 29, 30}},
            {{32, 1}, {28, 29, 31, 32}},
            {{33, 1}, {29, 30, 32, 33}},
            {{35, 1}, {31, 32, 34, 35}},
            {{36, 1}, {32, 33, 35, 36}}
    };
    public static final int[][][] SIX_LINE_LIST = {
            {{4, 1}, {1, 2, 3, 4, 5, 6}},
            {{7, 1}, {4, 5, 6, 7, 8, 9}},
            {{10, 1}, {7, 8, 9, 10, 11, 12}},
            {{13, 1}, {10, 11, 12, 13, 14, 15}},
            {{16, 1}, {13, 14, 15, 16, 17, 18}},
            {{19, 1}, {16, 17, 18, 19, 20, 21}},
            {{22, 1}, {19, 20, 21, 22, 23, 24}},
            {{25, 1}, {22, 23, 24, 25, 26, 27}},
            {{28, 1}, {25, 26, 27, 28, 29, 30}},
            {{31, 1}, {28, 29, 30, 31, 32, 33}},
            {{34, 1}, {31, 32, 33, 34, 35, 36}}
    };
    public static final int[][][] ZERO_SECTION_LIST = {{{1, 1}, {0, 1, 2, 3}}};
    public static final int[][][] ZERO_CORNER_LIST = {{{2, 1}, {0, 1, 2}}, {{3, 1}, {0, 2, 3}}};

    /*********************************************************************************************************************
     ** These constants and variables are used to find collections of locators in the Live Roulette Mobile Revamp.
     *********************************************************************************************************************/

    public static Locator[] ACTION_BUTTONS = {
            DealerTable.Button.Undo,
            DealerTable.Button.Double,
            DealerTable.Button.Confirm
    };

}
