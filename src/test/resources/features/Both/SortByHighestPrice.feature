Feature: Common scenarios of web and mobile
  @web @mobile
  Scenario: validate the price in desc order
    Given user open the website
    Then verify user on home page
    When search with "Shirt" in search bar
    And click on the search symbol
    Then verify user on searched item page
    When sort price by "Price (highest first)"
    Then verify the price in desc order

