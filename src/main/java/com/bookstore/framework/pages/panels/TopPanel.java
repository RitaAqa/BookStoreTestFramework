package com.bookstore.framework.pages.panels;

import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopPanel extends BasePage {

    private final By userNameLabel = By.id("userName-value");
    private final By logoutBtn = By.xpath("//button[contains(text(),'Log out')]");
    private final By searchField = By.id("searchBox");

     public boolean isUserNameDisplayed() {
        return isElementDisplayed(userNameLabel);
    }

    public boolean isCorrectUserLoggedIn(String userName) {
        By loggedInUser = By.xpath("//*[contains(text(),'" + userName + "')]");
        return isElementDisplayed(loggedInUser);
    }

    public boolean isBookDisplayed(String existingBookForSearch) {
        By searchBook = By.linkText(existingBookForSearch);
        return isElementDisplayed(searchBook);
    }


    public void logout() {
        click(logoutBtn);
    }

    public void searchForExistingItem(String existingBookForSearch) {
        enterText(searchField, existingBookForSearch);
    }


}
