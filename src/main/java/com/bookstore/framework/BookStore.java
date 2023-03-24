package com.bookstore.framework;

import com.bookstore.framework.pages.*;
import com.bookstore.framework.pages.confirmations.Alerts;
import com.bookstore.framework.pages.confirmations.Modals;
import com.bookstore.framework.pages.panels.LeftPanel;
import com.bookstore.framework.pages.panels.TopPanel;
import com.bookstore.framework.utils.DriversProvider;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static com.bookstore.framework.utils.PropertiesLoader.BASE_URL;
import static com.bookstore.framework.utils.PropertiesLoader.BROWSER;

/**
 * class initiates application pages and contains common methods for application
 */
public class BookStore {
    private static WebDriver driver;

    static final Logger logger = Logger.getLogger(BookStore.class);

    private LeftPanel leftPanel;
    private TopPanel topPanel;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private BookStorePage bookStorePage;
    private BookPage bookPage;
    private Alerts alerts;
    private Modals modals;

    /**
     * Method sets up browser
     */
    public BookStore() throws Exception {
        logger.info("New driver initialization");
        driver = DriversProvider.getInstance(BROWSER);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Method closes browser
     */
    public void closeApp() {
        driver.quit();
    }

    /**
     * Method opens browser on start page
     */
    public void startApp() {
        logger.info("Open start page");
        driver.get(BASE_URL);
    }

    //----------------------------------- pages initiation--------------------------------------------------------------


    public LeftPanel getLeftPanel() {
        if (leftPanel == null) {
            leftPanel = new LeftPanel();
        }
        return leftPanel;
    }

    public TopPanel getTopPanel() {
        if (topPanel == null) {
            topPanel = new TopPanel();
        }
        return topPanel;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ProfilePage getProfilePage() {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        return profilePage;
    }


    public BookStorePage getBookStorePage() {
        if (bookStorePage == null) {
            bookStorePage = new BookStorePage();
        }
        return bookStorePage;
    }

    public BookPage getBookPage() {
        if (bookPage == null) {
            bookPage = new BookPage();
        }
        return bookPage;
    }

    public Alerts getAlerts() {
        if (alerts == null) {
            alerts = new Alerts();
        }
        return alerts;
    }

    public Modals getModals() {
        if (modals == null) {
            modals = new Modals();
        }
        return modals;
    }
}
