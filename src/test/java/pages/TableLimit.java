package pages;

import utilities.objects.Locator;

public class TableLimit {

    /***************************************************************************************************************
     * These are the button components on the Table Limit Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator ActiveTableLimit = new Locator(
                "Active Table Limit",
                "Button",
                "Table Limit Page",
                "//li[@class='table_limit active']"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Table Limit Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Locator getTableLimits(boolean isActiveInclude) {
            return new Locator(
                    "List of " + (isActiveInclude ? "Table Limits" : "Table Limits (Active Not Included)"),
                    "Button",
                    "Table Limit Page",
                    isActiveInclude ? "//div[@class='side_section_bottom']//button[2]//li" : "//li[@class='table_limit']"
            );
        }
    }

}
