Feature: Common scenarios of web and mobile
  @web @mobile
  Scenario:validate add to bag
    Given user open the website
    Then verify user on home page
    When search with "Shirt" in search bar
    And click on the search symbol
    Then verify user on searched item page
    When click on first item
    Then verify user on single product page
    When click on the wishlist and similar button to remove popup
    And click on the add to bag button firstTime
    And select the size "L"
    When click on the add to bag button
    Then user click on the cart button in single product page
    Then verify user on cart page
    Then verify the item is added