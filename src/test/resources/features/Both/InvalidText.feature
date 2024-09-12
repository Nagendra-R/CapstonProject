Feature: validate at first cart is empty in both web and mobile
  @web @mobile
  Scenario: Search with meaningless word and show the error message
    Given user open the website
    Then verify user on home page
    When search with "ycyeuh" in search bar
    And click on the search symbol
    Then verify the items are shown