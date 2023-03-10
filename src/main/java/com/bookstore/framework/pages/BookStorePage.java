package com.bookstore.framework.pages;

import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class BookStorePage extends BasePage {
    public void navigateToBookPage(String book) {
        click(By.linkText(book));
    }
}
