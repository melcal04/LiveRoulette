package pages;

import utilities.objects.Component;

public class Login {

    /***************************************************************************************************************
     * These are the button components on the Login Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component OpenLoginModal = new Component(
                "Open Login Modal",
                "Button",
                "Login Page",
                "//button[@id='btnOpenLogin']"
        );
        public static Component Submit = new Component(
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
        public static Component Username = new Component(
                "Username",
                "TextBox",
                "Login Page",
                "//input[@id='inputLoginName']"
        );
        public static Component Password = new Component(
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
        public static Component Language = new Component(
                "Language",
                "Dropdown",
                "Login Page",
                "//select[contains(@class, 'switchLanguage-select')]"
        );
    }

}
