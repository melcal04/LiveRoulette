package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.*;
import utilities.enums.Environment;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.interfaces.Navigator;
import utilities.interfaces.Printer;
import utilities.objects.Component;
import utilities.settings.Accounts;

public class Navigation {

    @Given("I Go To Mobile Site")
    public void iGoToMobileSite() {
        Navigator navigator = () -> {
            Accounts.setEnvironment(Environment.PRODUCTION);
            NavigationHandler.goTo(Accounts.getMobileUrl());
            EventHandler.select(Login.Dropdown.Language, "English");
            WaitHandler.waitUrlToBe(Accounts.getMobileUrl(), 5);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Go To The Website.");
    }

    @When("I Login An Account")
    public void iLoginAnAccount() {
        Navigator navigator = () -> {
            EventHandler.click(Login.Button.OpenLoginModal);
            EventHandler.sendKeys(Login.TextBox.Username, Accounts.getUsername());
            EventHandler.sendKeys(Login.TextBox.Password, Accounts.getPassword());
            EventHandler.click(Login.Button.Submit);
            WaitHandler.waitUrlToBe("https://play.sbobet.com/landing", 5);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Login An Account.");
    }

    @When("I Go To Live Casino")
    public void iGoToLiveCasino() {
        Navigator navigator = () -> {
            if (ConditionHandler.isDisplayed(Home.Thumbnail.LiveCasino)) {
                WaitHandler.wait(2);
                EventHandler.click(Home.Thumbnail.LiveCasino);
                WaitHandler.wait(5);
                WaitHandler.waitUrlContains("/CasinoMobile", 5);
            } else {
                EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
                EventHandler.click(DealerTable.Button.Back, HandleCollection.WithException);
                WaitHandler.waitUrlContains("/dealerPage", 5);
                EventHandler.click(GameLobby.Button.Back, HandleCollection.WithException);
                WaitHandler.waitUrlContains("/CasinoMobile", 5);
            }
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Go To Live Casino.");
    }

    @When("I Join Live Roulette Revamp")
    public void iJoinLiveRouletteRevamp() {
        Navigator navigator = () -> {
            if (ConditionHandler.isDisplayed(LiveCasino.Thumbnail.LiveRouletteRevamp)) {
                EventHandler.click(LiveCasino.Button.CloseBanner, HandleCollection.WithException);
                EventHandler.click(LiveCasino.Thumbnail.LiveRouletteRevamp);
                WaitHandler.wait(5);
            } else {
                EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
                EventHandler.click(DealerTable.Button.Back, HandleCollection.WithException);
            }
            WaitHandler.waitUrlContains("/dealerPage", 5);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Go To Live Roulette Revamp.");
    }

    @When("I Enter The Dealer Table")
    public void iEnterTheDealerTable() {
        Navigator navigator = () -> {
            Component dealerTables = GameLobby.Container.DealerTables;
            EventHandler.click(dealerTables, GetHandler.getElementByRandom(dealerTables));
            EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Enter The Dealer Table.");
    }

    private void retrySteps(Navigator navigator, Printer printer, String description) {
        byte count = 0;
        boolean isError = true;
        do {
            try {
                if (count > 0) NavigationHandler.refresh();
                navigator.execute();
                isError = false;
            } catch (Exception e) {
                printer.print((++count) + " Attempt To " + description);
                if (count == 5) throw e;
            }
        } while (isError);
    }

}