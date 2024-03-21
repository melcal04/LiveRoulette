package pages;

import utilities.objects.Locator;

public class ChipSettings {

    /***************************************************************************************************************
     * These are the container components on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator MyChips = new Locator(
                "List of My Chips",
                "Container",
                "Chip Settings Page",
                "//div[@class='chips']//button[@class='chip']"
        );
        public static Locator ChipSelections = new Locator(
                "List of Chip Selections",
                "Container",
                "Chip Settings Page",
                "//div[@class='chips chips_selections']//button[not(contains(@style, 'display: none'))]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Cancel = new Locator(
                "Cancel",
                "Button",
                "Chip Settings Page",
                "//button[@class='btn_cancel']"
        );
        public static Locator Save = new Locator(
                "Save",
                "Button",
                "Chip Settings Page",
                "//button[normalize-space()='Save']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator MyChips = new Locator(
                "My Chips",
                "Label",
                "Chip Settings Page",
                "//span[normalize-space()='My Chips']"
        );
        public static Locator ChipSelections = new Locator(
                "Chip Selections",
                "Label",
                "Chip Settings Page",
                "//span[normalize-space()='Selections']"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Locator getChipSelection(String chipValue) {
            return new Locator(
                    "#" + chipValue + " Chip Selection",
                    "Button",
                    "Chip Settings Page",
                    "//div[@class='chips chips_selections']" +
                            "//button[not(contains(@style, 'display: none'))]" +
                            "//p[text()='" + chipValue + "']/ancestor::button"
            );
        }
    }

}
