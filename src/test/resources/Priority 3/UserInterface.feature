@UserInterface
Feature: User Interface

  Background:
    Given I Login To The Website And Go To The Live Casino

  @UserInterfaceTest1
  Scenario: UI Test 1: Checking The Thumbnail Of Live Roulette Mobile Revamp
    Then I Verify The Thumbnail Of Live Roulette Mobile Revamp

  @UserInterfaceTest2
  Scenario: UI Test 2: Checking The Launching Of Live Roulette Mobile Revamp
    When I Join Live Roulette Mobile Revamp
    Then I Verify The Launching Of Live Roulette Mobile Revamp

  @UserInterfaceTest3
  Scenario: UI Test 3: Checking The Game Lobby Of Live Roulette Mobile Revamp
    When I Join Live Roulette Mobile Revamp
    Then I Verify The Game Lobby Of Live Roulette Mobile Revamp

  @UserInterfaceTest4
  Scenario: UI Test 4: Checking The UI Of Live Roulette Mobile Revamp During Betting Phase
    When I Join Live Roulette Mobile Revamp
    And I Enter The Dealer Table
    Then I Verify The UI Of Live Roulette Mobile Revamp During Betting Phase

  @UserInterfaceTest5
  Scenario: UI Test 5: Checking The UI Of Live Roulette Mobile Revamp During Dealing Phase
    When I Join Live Roulette Mobile Revamp
    And I Enter The Dealer Table
    Then I Verify The UI Of Live Roulette Mobile Revamp During Dealing Phase

  @UserInterfaceTest6
  Scenario: UI Test 6: Checking The Betting Options Mapping Of Live Roulette Mobile Revamp
    When I Join Live Roulette Mobile Revamp
    And I Enter The Dealer Table
    Then I Verify The Betting Options Mapping Of Live Roulette Mobile Revamp