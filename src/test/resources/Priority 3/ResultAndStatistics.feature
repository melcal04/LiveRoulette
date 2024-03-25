@ResultAndStatistics
Feature: Result And Statistics

  @ResultAndStatisticsTest1
  Scenario: RS Test 1: Checking The Result Panel Displayed
    When I Check The Round Result
    Then I Verify The "Result Panel" Displayed

  @ResultAndStatisticsTest2
  Scenario: RS Test 2: Checking The Data Displayed On Result Panel When Red Wins
    When I Check The Round Result
    Then I Verify The "Red Result" Displayed

  @ResultAndStatisticsTest3
  Scenario: RS Test 3: Checking The Data Displayed On Result Panel When Black Wins
    When I Check The Round Result
    Then I Verify The "Black Result" Displayed

  @ResultAndStatisticsTest4
  Scenario: RS Test 4: Checking The Data Displayed On Result Panel When Zero Wins
    When I Check The Round Result
    Then I Verify The "Zero Result" Displayed

  @ResultAndStatisticsTest5_1
  Scenario: RS Test 1 Of 5: Checking The Red Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Red Percentage" Displayed

  @ResultAndStatisticsTest5_2
  Scenario: RS Test 2 Of 5: Checking The Zero Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Zero Percentage" Displayed

  @ResultAndStatisticsTest5_3
  Scenario: RS Test 3 Of 5: Checking The Black Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Black Percentage" Displayed

  @ResultAndStatisticsTest5_4
  Scenario: RS Test 4 Of 5: Checking The Odd Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Odd Percentage" Displayed

  @ResultAndStatisticsTest5_5
  Scenario: RS Test 5 Of 5: Checking The Even Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Even Percentage" Displayed

  @ResultAndStatisticsTest5_6
  Scenario: RS Test 6 Of 5: Checking The High Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "High Percentage" Displayed

  @ResultAndStatisticsTest5_7
  Scenario: RS Test 7 Of 5: Checking The Low Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Low Percentage" Displayed

  @ResultAndStatisticsTest5_8
  Scenario: RS Test 8 Of 5: Checking The 1st Dozen Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "1st Dozen Percentage" Displayed

  @ResultAndStatisticsTest5_9
  Scenario: RS Test 9 Of 5: Checking The 2nd Dozen Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "2nd Dozen Percentage" Displayed

  @ResultAndStatisticsTest5_10
  Scenario: RS Test 10 Of 5: Checking The 3rd Dozen Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "3rd Dozen Percentage" Displayed

  @ResultAndStatisticsTest5_11
  Scenario: RS Test 11 Of 5: Checking The 1st Column Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "1st Column Percentage" Displayed

  @ResultAndStatisticsTest5_12
  Scenario: RS Test 12 Of 5: Checking The 2nd Column Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "2nd Column Percentage" Displayed

  @ResultAndStatisticsTest5_13
  Scenario: RS Test 13 Of 5: Checking The 3rd Column Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "3rd Column Percentage" Displayed

  @ResultAndStatisticsTest5_14
  Scenario: RS Test 14 Of 5: Checking The Hot Numbers Displayed On Statistics If They Win
    When I Check The Round Result
    Then I Verify The "Hot Numbers Win" Displayed

  @ResultAndStatisticsTest5_15
  Scenario: RS Test 15 Of 5: Checking The Cold Numbers Displayed On Statistics If They Did Not Win
    When I Check The Round Result
    Then I Verify The "Cold Numbers Lose" Displayed

  @ResultAndStatisticsTest5_16
  Scenario: RS Test 16 Of 5: Checking The Cold Numbers Displayed On Statistics If They Win
    When I Check The Round Result
    Then I Verify The "Cold Numbers Win" Displayed
