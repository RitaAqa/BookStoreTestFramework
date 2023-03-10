package com.bookstore.tests.smoke;

import com.bookstore.framework.base.BaseTest;
import com.bookstore.framework.utils.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class SmokeTest extends BaseTest {

    @Parameters({"userName", "password"})
    @Test(description = "Verify login with existing account")
    public void loginWithExistingAccount(String userName, String password) throws InterruptedException {
        bookStore.startApp();
        bookStore.getLeftPanel().navigateToLoginPage();
        bookStore.getLoginPage().login(userName, password);
        Assert.assertTrue(bookStore.getTopPanel().isUserNameDisplayed(), "User Name is not displayed");
        Assert.assertTrue(bookStore.getTopPanel().isCorrectUserLoggedIn(userName), "Correct user is not logged in");
        bookStore.getTopPanel().logout();
    }


    @Parameters({"existingBookForSearch"})
    @Test(description = "Verify search for an existing book")
    public void searchForExistingItem(String existingBookForSearch) throws InterruptedException {
        bookStore.startApp();
        bookStore.getLeftPanel().navigateToBookStorePage();
        bookStore.getTopPanel().searchForExistingItem(existingBookForSearch);
        Assert.assertTrue(bookStore.getTopPanel().isBookDisplayed(existingBookForSearch), "Book is not displayed on Books Page");
    }


    @Parameters({"existingBookForSearch", "userName", "password"})
    @Test(description = "Verify adding book to user's collection")
    public void addBookToCollection(String book, String userName, String password) throws InterruptedException {
        bookStore.startApp();
        bookStore.getLeftPanel().navigateToLoginPage();
        bookStore.getLoginPage().login(userName, password);
        bookStore.getLeftPanel().navigateToBookStorePage();
        bookStore.getTopPanel().searchForExistingItem(book);
        bookStore.getBookStorePage().navigateToBookPage(book);
        bookStore.getBookPage().addBookToCollection();
        Assert.assertTrue(bookStore.getAlerts().isAddingBookNotificationAlertDisplayed(), "Adding book alert is not displayed");
        bookStore.getAlerts().closeAlert();
        bookStore.getLeftPanel().navigateToProfilePage();
        bookStore.getTopPanel().searchForExistingItem(book);
        Assert.assertTrue(bookStore.getTopPanel().isBookDisplayed(book), "Book is not displayed on Profile Page");
        bookStore.getProfilePage().deleteAllBooks();
        bookStore.getModals().getDeleteModal().confirmAllBookDeleting();
        Assert.assertTrue(bookStore.getAlerts().isAllBookDeletingNotificationAlertDisplayed(), "All books deleting alert is not displayed");
        bookStore.getAlerts().closeAlert();
        bookStore.getTopPanel().logout();
    }


}

