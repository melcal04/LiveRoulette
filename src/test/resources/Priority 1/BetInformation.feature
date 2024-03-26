@BetInformation @Maintenance
Feature: Bet Information

  Background:
    Given I Login To The Website And Go To The Live Casino
    And I Join Live Roulette Mobile Revamp
    And I Enter The Dealer Table

  @BetInformationTest1
  Scenario: BI Test 1: Checking The Bet Information With Win Result
    When I Place Bet On Any Betting Option Until "Win"
    And I Go To Bet Details
    Then I Verify The Bet Information With "Win Result"

  @BetInformationTest2
  Scenario: BI Test 2: Checking Bet Information With Lose Result
    When I Place Bet On Any Betting Option Until "Lose"
    And I Go To Bet Details
    Then I Verify The Bet Information With "Lose Result"

  @BetInformationTest3
  Scenario: BI Test 3: Checking Bet Information With Multiple Bets
    When I Place Bet On Any Betting Option Until "Round Complete"
    And I Go To Bet Details
    Then I Verify The Bet Information With "Multiple Bets"