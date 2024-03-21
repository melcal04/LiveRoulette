package pages;

import utilities.objects.Locator;

public class Menu {

    /***************************************************************************************************************
     * These are the button components on the Menu Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator MyBets = new Locator(
                "My Bets",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickMyBets']"
        );
        public static Locator LimitPayouts = new Locator(
                "Limit Payouts",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickLimitPayouts']"
        );
        public static Locator Help = new Locator(
                "Help",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickHelp']"
        );
        public static Locator Settings = new Locator(
                "Settings",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickSettings']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Menu Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator PlayerName = new Locator(
                "Player Name",
                "Label",
                "Menu Page",
                "//div[@class='menu open']//div//span"
        );
    }

}
