@MediaRealse
Feature: In mediaRelase  module check  media functionality

  @UnBrokenImage
  Scenario: Test the images in the page  is unBroken
    When click the alert and handle that alert
    When mouse over to the media menu
    When clcik the photoMenu
    When click the relaseYear
    And click the article
    Then scroll down see image Health

  @brokenImageTest
  Scenario: Test the image is broken or not
    When click the any other realseYear
    And click the any links for getting image
    Then scroll down see image is broken
