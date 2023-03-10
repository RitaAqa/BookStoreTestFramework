package com.bookstore.framework.pages.panels;
import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class LeftPanel extends BasePage {

    private final By loginMenuItem = By.xpath("//div[@class='element-group'][6]//li[1]//span[contains(text(),'Login')]");
    private final By bookStoreMenuItem = By.xpath("//div[@class='element-group'][6]//li[2]//span[contains(text(),'Book Store')]");
    private final By profileMenuItem = By.xpath("//div[@class='element-group'][6]//li[3]//span[contains(text(),'Profile')]");

    public void navigateToLoginPage() throws InterruptedException {
        if (!getCurrentPage().equals("Login")) {
            clickForceWhenElementIsOverlapped(loginMenuItem);
        }
    }

    public void navigateToBookStorePage() throws InterruptedException {
        if (!getCurrentPage().equals("Book Store")) {
           clickForceWhenElementIsOverlapped(bookStoreMenuItem);
        }
    }

    public void navigateToProfilePage() throws InterruptedException {
        if (!getCurrentPage().equals("Profile"));
        clickForceWhenElementIsOverlapped(profileMenuItem);
    }
}
