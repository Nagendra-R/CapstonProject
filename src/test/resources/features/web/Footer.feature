Feature: web only

  @web
  Scenario: validate footer is working
    Given user open the website
    Then verify user on home page
    When go to footer and click on the men
    Then validate user on mens page