@Payout @Maintenance
Feature: Payout

  Background:
    Given I Go To Mobile Site

  @PayoutTest1
  Scenario: PO Test 1: Checking The Mapping Of Live Roulette Betting Options
    When I Login An Account
    And I Go To Live Casino
    And I Join Live Roulette Revamp
    And I Enter The Dealer Table
    Then I Verify The Mapping Of Betting Options

  @PayoutWait
  Scenario: Wait Until There Is A Round Result For Payout
    When I Login An Account
    And I Go To Live Casino
    And I Join Live Roulette Revamp
    And I Enter The Dealer Table
    Then I Place A Bet Until There Is A Round Result For All Payouts
      | Red          |
      | Black        |
      | Even         |
      | Odd          |
      | Low          |
      | High         |
      | 1st Dozen    |
      | 2nd Dozen    |
      | 3rd Dozen    |
      | 1st Column   |
      | 2nd Column   |
      | 3rd Column   |
      | Straight Up  |
      | Split        |
      | Street       |
      | Corner       |
      | Six Line     |
      | Zero Section |
      | Zero Corner  |

  @PayoutTest2
  Scenario: PO Test 2: Checking The Payout Calculation Of Red Betting Option
    Then I Verify The Payout Calculation Of "Red" Betting Option

  @PayoutTest3
  Scenario: PO Test 3: Checking The Payout Calculation Of Black Betting Option
    Then I Verify The Payout Calculation Of "Black" Betting Option

  @PayoutTest4
  Scenario: PO Test 4: Checking The Payout Calculation Of Even Betting Option
    Then I Verify The Payout Calculation Of "Even" Betting Option

  @PayoutTest5
  Scenario: PO Test 5: Checking The Payout Calculation Of Odd Betting Option
    Then I Verify The Payout Calculation Of "Odd" Betting Option

  @PayoutTest6
  Scenario: PO Test 6: Checking The Payout Calculation Of Low Betting Option
    Then I Verify The Payout Calculation Of "Low" Betting Option

  @PayoutTest7
  Scenario: PO Test 7: Checking The Payout Calculation Of High Betting Option
    Then I Verify The Payout Calculation Of "High" Betting Option

  @PayoutTest8
  Scenario: PO Test 8: Checking The Payout Calculation Of First Dozen Betting Option
    Then I Verify The Payout Calculation Of "1st Dozen" Betting Option

  @PayoutTest9
  Scenario: PO Test 9: Checking The Payout Calculation Of Second Dozen Betting Option
    Then I Verify The Payout Calculation Of "2nd Dozen" Betting Option

  @PayoutTest10
  Scenario: PO Test 10: Checking The Payout Calculation Of Third Dozen Betting Option
    Then I Verify The Payout Calculation Of "3rd Dozen" Betting Option

  @PayoutTest11
  Scenario: PO Test 11: Checking The Payout Calculation Of First Column Betting Option
    Then I Verify The Payout Calculation Of "1st Column" Betting Option

  @PayoutTest12
  Scenario: PO Test 12: Checking The Payout Calculation Of Second Column Betting Option
    Then I Verify The Payout Calculation Of "2nd Column" Betting Option

  @PayoutTest13
  Scenario: PO Test 13: Checking The Payout Calculation Of Third Column Betting Option
    Then I Verify The Payout Calculation Of "3rd Column" Betting Option

  @PayoutTest14
  Scenario: PO Test 14: Checking The Payout Calculation Of Straight Up Betting Option
    Then I Verify The Payout Calculation Of "Straight Up" Betting Option

  @PayoutTest15
  Scenario: PO Test 15: Checking The Payout Calculation Of Split Betting Option
    Then I Verify The Payout Calculation Of "Split" Betting Option

  @PayoutTest16
  Scenario: PO Test 16: Checking The Payout Calculation Of Street Betting Option
    Then I Verify The Payout Calculation Of "Street" Betting Option

  @PayoutTest17
  Scenario: PO Test 17: Checking The Payout Calculation Of Corner Betting Option
    Then I Verify The Payout Calculation Of "Corner" Betting Option

  @PayoutTest18
  Scenario: PO Test 18: Checking The Payout Calculation Of Six Line Betting Option
    Then I Verify The Payout Calculation Of "Six Line" Betting Option

  @PayoutTest19
  Scenario: PO Test 19: Checking The Payout Calculation Of Zero Section Betting Option
    Then I Verify The Payout Calculation Of "Zero Section" Betting Option

  @PayoutTest20
  Scenario: PO Test 20: Checking The Payout Calculation Of Zero Corner Betting Option
    Then I Verify The Payout Calculation Of "Zero Corner" Betting Option