Feature: validate phone number functionality
Scenario: check phone number validation
  Given user open the application
  Then validate user on home page
  When user click on the signInButton
  And enter the mobile number "123456"
  And click on continue button
  Then verify the error message is shown below
    |Your mobile number should be of 10 digits. Please also ensure it does not start with 0 or +91.|




Scenario: switching in between AJio and AJioLux
  Given user open the application
  Then validate user on home page
  When user click on the visit ajioluxe tab
  Then verify user on ajioluxe page

#Scenario:  validate the select price less than 500
#  Given user open the application
#  Then validate user on home page
#  When user search with "shirts"
#  Then verify user on shirts item page
#  When user select the price less than "500"
#  Then verify the all shirts displayed are less than 500



Scenario: validate highest price
  Given user open the application
  Then validate user on home page
  When user search with "shirts"
  Then verify user on shirts item page
  When select price "Price (highest first)"
  Then verify the price in desc order










