Feature: Ecommerce functionality verification
  Scenario: verify the goto the top button is working
    Given user opens the website
    And user navigates to the bottom of the page
    When user clicks on the goto top arrow button
    Then user must reach the top of the page

  Scenario: verify customer care message is displayed properly
    Given user opens the website
    Then user clicks on customer care option
    When user select topic "Topic" and issue
    Then verify message is displayed in the get assistance section

  Scenario: verify total number of products equals the number along category
    Given user opens the website
    Then hover over men section and click on a type "cloth.type"
    When product list page is displayed select a category
    Then verify the number along the category is same as total products

  Scenario: verify selected rating is applied to the products
    Given user opens the website
    And clicks on the home and kitchen menu from the header
    When user is on home and kitchen page, click on a rating "rating.option"
    Then verify the products have the selected rating only

  Scenario: verify the grid button is working properly
    Given user opens the website
    And user clicks on the beauty menu from the homepage
    When user is on the beauty page and clicks grid button
    Then verify number of products displayed in a single row changed








