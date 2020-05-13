package com.automation.steps;

import com.automation.pages.LandingPage;
import com.automation.utils.Base;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


public class HomePageAssertions extends Base {
    public static Logger log = LogManager.getLogger(HomePageAssertions.class.getName());
     WebDriver driver;

    @BeforeTest
    public void initialise() throws IOException {
       driver = initialiseDriver();
        log.info("Driver initialised");
     //   driver.get(prop.getProperty("url"));
        driver.get(getProperty("url"));
        log.info("Navigated to landing page");
    }

    @Test
    public void homepageNavigation() {
        LandingPage landingPage =  new LandingPage(driver);;
        log.info("Validating objects on landing page ");
        Assert.assertTrue(landingPage.getFeaturedCourseTitle().isDisplayed());
        Assert.assertTrue(landingPage.getNavBar().isDisplayed());
    }

    @AfterTest
    public void teardown() {
        log.info("Closing the browser");
        driver.quit();
        driver=null;
    }
}
