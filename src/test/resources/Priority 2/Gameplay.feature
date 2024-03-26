@Gameplay @Maintenance
Feature: Gameplay

  Background:
    Given I Login To The Website And Go To The Live Casino
    And I Join Live Roulette Mobile Revamp

  @GameplayTest2
  Scenario: GP Test 2: Checking The Behavior Of Sliding Bar In Lobby
    When Do "Move The Sliding Bar"
    Then Verify "The Behavior Of Sliding Bar In Lobby"

  @GameplayTest3
  Scenario: GP Test 3: Checking The Behavior Of The Game After Joining Table
    When I Enter The Dealer Table
    Then Verify "The Behavior Of The Game After Joining Table"

  @GameplayTest4
  Scenario: GP Test 4: Checking The Behavior Of The Game After Joining Table With Betting Phase Open
    When I Enter The Dealer Table
    Then Verify "The Behavior Of The Game After Joining Table With Betting Phase Open"

  @GameplayTest5
  Scenario: GP Test 5: Checking The Behavior Of The Game After Joining Table With Betting Phase Close
    When I Enter The Dealer Table
    Then Verify "The Behavior Of The Game After Joining Table With Betting Phase Close"

  @GameplayTest6
  Scenario: GP Test 6: Checking The Behavior Of Chips After Clicking On Each Chip
    When I Enter The Dealer Table
    And Wait "Until Betting Phase Open"
    And Click "On Each Chip"
    Then Verify "The Behavior Of Chips After Clicking On Each Chip"

  @GameplayTest7
  Scenario: GP Test 7: Checking The Behavior Of The Game After New Round Starts
    When I Enter The Dealer Table
    And Wait "Until Betting Phase Open"
    Then Verify "The Behavior Of The Game After New Round Starts"

  @GameplayTest8
  Scenario: GP Test 8: Checking The Behavior Of The Game After Placing A Bet On Each Betting Options
    When I Enter The Dealer Table
    And Place "A Bet On Each Betting Option"
    Then Verify "The Behavior Of The Game After Placing A Bet On Each Betting Options"

  @GameplayTest9
  Scenario: GP Test 9: Checking The Behavior Of The Game After Placing A Bet On Any Betting Options
    When I Enter The Dealer Table
    And Place "A Bet On Any Betting Options"
    Then Verify "The Behavior Of The Game After Placing A Bet On Any Betting Options"

  @GameplayTest10
  Scenario: GP Test 10: Checking The Behavior Of Action Buttons After Placing A Bet
    When I Enter The Dealer Table
    And Place "A Bet On Any Betting Options"
    Then Verify "The Behavior Of Action Buttons After Placing A Bet"

  @GameplayTest11
  Scenario: GP Test 11: Checking The Behavior Of The Game After Confirming A Bet While There Is A Confirmed Bet
    When I Enter The Dealer Table
    And Place "And Confirm Any Betting Options"
    And Place "And Confirm The Betting Options Again"
    Then Verify "The Behavior Of The Game After Confirming A Bet While There Is A Confirmed Bet"

  @GameplayTest13
  Scenario: GP Test 13: Checking The Behavior Of The Game After Placing A Bet Without Confirming
    When I Enter The Dealer Table
    And Place "A Bet On Any Betting Options"
    Then Verify "The Behavior Of The Game After Placing A Bet Without Confirming"

  @GameplayTest14
  Scenario: GP Test 14: Checking The Behavior Of The Game After Placing A Bet Without Confirming For 10 Seconds
    When I Enter The Dealer Table
    And Place "A Bet On Any Betting Options"
    And Wait "Until Timer Less Than 10 Seconds"
    Then Verify "The Behavior Of The Game After Placing A Bet Without Confirming For 10 Seconds"

  @GameplayTest15
  Scenario: GP Test 15: Checking The Behavior Of The Game After Round Result Displayed
    When I Enter The Dealer Table
    And Wait "Until Betting Phase Close"
    Then Verify "The Behavior Of The Game After Round Result Displayed"

  @GameplayTest16
  Scenario: GP Test 16: Checking The Behavior Of The Game After Player Wins A Round
    When I Enter The Dealer Table
    And Place "And Confirm Any Betting Options"
    And Wait "Until Bet Wins"
    Then Verify "The Behavior Of The Game After Player Wins A Round"

  @GameplayTest17
  Scenario: GP Test 17: Checking The Behavior Of The Game After Player Loses A Round
    When I Enter The Dealer Table
    And Place "And Confirm Any Betting Options"
    And Wait "Until Bet Loses"
    Then Verify "The Behavior Of The Game After Player Loses A Round"

  @GameplayTest19
  Scenario: GP Test 19: Checking The Behavior Of The Game After Not Betting For 8 Rounds
    When I Enter The Dealer Table
    And Place "And Confirm Any Betting Options"
    And Do "Not Bet For 8 Consecutive Rounds"
    Then Verify "The Behavior Of The Game After Not Betting For 8 Rounds"
    When Do "Not Bet For 9 Consecutive Rounds"
    Then Verify "The Behavior Of The Game After Not Betting For 9 Rounds"

  @GameplayTest21
  Scenario: GP Test 21: Checking The Behavior Of The Game After Placing A Bet That Exceed Maximum Limit
    When I Enter The Dealer Table
    And Place "A Bet That Exceeds Maximum Limit"
    Then Verify "The Behavior Of The Game After Placing A Bet That Exceed Maximum Limit"

  @GameplayTest22
  Scenario: GP Test 22: Checking The Behavior Of Double Button After Placing A Minimum Bet On Any Betting Options
    When I Enter The Dealer Table
    And Place "A Minimum Bet On Any Betting Options"
    Then Verify "The Behavior Of Double Button After Placing A Minimum Bet On Any Betting Options"

  @GameplayTest23
  Scenario: GP Test 23: Checking The Behavior Of Double Button After Placing A Maximum Bet On Any Betting Options
    When I Enter The Dealer Table
    And Place "A Maximum Bet On Any Betting Options"
    Then Verify "The Behavior Of Double Button After Placing A Maximum Bet On Any Betting Options"

  @GameplayTest25
  Scenario: GP Test 25: Checking The Behavior Of The Game After Clicking The Back Button While There Is A Confirmed Bet
    When I Enter The Dealer Table
    And Place "And Confirm Any Betting Options"
    And Click "The Back Button"
    Then Verify "The Behavior Of The Game After Clicking The Back Button While There Is A Confirmed Bet"

  @GameplayTest28
  Scenario: GP Test 28: Checking The Behavior Of Betting Timer After Reaching 10 Seconds Below
    When I Enter The Dealer Table
    And Wait "Until Timer Less Than 10 Seconds"
    Then Verify "The Behavior Of Betting Timer After Reaching 10 Seconds Below"