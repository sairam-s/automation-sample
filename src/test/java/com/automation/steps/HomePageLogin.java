package com.automation.steps;

import com.automation.driver.Base;
import com.automation.pages.LandingPage;
import com.automation.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageLogin extends Base {
    public static Logger log = LogManager.getLogger(HomePageLogin.class.getName());

    @BeforeMethod
    public void initialise() throws IOException {
        driver = initialiseDriver();
        log.info("Driver initialised");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to landing page");
    }

    @Test(dataProvider = "userData")
    public void homepageNavigation(String userName, String password) {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        System.out.println(driver.getTitle());
        landingPage.getLogin().click();
        log.info("Navigated to login page");
        loginPage.getUserName().sendKeys(userName);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLogin().click();
        log.info("Asserting login failure");
        Assert.assertEquals(loginPage.getLoginError().getText(), "Invalid email or password.");
    }

    @DataProvider
    public Object[][] userData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "user1@user";
        data[0][1] = "password1";

        data[1][0] = "user2@user";
        data[1][1] = "password2";

        return data;
    }

    @AfterMethod
    public void teardown() {
        log.info("Closing the browser");
        driver.quit();
        driver = null;
    }
}
