package steps.ResultAndStatistics;

import io.cucumber.java.en.Then;
import modules.ResultAndStatistics.*;

public class Steps {

    @Then("I Verify The {string} Displayed")
    public void iVerifyTheDisplayed(String display) {
        switch (display) {
            case "Result Panel" -> ResAndStatsTest1.verify();
            case "Red Result" -> ResAndStatsTest2.verify();
            case "Black Result" -> ResAndStatsTest3.verify();
            case "Zero Result" -> ResAndStatsTest4.verify();
            case "Red Percentage" -> ResAndStatsTest5_1.verify();
            case "Zero Percentage" -> ResAndStatsTest5_2.verify();
            case "Black Percentage" -> ResAndStatsTest5_3.verify();
            case "Odd Percentage" -> ResAndStatsTest5_4.verify();
            case "Even Percentage" -> ResAndStatsTest5_5.verify();
            case "High Percentage" -> ResAndStatsTest5_6.verify();
            case "Low Percentage" -> ResAndStatsTest5_7.verify();
            case "1st Dozen Percentage" -> ResAndStatsTest5_8.verify();
            case "2nd Dozen Percentage" -> ResAndStatsTest5_9.verify();
            case "3rd Dozen Percentage" -> ResAndStatsTest5_10.verify();
            case "1st Column Percentage" -> ResAndStatsTest5_11.verify();
            case "2nd Column Percentage" -> ResAndStatsTest5_12.verify();
            case "3rd Column Percentage" -> ResAndStatsTest5_13.verify();
            case "Hot Numbers Win" -> ResAndStatsTest5_14.verify();
            case "Cold Numbers Lose" -> ResAndStatsTest5_15.verify();
            case "Cold Numbers Win" -> ResAndStatsTest5_16.verify();
        }
    }

}
