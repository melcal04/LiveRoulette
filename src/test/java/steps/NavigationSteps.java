package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.DealerTable;
import pages.GameLobby;
import pages.LiveCasino;
import pages.Login;
import settings.AccountManager;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.interfaces.Navigator;
import utilities.objects.Printer;

public class NavigationSteps {

    @Given("I Login To The Website And Go To The Live Casino")
    public void ILoginToTheWebsiteAndGoToTheLiveCasino() {
        Navigator navigator = () -> {
            NavigationHandler.goToWebsite();
            EventHandler.select(Login.Dropdown.Language, "English");
            WaitHandler.waitUrlToBe(AccountManager.getURL(), 5);
            WaitHandler.wait(5);

            EventHandler.click(Login.Thumbnail.LiveCasino);
            WaitHandler.waitVisibility(Login.Container.LoginModal, 5);
            EventHandler.sendKeys(Login.TextBox.Username, AccountManager.getUsername());
            EventHandler.sendKeys(Login.TextBox.Password, AccountManager.getPassword());
            EventHandler.click(Login.Button.Submit, 5);

            if (ConditionHandler.isUrlContains("/roulette", 5)) {
                EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
                EventHandler.click(DealerTable.Button.Back, HandleCollection.WithException);
                WaitHandler.waitUrlContains("/dealerPage", 5);
                EventHandler.click(GameLobby.Button.Back, HandleCollection.WithException);
            }

            WaitHandler.waitUrlContains("/CasinoMobile", 5);
        };
        retrySteps(navigator, "Go To The Live Casino.");
    }

    @When("I Join Live Roulette Mobile Revamp")
    public void iJoinLiveRouletteMobileRevamp() {
        Navigator navigator = () -> {
            if (ConditionHandler.isDisplayed(GameLobby.Container.DealerTables, 5))
                EventHandler.click(GameLobby.Button.Back, HandleCollection.WithException);
            EventHandler.click(LiveCasino.Button.CloseBanner, HandleCollection.WithException);
            EventHandler.click(LiveCasino.Thumbnail.LiveRouletteRevamp, 5);
            WaitHandler.waitVisibility(GameLobby.Container.DealerTables, 5);
        };
        retrySteps(navigator, "Go To Live Roulette Revamp.");
    }

    @When("I Enter The Dealer Table")
    public void iEnterTheDealerTable() {
        Navigator navigator = () -> {
            EventHandler.click(GetHandler.getElementByRandom(GameLobby.Method.getDealerTables()));
            EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
        };
        retrySteps(navigator, "Enter The Dealer Table.");
    }

    @When("I Check The Round Result")
    public void iCheckTheRoundResult() {
        NavigationHandler.goToWebsite();
    }

    private void retrySteps(Navigator navigator, String description) {
        byte count = 0;
        boolean isError = true;
        do {
            try {
                if (count > 0) NavigationHandler.refresh();
                navigator.execute();
                isError = false;
            } catch (Exception e) {
                Printer.printWarning((++count) + " Failed Attempt To " + description);
                if (count == 5) throw e;
            }
        } while (isError);
    }

}