package com.bookstore.framework.pages;

import com.aventstack.extentreports.Status;
import com.bookstore.framework.base.BasePage;
import com.bookstore.framework.base.BaseTest;
import com.bookstore.framework.utils.listeners.TestListener;
import org.openqa.selenium.By;

public class BookStorePage extends BasePage {
    public void navigateToBookPage(String book) {
        click(By.linkText(book),"Navigate to book page");
    }
}
