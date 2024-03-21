package pages;

import utilities.objects.Locator;

public class Help {

    /***************************************************************************************************************
     * These are the container components on the Help Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator Basics = new Locator(
                "The Basics Information",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'Basics')]"
        );
        public static Locator BetOptions = new Locator(
                "Bet Options and How to Win Information",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'BetOption')]"
        );
        public static Locator GameControls = new Locator(
                "What are the Game Controls Information",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'GameControl')]"
        );
        public static Locator Likelihood = new Locator(
                "What is My Likelihood of Winning Information",
                "Container",
                "Help Page",
                "//details[contains(@data-gtm, 'Likelihood')]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Help Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Back = new Locator(
                "Back",
                "Button",
                "Help Page",
                "//div[@class='nav_bar']//button[@class='back_btn']"
        );
        public static Locator Basics = new Locator(
                "The Basics Information",
                "Button",
                "Help Page",
                "//summary[normalize-space()='The Basics']"
        );
        public static Locator BetOptions = new Locator(
                "Bet Options and How to Win Information",
                "Button",
                "Help Page",
                "//summary[normalize-space()='Bet Options and How to Win']"
        );
        public static Locator GameControls = new Locator(
                "What are the Game Controls Information",
                "Button",
                "Help Page",
                "//summary[normalize-space()='What are the Game Controls']"
        );
        public static Locator Likelihood = new Locator(
                "What is My Likelihood of Winning Information",
                "Button",
                "Help Page",
                "//summary[normalize-space()='What is My Likelihood of Winning']"
        );
    }

}
