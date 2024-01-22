package pages;

import utilities.objects.Component;

public class Statistics {

    /***************************************************************************************************************
     * These are the container components on the Statistics Page.
     ***************************************************************************************************************/
    public static class Container {
        public static Component Statistics = new Component(
                "Statistics",
                "Container",
                "Statistics Page",
                "//div[@class='statistics']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Statistics Page.
     ***************************************************************************************************************/
    public static class Button {
        public static Component CloseStatistics = new Component(
                "Close Statistics",
                "Button",
                "Statistics Page",
                "//button[@class='statistics_header_close_btn']"
        );
        public static Component OpenInformation = new Component(
                "Close Information",
                "Button",
                "Statistics Page",
                "//button[@class='statistics_header_info_btn']"
        );
        public static Component CloseInformation = new Component(
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
        public static Component ShowTimer = new Component(
                "Show Timer",
                "Label",
                "Statistics Page",
                "//p[@id='showTimer']"
        );
        public static Component ShowDealing = new Component(
                "Show Dealing Wording",
                "Label",
                "Statistics Page",
                "//p[@id='showDealingWording']"
        );
        public static Component RedPercentage = new Component(
                "Red Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='color_diamond color_diamond_red']/following::div[contains(@class,'percentage')][1]"
        );
        public static Component ZeroPercentage = new Component(
                "Zero Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='color_diamond color_diamond_green']/following::div[contains(@class,'percentage')][1]"
        );
        public static Component BlackPercentage = new Component(
                "Black Percentage",
                "Label",
                "Statistics Page",
                "//div[@class='color_diamond color_diamond_black']/following::div[contains(@class,'percentage')][1]"
        );
        public static Component OddPercentage = new Component(
                "Odd Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'ODD')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component EvenPercentage = new Component(
                "Even Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'EVEN')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component HighPercentage = new Component(
                "High Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'19-36')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component LowPercentage = new Component(
                "Low Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'1-18')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component FirstDozenPercentage = new Component(
                "First Dozen Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'1st Dozen')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component SecondDozenPercentage = new Component(
                "Second Dozen Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'2nd Dozen')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component ThirdDozenPercentage = new Component(
                "Third Dozen Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'3rd Dozen')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component FirstColPercentage = new Component(
                "First Column Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'1st Column')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component SecondColPercentage = new Component(
                "Second Column Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'2nd Column')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component ThirdColPercentage = new Component(
                "Third Column Percentage",
                "Label",
                "Statistics Page",
                "//div[contains(text(),'3rd Column')]/following::div[contains(@class,'percentage')][1]"
        );
        public static Component HotNumbers = new Component(
                "List of Hot Numbers",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][1]//div[@class='number_count']//div[1]"
        );
        public static Component HotCounters = new Component(
                "List of Hot Counters",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][1]//div[@class='number_count']//div[2]"
        );
        public static Component ColdNumbers = new Component(
                "List of Cold Numbers",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][2]//div[@class='number_count']//div[1]"
        );
        public static Component ColdCounters = new Component(
                "List of Cold Counters",
                "Label",
                "Statistics Page",
                "//div[@class='temperaturList'][2]//div[@class='number_count']//div[2]"
        );
        public static Component Info = new Component(
                "List of Information",
                "Label",
                "Statistics Page",
                "//div[@class='statistics_info_modal']//div[@class='info_list']"
        );
    }

}
