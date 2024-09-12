Feature: mobile only
  @mobile
  Scenario: validate user can login and logout successfully
    Given user open the website
    Then verify user on home page
    When click on the account
    Then verify user on login screen
    When click on the sign in or login button
    When user fill the "9390635508" phone number
    And user click on the continue button
    Then verify user on otp screen
    When fill the otp manually
    Then verify user can successfully login
    When user scroll till the logout button
    And user click on the logout button
    Then verify user can successfully logout