package pages;

import utilities.objects.Locator;

public class MyBets {

    /***************************************************************************************************************
     * These are the container components on the My Bets Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator HistoryCards = new Locator(
                "History Cards",
                "Container",
                "My Bets Page",
                "//div[@class='history_card']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the My Bets Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Back = new Locator(
                "Back",
                "Button",
                "My Bets Page",
                "//button[@class='back_btn']"
        );
        public static Locator Running = new Locator(
                "Running",
                "Button",
                "My Bets Page",
                "//button[normalize-space()='Running']"
        );
        public static Locator Settled = new Locator(
                "Settled",
                "Button",
                "My Bets Page",
                "//button[normalize-space()='Settled']"
        );
        public static Locator Details = new Locator(
                "Details",
                "Button",
                "My Bets Page",
                "//button[normalize-space()='Details']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the My Bets Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator TotalBetHistory = new Locator(
                "Total Bet History",
                "Label",
                "My Bets Page",
                "//div[@class='total']//p[1]"
        );
        public static Locator TableName = new Locator(
                "Table Name",
                "Label",
                "My Bets Page",
                "//div[@class='title']//p"
        );
        public static Locator RoundId = new Locator(
                "Round ID",
                "Label",
                "My Bets Page",
                "//div[@class='title']//span[not(@class='icon')]"
        );
        public static Locator GameStatus = new Locator(
                "Game Status",
                "Label",
                "My Bets Page",
                "//div[contains(@class, 'status')]"
        );
        public static Locator Stake = new Locator(
                "Stake",
                "Label",
                "My Bets Page",
                "//h3[contains(normalize-space(), 'Stake')]/ancestor::div[1]//p"
        );
        public static Locator WinLoss = new Locator(
                "Win/Loss",
                "Label",
                "My Bets Page",
                "//h3[contains(normalize-space(), 'Win/Loss')]/ancestor::div[1]//p"
        );
        public static Locator RefNo = new Locator(
                "Reference Number",
                "Label",
                "My Bets Page",
                "//div[@class='info']//p[1]"
        );
        public static Locator BetDate = new Locator(
                "Bet Date",
                "Label",
                "My Bets Page",
                "//div[@class='info']//p[2]"
        );
        public static Locator SettledMessage = new Locator(
                "All transactions are time stamped at GMT-4.",
                "Label",
                "My Bets Page",
                "//div[@id='Settled_history']//p[@class='time_stamped'][normalize-space()='All transactions are time stamped at GMT-4.']"
        );
        public static Locator RunningMessage = new Locator(
                "All transactions are time stamped at GMT-4.",
                "Label",
                "My Bets Page",
                "//div[@id='Running_history']//p[@class='time_stamped'][normalize-space()='All transactions are time stamped at GMT-4.']"
        );
        public static Locator RunningRoundId = new Locator(
                "Running Round ID",
                "Label",
                "My Bets Page",
                "//div[@id='Running_history']//div[@class='title']//span[not(@class='icon')]"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the My Bets Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Locator getDetailsButton(String roundId) {
            return new Locator(
                    "Round ID #" + roundId + " Details",
                    "Button",
                    "My Bets Page",
                    "//span[contains(normalize-space(), '" + roundId + "')]/ancestor::div[3]" +
                            "//button[normalize-space()='Details']"
            );
        }
    }

}
