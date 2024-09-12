package com.automation.pages.interfaces;

public interface LoginPage {

    default void enterMobileNumber(String mobileNumber) {
    }

    default boolean verifyUserOnLoginPage() {
        return false;
    }

    default void clickOnContinueButton() {
    }

    default boolean verifyErrorMessage(String errMessage) {
        return false;
    }


    default boolean verifyUserOnLoginScreen(){
        return false;
    }

    default void clickOnTheSignInOrLoginIn(){
    }

     default void fillThePhoneNumber(String phoneNumber){
     }

    default void clickOnLoginContinueButton(){
    }

    default boolean verifyUserOnOtpScreen(){
        return false;
    }

    default void fillTheRandomOtp(){
    }

    default String getTheWrongMessage(){
        return "";
    }

    default void fillTheOtpManually(){

    }

   default boolean verifyUserSuccessfullyLogin(){
        return false;
   }


    default void scrollTillTheLogoutButton(){

    }

    default void clickOnLogoutButton(){
    }

    default boolean verifyUserOnSignUpLoginScreen(){
        return false;
    }
}
