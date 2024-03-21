package pages;

import utilities.objects.Locator;

public class Statistics {

    /***************************************************************************************************************
     * These are the container components on the Statistics Page.
     ***************************************************************************************************************/
    public static class Container {
        public static Locator Statistics = new Locator(
                "Statistics",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']"
        );
        public static Locator AllResults = new Locator(
                "All Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p"
        );
        public static Locator RedResults = new Locator(
                "Red Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[contains(@class, 'number_red')]"
        );
        public static Locator ZeroResults = new Locator(
                "Zero Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) = 0]"
        );
        public static Locator BlackResults = new Locator(
                "Black Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[contains(@class, 'number_black')]"
        );
        public static Locator OddResults = new Locator(
                "Odd Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) mod 2 != 0]"
        );
        public static Locator EvenResults = new Locator(
                "Even Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) mod 2 = 0 and number(.) != 0]"
        );
        public static Locator LowResults = new Locator(
                "Low Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) >= 1 and number(.) <= 18]"
        );
        public static Locator HighResults = new Locator(
                "High Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) >= 19 and number(.) <= 36]"
        );
        public static Locator FirstDozenResults = new Locator(
                "First Dozen Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) >= 1 and number(.) <= 12]"
        );
        public static Locator SecondDozenResults = new Locator(
                "Second Dozen Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) >= 13 and number(.) <= 24]"
        );
        public static Locator ThirdDozenResults = new Locator(
                "Third Dozen Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[number(.) >= 25 and number(.) <= 36]"
        );
        public static Locator FirstColumnResults = new Locator(
                "First Column Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li" +
                        "//p[number(.) = 1 or number(.) = 4 or number(.) = 7 or number(.) = 10 or " +
                        "number(.) = 13 or number(.) = 16 or number(.) = 19 or number(.) = 22 or number(.) = 25 or " +
                        "number(.) = 28 or number(.) = 31 or number(.) = 34]"
        );
        public static Locator SecondColumnResults = new Locator(
                "Second Column Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li" +
                        "//p[number(.) = 2 or number(.) = 5 or number(.) = 8 or number(.) = 11 or " +
                        "number(.) = 14 or number(.) = 17 or number(.) = 20 or number(.) = 23 or number(.) = 26 or " +
                        "number(.) = 29 or number(.) = 32 or number(.) = 35]"
        );
        public static Locator ThirdColumnResults = new Locator(
                "Third Column Results",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li" +
                        "//p[number(.) = 3 or number(.) = 6 or number(.) = 9 or number(.) = 12 or " +
                        "number(.) = 15 or number(.) = 18 or number(.) = 21 or number(.) = 24 or number(.) = 27 or " +
                        "number(.) = 30 or number(.) = 33 or number(.) = 36]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Statistics Page.
     ***************************************************************************************************************/
    public static class Button {
        public static Locator CloseStatistics = new Locator(
                "Close Statistics",
                "Button",
                "Statistics Page",
                "//button[@class='statistics_header_close_btn']"
        );
        public static Locator OpenInformation = new Locator(
                "Close Information",
                "Button",
                "Statistics Page",
                "//button[@class='statistics_header_info_btn']"
        );
        public static Locator CloseInformation = new Locator(
                "Close Information",
                "Button",
                "Statistics Page",
                "//div[@class='info_modal_close']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Statistics Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator ShowTimer = new Locator(
                "Show Timer",
                "Label",
                "Statistics Page",
                "//p[@id='showTimer']"
        );
        public static Locator ShowDealing = new Locator(
                "Show Dealing",
                "Label",
                "Statistics Page",
                "//p[@id='showDealingWording']"
        );
        public static Locator RedPercentage = new Locator(
                "Red Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='color_diamond color_diamond_red']/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator ZeroPercentage = new Locator(
                "Zero Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='color_diamond color_diamond_green']/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator BlackPercentage = new Locator(
                "Black Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='color_diamond color_diamond_black']/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator OddPercentage = new Locator(
                "Odd Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'ODD')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator EvenPercentage = new Locator(
                "Even Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'EVEN')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator HighPercentage = new Locator(
                "High Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'19-36')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator LowPercentage = new Locator(
                "Low Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'1-18')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator FirstDozenPercentage = new Locator(
                "First Dozen Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'1st Dozen')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator SecondDozenPercentage = new Locator(
                "Second Dozen Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'2nd Dozen')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator ThirdDozenPercentage = new Locator(
                "Third Dozen Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'3rd Dozen')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator FirstColPercentage = new Locator(
                "First Column Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'1st Column')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator SecondColPercentage = new Locator(
                "Second Column Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'2nd Column')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator ThirdColPercentage = new Locator(
                "Third Column Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'3rd Column')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Locator HotNumbers = new Locator(
                "List of Hot Numbers",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][1]//div[@class='number_count']//div[1]"
        );
        public static Locator HotCounters = new Locator(
                "List of Hot Counters",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][1]//div[@class='number_count']//div[2]"
        );
        public static Locator ColdNumbers = new Locator(
                "List of Cold Numbers",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][2]//div[@class='number_count']//div[1]"
        );
        public static Locator ColdCounters = new Locator(
                "List of Cold Counters",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][2]//div[@class='number_count']//div[2]"
        );
        public static Locator Info = new Locator(
                "List of Information",
                "Label",
                "Statistics Page",
                "//div[@class='statistics_info_modal']//div[@class='info_list']"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Statistics Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Locator getHotResults(int total) {
            return new Locator(
                    "Hot Results",
                    "Container",
                    "Statistics Page",
                    "//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[text()='" + total + "']"
            );
        }
        public static Locator getColdResults(int total) {
            return new Locator(
                    "Cold Results",
                    "Container",
                    "Statistics Page",
                    "(//div[@class='statistics']//div[@class='roulette_line_roadmap']//li//p[text()='" +
                            total + "'])[position()=1]/ancestor::li/preceding-sibling::li"
            );
        }
    }

}
