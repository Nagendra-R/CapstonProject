package com.automation.pages.interfaces;

public interface HomePage {



    void openWebsite();

    boolean verifyUserOnHomepage();

    void clickOnCartButton();

    void searchWithItem(String item);

    void clickOnTheSearchSymbol();

    default void clickOnSignInButton() {
    }

    default void clickOnAJioluxe() {
    }

    default boolean verifyUserOnAjioLuxePage() {
        return false;
    }


    default void clickOnFooterItem(){

    }

    default String verifyUserOnMensPage(){
        return "";
    }

    default void moveCursorToMenWebElement(){

    }

    default boolean validateTheMouseHoverIsWorking(){
        return false;
    }

    default void clickOnAccount(){
    }
}
