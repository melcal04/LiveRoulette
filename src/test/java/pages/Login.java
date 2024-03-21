package pages;

import utilities.objects.Locator;

public class Login {

    /***************************************************************************************************************
     * These are the container components on the Login Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator LoginModal = new Locator(
                "Login Modal",
                "Container",
                "Login Page",
                "//div[@class='loginModal-content formArea']"
        );
    }

    /***************************************************************************************************************
     * These are the thumbnail components on the Login Page.
     ***************************************************************************************************************/

    public static class Thumbnail {
        public static Locator LiveCasino = new Locator(
                "Live Casino",
                "Thumbnail",
                "Login Page",
                "//div[@class='productThumbnail-item JARVIS_LandingPage_ProductSelection_Btn_Casino']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Login Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Submit = new Locator(
                "Submit Login Form",
                "Button",
                "Login Page",
                "//button[@id='btnSubmit']"
        );
    }

    /***************************************************************************************************************
     * These are the textBox components on the Login Page.
     ***************************************************************************************************************/

    public static class TextBox {
        public static Locator Username = new Locator(
                "Username",
                "TextBox",
                "Login Page",
                "//input[@id='inputLoginName']"
        );
        public static Locator Password = new Locator(
                "Password",
                "TextBox",
                "Login Page",
                "//input[@id='inputPassword']"
        );
    }

    /***************************************************************************************************************
     * These are the dropdown components on the Login Page.
     ***************************************************************************************************************/

    public static class Dropdown {
        public static Locator Language = new Locator(
                "Language",
                "Dropdown",
                "Login Page",
                "//select[contains(@class, 'switchLanguage-select')]"
        );
    }

}
