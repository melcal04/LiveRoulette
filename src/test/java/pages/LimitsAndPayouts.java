package pages;

import utilities.objects.Locator;

public class LimitsAndPayouts {

    /***************************************************************************************************************
     * These are the button components on the Limits And Payouts Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Back = new Locator(
                "Back",
                "Button",
                "Limits And Payouts Page",
                "//div[@class='nav_bar']//button[@class='back_btn']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Limits And Payouts Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator TableName = new Locator(
                "Table Name",
                "Label",
                "Limits And Payouts Page",
                "//h3[contains(normalize-space(), 'Roulette')]"
        );
        public static Locator TableLimit = new Locator(
                "Table Limit",
                "Label",
                "Limits And Payouts Page",
                "//h3[contains(normalize-space(), 'Roulette')]//span"
        );
        public static Locator StraightUpLimit = new Locator(
                "Straight Up Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Straight-up']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator StraightUpPayout = new Locator(
                "Straight Up Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Straight-up']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator EvenChanceLimit = new Locator(
                "Even Chance Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Even Chance']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator EvenChancePayout = new Locator(
                "Even Chance Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Even Chance']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator DozenColumnLimit = new Locator(
                "Dozen Column Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Dozen/Column']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator DozenColumnPayout = new Locator(
                "Dozen Column Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Dozen/Column']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator SplitLimit = new Locator(
                "Split Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Split']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator SplitPayout = new Locator(
                "Split Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Split']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator StreetLimit = new Locator(
                "Street Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Street']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator StreetPayout = new Locator(
                "Street Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Street']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator SixLineLimit = new Locator(
                "Six Line Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Six Line']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator SixLinePayout = new Locator(
                "Six Line Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Six Line']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator CornerZeroSectionLimit = new Locator(
                "Corner Zero Section Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Corner/Zero Section']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator CornerZeroSectionPayout = new Locator(
                "Corner Zero Section Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Corner/Zero Section']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Locator ZeroCornerLimit = new Locator(
                "Zero Corner Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Zero Corner']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Locator ZeroCornerPayout = new Locator(
                "Zero Corner Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Zero Corner']/ancestor::div[1]//div[@class='row_item'][3]"
        );
    }

}
