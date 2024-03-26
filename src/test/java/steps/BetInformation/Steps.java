package steps.BetInformation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.BetInformation.BetInfoTest1;
import modules.BetInformation.BetInfoTest2;
import modules.BetInformation.BetInfoTest3;
import modules.BetInformation.BetInformation;
import pages.BetDetails;
import pages.DealerTable;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;

public class Steps {

    @When("I Place Bet On Any Betting Option Until {string}")
    public void iPlaceBetOnAnyBettingOptionUntil(String roundResult) {
        switch (roundResult) {
            case "Win" -> BetInfoTest1.placeBetUntilWin();
            case "Lose" -> BetInfoTest2.placeBetUntilLose();
            case "Round Complete" -> BetInfoTest3.placeBet();
        }
    }

    @And("I Go To Bet Details")
    public void iGoToBetDetails() {
        BetInformation.goToBetDetails();
    }

    @Then("I Verify The Bet Information With {string}")
    public void iVerifyTheBetInformationWith(String step) {
        switch (step) {
            case "Win Result" -> BetInfoTest1.verify();
            case "Lose Result" -> BetInfoTest2.verify();
            case "Multiple Bets" -> BetInfoTest3.verify();
        }

        EventHandler.click(BetDetails.Button.Back);
        EventHandler.click(MyBets.Button.Back, HandleCollection.WithScroll);
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
