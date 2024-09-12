Feature: web only

  @web
  Scenario: validate mouse hover is working on homepage
    Given user open the website
    Then verify user on home page
    When move the cursor to the men web element
    Then verify mouse hover is working or not