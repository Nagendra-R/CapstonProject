Feature: validate phone number functionality

  @web
  Scenario: check phone number validation
    Given user open the website
    Then verify user on home page
    When user click on the sign in button
    Then verify user on login page
    And enter the mobile number "123456"
    And click on continue button
    Then verify the error message is shown below
      |Your mobile number should be of 10 digits. Please also ensure it does not start with 0 or +91.|