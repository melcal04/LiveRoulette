package steps.Gameplay;

import globals.TestMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.Gameplay.*;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.objects.Printer;

public class Steps {

    @When("Do {string}")
    public void iDo(String step) {
        switch (step) {
            case "Move The Sliding Bar" -> Printer.printInfo("Test Case 2 - Do Step Is Included In Verify Step");
            case "Not Bet For 8 Consecutive Rounds" -> Printer.printInfo("Test Case 19 - Do Step Is Included In Verify Step");
            case "Not Bet For 9 Consecutive Rounds" -> Printer.printInfo("Test Case 20 - Do Step Is Included In Verify Step");
        }
    }

    @When("Click {string}")
    public void iClick(String step) {
        switch (step) {
            case "On Each Chip" -> Printer.printInfo("Test Case 6 - Click Step Is Included In Verify Step");
            case "The Back Button" -> EventHandler.click(DealerTable.Button.Back);
        }
    }

    @When("Wait {string}")
    public void iWait(String step) {
        switch (step) {
            case "Until Betting Phase Open" -> Gameplay.waitUntilBettingPhaseOpen();
            case "Until Betting Phase Close" -> Gameplay.waitUntilBettingPhaseClose();
            case "Until Bet Wins" -> Printer.printInfo("Test Case 16 - Wait Step Is Included In Verify Step");
            case "Until Bet Loses" -> Printer.printInfo("Test Case 17 - Wait Step Is Included In Verify Step");
            case "Until Timer Less Than 10 Seconds" -> TestMethods.waitBettingPhase(10, true);
        }
    }

    @When("Place {string}")
    public void iPlace(String step) {
        switch (step) {
            case "A Bet On Each Betting Option" -> Printer.printInfo("Test Case 8 - Place Step Is Included In Verify Step");
            case "A Bet On Any Betting Options" -> Gameplay.placeABetOnAnyBettingOptions();
            case "And Confirm Any Betting Options" -> Gameplay.placeAndConfirmAnyBettingOptions();
            case "And Confirm The Betting Options Again" -> Printer.printInfo("Test Case 11 - Place Step Is Included In Verify Step");
            case "A Bet That Exceeds Maximum Limit" -> Printer.printInfo("Test Case 21 - Place Step Is Included In Verify Step");
            case "A Maximum Bet On Any Betting Options" -> Gameplay.placeAMaximumBetOnAnyBettingOptions();
            case "A Minimum Bet On Any Betting Options" -> Gameplay.placeAMinimumBetOnAnyBettingOptions();
        }
    }

    @Then("Verify {string}")
    public void iVerify(String step) {
        switch (step) {
            case "The Behavior Of Sliding Bar In Lobby" -> GameTest2.verify();
            case "The Behavior Of The Game After Joining Table" -> GameTest3.verify();
            case "The Behavior Of The Game After Joining Table With Betting Phase Open" -> GameTest4.verify();
            case "The Behavior Of The Game After Joining Table With Betting Phase Close" -> GameTest5.verify();
            case "The Behavior Of Chips After Clicking On Each Chip" -> GameTest6.verify();
            case "The Behavior Of The Game After New Round Starts" -> GameTest7.verify();
            case "The Behavior Of The Game After Placing A Bet On Each Betting Options" -> GameTest8.verify();
            case "The Behavior Of The Game After Placing A Bet On Any Betting Options" -> GameTest9.verify();
            case "The Behavior Of Action Buttons After Placing A Bet" -> GameTest10.verify();
            case "The Behavior Of The Game After Confirming A Bet While There Is A Confirmed Bet" -> GameTest11.verify();
            case "The Behavior Of The Game After Placing A Bet Without Confirming" -> GameTest13.verify();
            case "The Behavior Of The Game After Placing A Bet Without Confirming For 10 Seconds" -> GameTest14.verify();
            case "The Behavior Of The Game After Round Result Displayed" -> GameTest15.verify();
            case "The Behavior Of The Game After Player Wins A Round" -> GameTest16.verify();
            case "The Behavior Of The Game After Player Loses A Round" -> GameTest17.verify();
            case "The Behavior Of The Game After Not Betting For 8 Rounds" -> GameTest19.verify();
            case "The Behavior Of The Game After Not Betting For 9 Rounds" -> GameTest20.verify();
            case "The Behavior Of The Game After Placing A Bet That Exceed Maximum Limit" -> GameTest21.verify();
            case "The Behavior Of Double Button After Placing A Minimum Bet On Any Betting Options" -> GameTest22.verify();
            case "The Behavior Of Double Button After Placing A Maximum Bet On Any Betting Options" -> GameTest23.verify();
            case "The Behavior Of The Game After Clicking The Back Button While There Is A Confirmed Bet" -> GameTest25.verify();
            case "The Behavior Of Betting Timer After Reaching 10 Seconds Below" -> GameTest28.verify();
        }
    }

}