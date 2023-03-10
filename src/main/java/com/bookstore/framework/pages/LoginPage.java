package com.bookstore.framework.pages;
import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By userNameInput = By.id("userName");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login");


    public void login(String username, String password) {
        enterText(userNameInput, username);
        enterText(passwordInput, password);
        click(loginBtn);
    }
}
