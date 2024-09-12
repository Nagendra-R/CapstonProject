Feature: web only

  @web
  Scenario: switching in between AJio and AJioLux
    Given user open the website
    Then verify user on home page
    When user click on the visit ajioluxe tab
    Then verify user on ajioluxe page