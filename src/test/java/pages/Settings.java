package pages;

import utilities.objects.Locator;

public class Settings {

    /***************************************************************************************************************
     * These are the button components on the Settings Page.
     ***************************************************************************************************************/
    public static class Button {
        public static Locator Back = new Locator(
                "Back",
                "Button",
                "Settings Page",
                "//div[@class='nav_bar']//button[@class='back_btn']"
        );
    }

    /***************************************************************************************************************
     * These are the radio button components on the Settings Page.
     ***************************************************************************************************************/
    public static class RadioButton {
        public static Locator Music = new Locator(
                "Music",
                "Radio Button",
                "Settings Page",
                "//span[normalize-space()='Music']/ancestor::div[2]//label//input"
        );
        public static Locator Voice = new Locator(
                "Voice",
                "Radio Button",
                "Settings Page",
                "//span[normalize-space()='Voice']/ancestor::div[2]//label//input"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Settings Page.
     ***************************************************************************************************************/
    public static class Label {
        public static Locator Music = new Locator(
                "Music",
                "Label",
                "Settings Page",
                "//span[normalize-space()='Music']"
        );
        public static Locator Voice = new Locator(
                "Voice",
                "Label",
                "Settings Page",
                "//span[normalize-space()='Voice']"
        );
    }

}
