package pages;

import utilities.objects.Locator;

public class DealerTable {

    /***************************************************************************************************************
     * These are the container components on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Locator Timer = new Locator(
                "Timer",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class, 'timer_small')]"
        );
        public static Locator BettingOptions = new Locator(
                "Betting Options",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class,'roulette_bet_options')]"
        );
        public static Locator WinResult = new Locator(
                "Win Result",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class,'num_bet_option') and contains(@class, 'win')]"
        );
        public static Locator RoundResult = new Locator(
                "Round Result",
                "Container",
                "Dealer Table Page",
                "//div[@class='bet_result_roulette']"
        );
        public static Locator Notification = new Locator(
                "Notification",
                "Container",
                "Dealer Table Page",
                "//div[@class='snack_bar']"
        );
        public static Locator RedBettingChip = new Locator(
                "Red Betting Chip",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class, 'side_bet_option_red')]//div[contains(@class, 'chip chip')]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator Back = new Locator(
                "Back",
                "Button",
                "Dealer Table Page",
                "//button[@class='back_btn']"
        );
        public static Locator SkipWelcome = new Locator(
                "Skip Welcome",
                "Button",
                "Dealer Table Page",
                "//button[contains(@class,'welcome_skip_button')]"
        );
        public static Locator HideShowBalance = new Locator(
                "Hide/Show Balance",
                "Button",
                "Dealer Table Page",
                "//div[contains(@class, 'balance_btn')]"
        );
        public static Locator Menu = new Locator(
                "Menu",
                "Button",
                "Dealer Table Page",
                "//button[@class='menu']"
        );
        public static Locator SwitchTable = new Locator(
                "Switch Table",
                "Button",
                "Dealer Table Page",
                "//button[@class='tool_btn jump_table']"
        );
        public static Locator ExpandShrink = new Locator(
                "Expand/Shrink",
                "Button",
                "Dealer Table Page",
                "//div[@class='side_section_bottom']//button[1]"
        );
        public static Locator TableLimit = new Locator(
                "Table Limit",
                "Button",
                "Dealer Table Page",
                "//div[@class='side_section_bottom']//button[2]"
        );
        public static Locator Statistics = new Locator(
                "Statistics",
                "Button",
                "Dealer Table Page",
                "//div[@class='side_section_bottom']//button[3]"
        );
        public static Locator Undo = new Locator(
                "Undo",
                "Button",
                "Dealer Table Page",
                "//div[@class='pattern']//button[contains(@class, 'btn_cancel')]"
        );
        public static Locator Double = new Locator(
                "Double",
                "Button",
                "Dealer Table Page",
                "//button[contains(@class, 'btn_double')]"
        );
        public static Locator Confirm = new Locator(
                "Confirm",
                "Button",
                "Dealer Table Page",
                "//button[contains(@class, 'btn_') and contains(@class, 'confirm')]"
        );
        public static Locator EditChips = new Locator(
                "Edit Chips",
                "Button",
                "Dealer Table Page",
                "//div[@class='chip_set']//li[contains(@data-gtm, 'Btn_ClickChipCustomize')]"
        );
        public static Locator ChipOptions = new Locator(
                "List of Chip Options",
                "Button",
                "Dealer Table Page",
                "//div[@class='chip_set']//li[not(contains(@data-gtm, 'Btn_ClickChipCustomize'))]"
        );
        public static Locator PopUpConfirm = new Locator(
                "Pop Up Confirm",
                "Button",
                "Dealer Table Page",
                "//div[@class='popUp']//button[@class='confirm']"
        );
        public static Locator PopUpNotNow = new Locator(
                "Pop Up Not Now",
                "Button",
                "Dealer Table Page",
                "//div[@class='popUp']//button[normalize-space()='Not Now']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Locator WelcomeAndGoodLuck = new Locator(
                "Welcome and good luck.",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Welcome and good luck')]"
        );
        public static Locator ShowTimer = new Locator(
                "Show Timer",
                "Label",
                "Dealer Table Page",
                "//p[@id='showTimer']"
        );
        public static Locator PlaceYourBetsPlease = new Locator(
                "Place your bets please",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Place your bets please')]"
        );
        public static Locator ShowDealing = new Locator(
                "Show Dealing",
                "Label",
                "Dealer Table Page",
                "//p[@id='showDealingWording']"
        );
        public static Locator NoMoreBets = new Locator(
                "No more bets",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'No more bets')]"
        );
        public static Locator TableInfo = new Locator(
                "Table Information",
                "Label",
                "Dealer Table Page",
                "//p[@class='table_info']"
        );
        public static Locator TotalBet = new Locator(
                "Total Bet",
                "Label",
                "Dealer Table Page",
                "//p[@class='total_bet']"
        );
        public static Locator Balance = new Locator(
                "Balance",
                "Label",
                "Dealer Table Page",
                "//div[contains(@class, 'balance_btn')]//p"
        );
        public static Locator RoundResultNumber = new Locator(
                "Round Result Number",
                "Label",
                "Dealer Table Page",
                "//div[@class='bet_result_roulette']//li[3]"
        );
        public static Locator RoundResultLeftNumber = new Locator(
                "Round Result Left Number",
                "Label",
                "Dealer Table Page",
                "//div[@class='bet_result_roulette']//li[2]"
        );
        public static Locator RoundResultRightNumber = new Locator(
                "Round Result Right Number",
                "Label",
                "Dealer Table Page",
                "//div[@class='bet_result_roulette']//li[4]"
        );
        public static Locator FirstNumberInResultPanel = new Locator(
                "First Number In Result Panel",
                "Label",
                "Dealer Table Page",
                "//div[@class='roulette_line_roadmap']//li[1]//p[1]"
        );
        public static Locator BetsAccepted = new Locator(
                "Bets accepted.",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Bets accepted.')]"
        );
        public static Locator ConfirmNow = new Locator(
                "Confirm now?",
                "Label",
                "Dealer Table Page",
                "//p[@class='popUp_title']"
        );
        public static Locator BettingIsClosing = new Locator(
                "Betting is closing.",
                "Label",
                "Dealer Table Page",
                "//div[@class='popUp']//p[contains(normalize-space(), 'Betting is closing.')]"
        );
        public static Locator WonAmount = new Locator(
                "Won Amount",
                "Label",
                "Dealer Table Page",
                "//p[@class='you_won_amount_text']"
        );
        public static Locator YouWon = new Locator(
                "You Won",
                "Label",
                "Dealer Table Page",
                "//div[@class='you_won_title ribbon']"
        );
        public static Locator GiveItATry = new Locator(
                "You haven't bet for a long time. Give it a try?",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Give it a try?')]"
        );
        public static Locator ExceededTheMaxBet = new Locator(
                "You've exceeded the max bet amount.",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'exceeded the max bet amount.')]"
        );
        public static Locator YourBetsAreBeingSettled = new Locator(
                "Your bets are being settled right now. Please wait.",
                "Label",
                "Dealer Table Page",
                "//p[contains(text(),'Your bets are being settled right now. Please wait.')]"
        );
        public static Locator RememberedYourChipSettings = new Locator(
                "We've remembered your chip settings.",
                "Label",
                "Dealer Table Page",
                "//p[contains(text(),'remembered your chip settings.')]"
        );
        public static Locator NumbersInResultPanel = new Locator(
                "List of Numbers In Result Panel",
                "Label",
                "Dealer Table Page",
                "(//div[contains(@class, 'roulette_line_roadmap')]//p)[position() <= 12]"
        );
    }

}
