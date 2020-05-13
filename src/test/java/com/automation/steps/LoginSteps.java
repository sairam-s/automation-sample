package com.automation.steps;

import com.automation.pages.LandingPage;
import com.automation.pages.LoginPage;
import com.automation.utils.Base;
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
    LandingPage landingPage = new LandingPage(driver);
    LoginPage loginPage = new LoginPage(driver);


    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws IOException {
        // driver = initialiseDriver();
        log.info("Driver initialised");
        // driver.get(prop.getProperty("url"));
        driver.get(getProperty("url"));
        log.info("Navigated to landing page");

        System.out.println(driver.getTitle());
        landingPage.getLogin().click();
        log.info("Navigated to login page");
    }


    @When("^I enter a valid user name and password$")
    public void iEnterAValidUserNameAndPassword() {
        loginPage.getUserName().sendKeys("user1@user");
        loginPage.getPassword().sendKeys("password1");
        loginPage.getLogin().click();
    }


    @Then("^I should not be logged in$")
    public void iShouldNotBeLoggedIn() {
        log.info("Asserting login failure");
        Assert.assertEquals(loginPage.getLoginError().getText(), "Invalid email or password.");
    }
}
