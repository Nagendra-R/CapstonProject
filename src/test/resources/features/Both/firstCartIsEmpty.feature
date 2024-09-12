Feature: validate at first cart is empty in both web and mobile

  @web1 @mobile
Scenario: validate at first cart is empty
  Given user open the website
  Then verify user on home page
  When user click on the cart button
  Then verify cart is empty



















