Feature: validate at first cart is empty in both web and mobile

  @web @mobile
  Scenario: validate the price between 600 to 1200
    Given user open the website
    Then verify user on home page
    When search with "Shirt" in search bar
    And click on the search symbol
    Then verify user on searched item page
    And user click on the filters
    And user click on the price text
    When fill the min "600" and max "1200" amount
    Then validate the price is between "600" and "1200"