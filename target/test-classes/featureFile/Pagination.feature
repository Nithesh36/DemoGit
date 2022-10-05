@paginationModule
Feature: Check pagination functionality

  @PaginatonAndImage
  Scenario: Verify image modal is closed or not  inside a pagination module
    Given user is in HomePage
    When user handles the alert
    When user move to media menu
    And user move into subMenu
    When user select "2245" option  from the dropdown and is the type of "value"
    When Scrolldown the page
    And enter page Number "3"
    When click the controls
    Then close the modal
