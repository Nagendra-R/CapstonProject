Feature: both

  @web @mobile
  Scenario: Validate the discount for each item
    Given user open the website
    Then verify user on home page
    When search with "Shirt" in search bar
    And click on the search symbol
    Then verify user on searched item page
    Then verify with correct discount


