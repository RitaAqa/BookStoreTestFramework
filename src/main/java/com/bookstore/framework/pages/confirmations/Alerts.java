package com.bookstore.framework.pages.confirmations;

import com.bookstore.framework.BookStore;
import com.bookstore.framework.base.BasePage;
import com.bookstore.framework.utils.report.Reporter;
import org.openqa.selenium.Alert;

public class Alerts extends BasePage {

    Alert alert;
    final static String BOOKADDINGLABEL = "Book added to your collection.";
    final static String ALLBOOKDELETINGLABEL = "All Books deleted.";

    public boolean isAddingBookNotificationAlertDisplayed() {
        return isAlertDisplayed(BOOKADDINGLABEL, "Check if AddingBookNotificationAlert is displayed");
    }

    public boolean                                  isAllBookDeletingNotificationAlertDisplayed() {
        return isAlertDisplayed(ALLBOOKDELETINGLABEL, "Check if BookDeletingNotificationAlert is displayed");
    }

    private boolean isAlertDisplayed(String alertLabel, String msg) {
        Reporter.log(msg);
        alert = BookStore.getDriver().switchTo().alert();
        if (alert.getText().equals(alertLabel)) {
            Reporter.log("Alert with text " + alertLabel + " is displayed");
            return true;
        } else {
            Reporter.log("Alert with text " + alertLabel + " is not displayed");
            return false;
        }
    }

    public void closeAlert() {
        Reporter.log("Close alert");
        alert.accept();
    }
}
