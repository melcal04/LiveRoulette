@Payout @Maintenance
Feature: Payout

  @RoundSteps
  Scenario: Fetch Result: Wait Until There Is A Round Result For Payout
    Given I Login To The Website And Go To The Live Casino
    When I Join Live Roulette Mobile Revamp
    And I Enter The Dealer Table
    Then I Place A Bet Until There Is A Round Result For All Payouts
    # ** Payout Round Results
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
    # ** Result And Statistics Displayed Results
      | Result Panel          |
      | Red Result            |
      | Black Result          |
      | Zero Result           |
      | Red Percentage        |
      | Zero Percentage       |
      | Black Percentage      |
      | Odd Percentage        |
      | Even Percentage       |
      | High Percentage       |
      | Low Percentage        |
      | 1st Dozen Percentage  |
      | 2nd Dozen Percentage  |
      | 3rd Dozen Percentage  |
      | 1st Column Percentage |
      | 2nd Column Percentage |
      | 3rd Column Percentage |
      | Hot Numbers Win       |
      | Cold Numbers Lose     |
      | Cold Numbers Win      |

  @PayoutTest1
  Scenario: PO Test 1: Checking The Payout Calculation Of Red Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Red" Betting Option

  @PayoutTest2
  Scenario: PO Test 2: Checking The Payout Calculation Of Black Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Black" Betting Option

  @PayoutTest3
  Scenario: PO Test 3: Checking The Payout Calculation Of Even Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Even" Betting Option

  @PayoutTest4
  Scenario: PO Test 4: Checking The Payout Calculation Of Odd Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Odd" Betting Option

  @PayoutTest5
  Scenario: PO Test 5: Checking The Payout Calculation Of Low Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Low" Betting Option

  @PayoutTest6
  Scenario: PO Test 6: Checking The Payout Calculation Of High Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "High" Betting Option

  @PayoutTest7
  Scenario: PO Test 7: Checking The Payout Calculation Of First Dozen Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "1st Dozen" Betting Option

  @PayoutTest8
  Scenario: PO Test 8: Checking The Payout Calculation Of Second Dozen Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "2nd Dozen" Betting Option

  @PayoutTest9
  Scenario: PO Test 9: Checking The Payout Calculation Of Third Dozen Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "3rd Dozen" Betting Option

  @PayoutTest10
  Scenario: PO Test 10: Checking The Payout Calculation Of First Column Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "1st Column" Betting Option

  @PayoutTest11
  Scenario: PO Test 11: Checking The Payout Calculation Of Second Column Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "2nd Column" Betting Option

  @PayoutTest12
  Scenario: PO Test 12: Checking The Payout Calculation Of Third Column Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "3rd Column" Betting Option

  @PayoutTest13
  Scenario: PO Test 13: Checking The Payout Calculation Of Straight Up Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Straight Up" Betting Option

  @PayoutTest14
  Scenario: PO Test 14: Checking The Payout Calculation Of Split Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Split" Betting Option

  @PayoutTest15
  Scenario: PO Test 15: Checking The Payout Calculation Of Street Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Street" Betting Option

  @PayoutTest16
  Scenario: PO Test 16: Checking The Payout Calculation Of Corner Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Corner" Betting Option

  @PayoutTest17
  Scenario: PO Test 17: Checking The Payout Calculation Of Six Line Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Six Line" Betting Option

  @PayoutTest18
  Scenario: PO Test 18: Checking The Payout Calculation Of Zero Section Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Zero Section" Betting Option

  @PayoutTest19
  Scenario: PO Test 19: Checking The Payout Calculation Of Zero Corner Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Zero Corner" Betting Option
