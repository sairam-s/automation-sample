package com.automation.steps;

import com.automation.driver.Base;
import com.automation.pages.LandingPage;
import com.automation.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginSteps extends Base {
    public static Logger log = LogManager.getLogger(HomePageLogin.class.getName());
    LandingPage landingPage;
    LoginPage loginPage;

    @Test
    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws IOException {
        driver = initialiseDriver();
        log.info("Driver initialised");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to landing page");
         landingPage = new LandingPage(driver);
         loginPage = new LoginPage(driver);
        System.out.println(driver.getTitle());
        landingPage.getLogin().click();
        log.info("Navigated to login page");
    }

    @Test
    @When("^I enter a valid user name and password$")
    public void iEnterAValidUserNameAndPassword() {
        loginPage.getUserName().sendKeys("user1@user");
        loginPage.getPassword().sendKeys("password1");
        loginPage.getLogin().click();
    }

    @Test
    @Then("^I should not be logged in$")
    public void iShouldNotBeLoggedIn() {
        log.info("Asserting login failure");
        Assert.assertEquals(loginPage.getLoginError().getText(), "Invalid email or password");
    }

    @After
    public void close(){
        log.info("Closing the browser");
        driver.quit();
        driver = null;
    }
}
