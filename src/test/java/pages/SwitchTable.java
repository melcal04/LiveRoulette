package pages;

import utilities.objects.Locator;

public class SwitchTable {

    /***************************************************************************************************************
     * These are the container components on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator JumpTable = new Locator(
                "Jump Table",
                "Container",
                "Switch Table Page",
                "div[class='jump_table'] div[class='wrapper']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator SicBoGame = new Locator(
                "Sic Bo Game",
                "Button",
                "Switch Table Page",
                "//p[normalize-space()='Sic Bo']/ancestor::button"
        );
        public static Locator InactiveGames = new Locator(
                "List of Inactive Games",
                "Button",
                "Switch Table Page",
                "//button[@class='game_icon icon']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator YouAreHere = new Locator(
                "You Are Here",
                "Label",
                "Switch Table Page",
                "//div[@class='table_card active']//p[contains(text(),'You are here')]"
        );
        public static Locator ActiveGame = new Locator(
                "Active Game",
                "Label",
                "Switch Table Page",
                "//button[@class='game_icon active icon']//p"
        );
        public static Locator InactiveGameNames = new Locator(
                "List of Inactive Game Names",
                "Label",
                "Switch Table Page",
                "//button[@class='game_icon icon']//p"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Locator getTableCards(boolean isActiveInclude) {
            return new Locator(
                    "List of " + (isActiveInclude ? "Table Cards" : "Table Cards (Active Not Included)"),
                    "Container",
                    "Switch Table Page",
                    isActiveInclude ? "//div[contains(@class, 'table_card')]" : "//div[@class='table_card']"
            );
        }
        public static Locator getAllCounters(String table) {
            return new Locator(
                    "List of All Counters in Dealer Table " + table,
                    "Label",
                    "Game Lobby Page",
                    "//h3[normalize-space()='Table " + table + "']/ancestor::div[2]" +
                            "//main//div[@class='line_statistics']//div//span[@class='number']"
            );
        }
    }

}
