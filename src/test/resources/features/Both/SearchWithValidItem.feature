Feature: validate at first cart is empty in both web and mobile
  @web @mobile
  Scenario: validate the working of all items with searched item
    Given user open the website
    Then verify user on home page
    When search with "Shirt" in search bar
    And click on the search symbol
    Then verify each item with "Shirt" in title of the item