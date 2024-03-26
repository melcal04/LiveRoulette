package pages;

import settings.AccountManager;
import utilities.enums.TestEnvironment;
import utilities.objects.Locator;

public class GameLobby {

    /***************************************************************************************************************
     * These are the container components on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator DealerTables = new Locator(
                "List of Dealer Tables",
                "Container",
                "Game Lobby Page",
                "//div[@class='dealer station']"
        );
        public static Locator DealerPhotos = new Locator(
                "List of Dealer Photos",
                "Container",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='dealer_photo']"
        );
        public static Locator RoadMaps = new Locator(
                "List of Road Maps",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='roadmap_display']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Back = new Locator(
                "Back",
                "Button",
                "Game Lobby Page",
                "//button[@class='back_btn']"
        );
        public static Locator ActiveTableLimit = new Locator(
                "Active Table Limit",
                "Button",
                "Game Lobby Page",
                "//div[@class='tableLimit_list']//li[@class='active']"
        );
        public static Locator HideShowBalance = new Locator(
                "Hide/Show Balance",
                "Button",
                "Game Lobby Page",
                "//div[contains(@class, 'balance_btn')]"
        );
        public static Locator TableLimits = new Locator(
                "List of Table Limits",
                "Button",
                "Game Lobby Page",
                "//div[@class='tableLimit_list']//li"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator Balance = new Locator(
                "Balance",
                "Label",
                "Game Lobby Page",
                "//div[contains(@class, 'balance_btn')]//p"
        );
        public static Locator DealerNames = new Locator(
                "List of Dealer Names",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//span[@class='dealer_name']"
        );
        public static Locator TableNames = new Locator(
                "List of Table Names",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//p[@class='table_name']"
        );
        public static Locator FindATable = new Locator(
                "Let's find a table and start betting.",
                "Label",
                "Game Lobby Page",
                "//p[contains(normalize-space(), 'find a table and start betting')]"
        );
        public static Locator RedCounters = new Locator(
                "List of Red Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='line_statistics']//div[1]//span[2]"
        );
        public static Locator BlackCounters = new Locator(
                "List of Black Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='line_statistics']//div[2]//span[2]"
        );
        public static Locator ZeroCounters = new Locator(
                "List of Zero Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='line_statistics']//div[3]//span[2]"
        );
        public static Locator TotalRoundCounters = new Locator(
                "List of Total Round Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='line_statistics']//div[4]//span[3]"
        );
        public static Locator FirstResultInRoadMap = new Locator(
                "First Result In Road Map",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station'][1]//ul[1]//li[1]"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Method {
        private static final String tablePath = AccountManager.getEnvironment() == TestEnvironment.PRODUCTION ?
                "//div[contains(@class, 'dealer_btn')]//span[not(contains(text(),'Maintenance'))]/ancestor::div[4]" :
                "//div[contains(@class, 'dealer_top')]//p[(contains(text(),'Roulette X'))]/ancestor::div[2]";
        public static Locator getDealerTables() {
            return new Locator(
                    "List of Selected Dealer Tables",
                    "Container",
                    "Game Lobby Page",
                    tablePath
            );
        }
        public static Locator getDealerTable(String dealsOrTable) {
            return new Locator(
                    dealsOrTable + " Dealer Table",
                    "Container",
                    "Game Lobby Page",
                    tablePath + "//p[(contains(text(), '" +
                            dealsOrTable + "'))]/ancestor::div[2]"
            );
        }
        public static Locator getAllCounters(String dealsOrTable) {
            return new Locator(
                    "List of All Counters in " + dealsOrTable + " Dealer Table",
                    "Label",
                    "Game Lobby Page",
                    tablePath + "//p[(contains(text(), '" + dealsOrTable +
                            "'))]/ancestor::div[2]//div[@class='line_statistics']//div//span[@class='number']"
            );
        }
        public static Locator getTotalRoundCounter(String dealsOrTable) {
            return new Locator(
                    "Total Round Counter in " + dealsOrTable + " Dealer Table",
                    "Label",
                    "Game Lobby Page",
                    tablePath + "//p[(contains(text(), '" + dealsOrTable +
                            "'))]/ancestor::div[2]//div[@class='line_statistics']//div[4]//span[3]"
            );
        }
    }

}
