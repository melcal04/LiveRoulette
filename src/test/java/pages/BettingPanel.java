package pages;

import utilities.objects.Locator;

public class BettingPanel {

    /*********************************************************************************************************************
     ** These are the options on the Betting Container.
     *********************************************************************************************************************/

    public static class Option {
        public static Locator getSide(String side) {
            return new Locator(
                    switch (side) {
                        case "red" -> "Red Betting Option";
                        case "black" -> "Black Betting Option";
                        case "even" -> "Even Betting Option";
                        case "odd" -> "Odd Betting Option";
                        case "1to18" -> "Low Betting Option";
                        case "19to36" -> "High Betting Option";
                        default -> "";
                    },
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option side_bet_option side_bet_option_" + side + "')]"
            );
        }
        public static Locator getDozen(String dozen) {
            return new Locator(
                    switch (dozen) {
                        case "1st12" -> "1st Dozen Betting Option";
                        case "2nd12" -> "2nd Dozen Betting Option";
                        case "3rd12" -> "3rd Dozen Betting Option";
                        default -> "";
                    },
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option side_bet_option side_bet_option_" + dozen + "')]"
            );
        }
        public static Locator getColumn(int column) {
            return new Locator(
                    switch (column) {
                        case 1 -> "1st Column Betting Option";
                        case 2 -> "2nd Column Betting Option";
                        case 3 -> "3rd Column Betting Option";
                        default -> "";
                    },
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option col_bet_option" +
                            " col_bet_option_2to1_" + column + "')]"
            );
        }
        public static Locator getNumber(int number) {
            return new Locator(
                    "Straight Up #" + number + " Betting Option",
                    "Button",
                    "Betting Container",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + number + "')][1]"
            );
        }
        public static Locator getSplit(int[][] split) {
            int[] position = split[0];
            int[] numbers = split[1];
            return new Locator(
                    "Split #" + numbers[0] + " & #" + numbers[1] + " Betting Option",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]"
            );
        }
        public static Locator getStreet(int[][] street) {
            int[] position = street[0];
            int[] numbers = street[1];
            return new Locator(
                    "Street #" + numbers[0] + ", #" + numbers[1] + ", & #" + numbers[2] + " Betting Option",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]"
            );
        }
        public static Locator getCorner(int[][] corner) {
            int[] position = corner[0];
            int[] numbers = corner[1];
            return new Locator(
                    "Corner #" + numbers[0] + ", #" + numbers[1] + ", #" + numbers[2] + ", & #" + numbers[3] + " Betting Option",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]"
            );
        }
        public static Locator getSixLine(int[][] sixLine) {
            int[] position = sixLine[0];
            int[] numbers = sixLine[1];
            return new Locator(
                    "Six Line #" + numbers[0] + ", #" + numbers[1] + ", #" + numbers[2] + ", & #" + numbers[3] + ", #" +
                            numbers[4] + ", #" + numbers[5] + " Betting Option",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]"
            );
        }
        public static Locator getZeroSection(int[][] zeroSection) {
            int[] position = zeroSection[0];
            int[] numbers = zeroSection[1];
            return new Locator(
                    "Zero Section #" + numbers[0] + ", #" + numbers[1] + ", #" + numbers[2] + ", & #" + numbers[3] + " Betting Option",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]"
            );
        }
        public static Locator getZeroCorner(int[][] zeroCorner) {
            int[] position = zeroCorner[0];
            int[] numbers = zeroCorner[1];
            return new Locator(
                    "Zero Corner #" + numbers[0] + ", #" + numbers[1] + ", & #" + numbers[2] + " Betting Option",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]"
            );
        }
    }

    /*********************************************************************************************************************
     ** These are the chips on the Betting Container.
     *********************************************************************************************************************/

    public static class Chip {
        static String chipPath = "//div[contains(@class, 'chip_text')]";
        public static Locator getSide(String side) {
            return new Locator(
                    switch (side) {
                        case "red" -> "Red Betting Chip";
                        case "black" -> "Black Betting Chip";
                        case "even" -> "Even Betting Chip";
                        case "odd" -> "Odd Betting Chip";
                        case "1to18" -> "Low Betting Chip";
                        case "19to36" -> "High Betting Chip";
                        default -> "";
                    },
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option side_bet_option side_bet_option_" + side + "')]" + chipPath
            );
        }
        public static Locator getDozen(String dozen) {
            return new Locator(
                    switch (dozen) {
                        case "1st12" -> "1st Dozen Betting Chip";
                        case "2nd12" -> "2nd Dozen Betting Chip";
                        case "3rd12" -> "3rd Dozen Betting Chip";
                        default -> "";
                    },
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option side_bet_option side_bet_option_" + dozen + "')]" + chipPath
            );
        }
        public static Locator getColumn(int column) {
            return new Locator(
                    switch (column) {
                        case 1 -> "1st Column Betting Chip";
                        case 2 -> "2nd Column Betting Chip";
                        case 3 -> "3rd Column Betting Chip";
                        default -> "";
                    },
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option col_bet_option" +
                            " col_bet_option_2to1_" + column + "')]" + chipPath
            );
        }
        public static Locator getNumber(int number) {
            return new Locator(
                    "Straight Up #" + number + " Betting Chip",
                    "Button",
                    "Betting Container",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + number + "')][1]" + chipPath
            );
        }
        public static Locator getSplit(int[][] split) {
            int[] position = split[0];
            int[] numbers = split[1];
            return new Locator(
                    "Split #" + numbers[0] + " & #" + numbers[1] + " Betting Chip",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]" + chipPath
            );
        }
        public static Locator getStreet(int[][] street) {
            int[] position = street[0];
            int[] numbers = street[1];
            return new Locator(
                    "Street #" + numbers[0] + ", #" + numbers[1] + ", & #" + numbers[2] + " Betting Chip",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]" + chipPath
            );
        }
        public static Locator getCorner(int[][] corner) {
            int[] position = corner[0];
            int[] numbers = corner[1];
            return new Locator(
                    "Corner #" + numbers[0] + ", #" + numbers[1] + ", #" + numbers[2] + ", & #" + numbers[3] + " Betting Chip",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]" + chipPath
            );
        }
        public static Locator getSixLine(int[][] sixLine) {
            int[] position = sixLine[0];
            int[] numbers = sixLine[1];
            return new Locator(
                    "Six Line #" + numbers[0] + ", #" + numbers[1] + ", #" + numbers[2] + ", & #" + numbers[3] + ", #" +
                            numbers[4] + ", #" + numbers[5] + " Betting Chip",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]" + chipPath
            );
        }
        public static Locator getZeroSection(int[][] zeroSection) {
            int[] position = zeroSection[0];
            int[] numbers = zeroSection[1];
            return new Locator(
                    "Zero Section #" + numbers[0] + ", #" + numbers[1] + ", #" + numbers[2] + ", & #" + numbers[3] + " Betting Chip",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]" + chipPath
            );
        }
        public static Locator getZeroCorner(int[][] zeroCorner) {
            int[] position = zeroCorner[0];
            int[] numbers = zeroCorner[1];
            return new Locator(
                    "Zero Corner #" + numbers[0] + ", #" + numbers[1] + ", & #" + numbers[2] + " Betting Chip",
                    "Button",
                    "Betting Panel",
                    "//div[contains(@class, 'bet_option num_bet_option num_bet_option_" + position[0] + "')][1]" +
                            "//div[contains(@class, 'bet_option_chip_position pos_" + position[1] + "')]" + chipPath
            );
        }
    }

}
