@publicationModule
Feature: Check PublicationModule function

  @PublicationScenario
  Scenario: Test the Document is available or not

    When mouse over to PublicationMenu
    And move into BaatCheet Section
    When user select a value "3" from the dropdown is the type of "index"
    And user waits for someTime "20"
