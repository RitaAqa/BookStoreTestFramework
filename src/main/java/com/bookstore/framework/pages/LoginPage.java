package com.bookstore.framework.pages;
import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By userNameInput = By.id("userName");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login");


    public void login(String username, String password) {
        enterText(userNameInput, username, "Enter username: " + username);
        enterText(passwordInput, password,"Enter password: " + password);
        click(loginBtn, "Login to Book Store with credentials: " + username + "/" + password );
    }
}
