package steps.UserInterface;

import io.cucumber.java.en.Then;
import modules.UserInterface.*;

public class Steps {

    @Then("I Verify The Thumbnail Of Live Roulette Mobile Revamp")
    public void iVerifyTheThumbnailOfLiveRouletteMobileRevamp() {
        UITest1.verify();
    }

    @Then("I Verify The Launching Of Live Roulette Mobile Revamp")
    public void iVerifyTheLaunchingOfLiveRouletteMobileRevamp() {
        UITest2.verify();
    }

    @Then("I Verify The Game Lobby Of Live Roulette Mobile Revamp")
    public void iVerifyTheGameLobbyOfLiveRouletteMobileRevamp() { UITest3.verify(); }

    @Then("I Verify The UI Of Live Roulette Mobile Revamp During Betting Phase")
    public void iVerifyTheUIOfLiveRouletteMobileRevampDuringBettingPhase() {
        UITest4.verify();
    }

    @Then("I Verify The UI Of Live Roulette Mobile Revamp During Dealing Phase")
    public void iVerifyTheUIOfLiveRouletteMobileRevampDuringDealingPhase() {
        UITest5.verify();
    }

    @Then("I Verify The Betting Options Mapping Of Live Roulette Mobile Revamp")
    public void iVerifyTheBettingOptionsMappingOfLiveRouletteMobileRevamp() { UITest6.verify(); }

}
