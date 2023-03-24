package com.bookstore.framework.pages.panels;

import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class TopPanel extends BasePage {

    private final By userNameLabel = By.id("userName-value");
    private final By logoutBtn = By.xpath("//button[contains(text(),'Log out')]");
    private final By searchField = By.id("searchBox");

    public boolean isUserNameDisplayed() {
        return isElementDisplayed(userNameLabel, "Check if userName label is displayed");
    }

    public boolean isCorrectUserLoggedIn(String userName) {
        By loggedInUser = By.xpath("//*[contains(text(),'" + userName + "')]");
        return isElementDisplayed(loggedInUser, "Check that " + userName + " is logged in");
    }

    public boolean isBookDisplayed(String bookForSearch) {
        By searchBook = By.linkText(bookForSearch);
        return isElementDisplayed(searchBook, "Check if " + bookForSearch + "is present in book list");
    }


    public void logout() {
        click(logoutBtn, "Log out from app");
    }

    public void searchForBook(String bookForSearch) {
        enterText(searchField, bookForSearch, "Search for book: " + bookForSearch);
    }
}
