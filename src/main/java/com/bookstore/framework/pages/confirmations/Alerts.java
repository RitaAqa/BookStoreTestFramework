package com.bookstore.framework.pages.confirmations;

import com.bookstore.framework.BookStore;
import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.Alert;

public class Alerts extends BasePage {

    Alert alert;
    final static String BOOKADDINGLABEL = "Book added to your collection.";
    final static String ALLBOOKDELETINGLABEL = "All Books deleted.";

    public boolean isAddingBookNotificationAlertDisplayed() {
        return isAlertDisplayed(BOOKADDINGLABEL);
    }

    public boolean isAllBookDeletingNotificationAlertDisplayed() {
        return isAlertDisplayed(ALLBOOKDELETINGLABEL);
    }

    private boolean isAlertDisplayed(String alertLabel) {
        alert = BookStore.getDriver().switchTo().alert();
        if (alert.getText().equals(alertLabel))
            return true;
        else
            return false;
    }

    public void closeAlert() {
        alert.accept();
    }
}
