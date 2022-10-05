@Leaders
Feature: Check  Leader Module functionality

  @LeaderLinks
  Scenario: verify links are working or not 
    Given user is navigated to home page
    When mouse over to Leader Menu
    When click the subLinks
    Then user can see the page 
