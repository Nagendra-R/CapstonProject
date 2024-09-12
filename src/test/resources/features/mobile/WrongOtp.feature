Feature: mobile only

  @mobile1
  Scenario: validate with the wrong otp
    Given user open the website
    Then verify user on home page
    When click on the account
    Then verify user on login screen
    When click on the sign in or login button
    When user fill the "9390635508" phone number
    And user click on the continue button
    Then verify user on otp screen
    When fill the otp with random numbers
    Then verify the entered otp is wrong