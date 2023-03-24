package com.bookstore.framework.pages;

import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class BookPage extends BasePage {

    By addBookToCollectionBTN = By.xpath("//button[@id='addNewRecordButton'][contains(text(), 'Add To Your Collection')]");

    public void addBookToCollection() {
        click(addBookToCollectionBTN, "Add book to collection");
    }
}
