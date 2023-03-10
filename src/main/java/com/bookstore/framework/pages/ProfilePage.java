package com.bookstore.framework.pages;

import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class ProfilePage extends BasePage {

    By deleteAllBooksBTN = By.xpath("//button[contains(text(),'Delete All Books')]");

    public void deleteAllBooks() {
        click(deleteAllBooksBTN);
    }
}
