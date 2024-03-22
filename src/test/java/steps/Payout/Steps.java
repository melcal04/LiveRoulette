package steps.Payout;

import io.cucumber.java.en.Then;
import modules.Payout.Payout;

public class Steps {

    @Then("I Verify The Payout Calculation Of {string} Betting Option")
    public void iVerifyThePayoutCalculationOfBettingOption(String betOption) {
        switch (betOption) {
            case "Red" -> Payout.verify(1);
            case "Black" -> Payout.verify(2);
            case "Even" -> Payout.verify(3);
            case "Odd" -> Payout.verify(4);
            case "Low" -> Payout.verify(5);
            case "High" -> Payout.verify(6);
            case "1st Dozen" -> Payout.verify(7);
            case "2nd Dozen" -> Payout.verify(8);
            case "3rd Dozen" -> Payout.verify(9);
            case "1st Column" -> Payout.verify(10);
            case "2nd Column" -> Payout.verify(11);
            case "3rd Column" -> Payout.verify(12);
            case "Straight Up" -> Payout.verify(13);
            case "Split" -> Payout.verify(14);
            case "Street" -> Payout.verify(15);
            case "Corner" -> Payout.verify(16);
            case "Six Line" -> Payout.verify(17);
            case "Zero Section" -> Payout.verify(18);
            case "Zero Corner" -> Payout.verify(19);
        }
    }

}
