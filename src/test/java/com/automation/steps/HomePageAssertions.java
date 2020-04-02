package com.automation.steps;

import com.automation.driver.Base;
import com.automation.pages.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageAssertions extends Base {
    public static Logger log = LogManager.getLogger(HomePageAssertions.class.getName());

    @BeforeTest
    public void initialise() throws IOException {
        driver = initialiseDriver();
        log.info("Driver initialised");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to landing page");
    }

    @Test
    public void homepageNavigation() {
        LandingPage landingPage = new LandingPage(driver);
        log.info("Validating objects on landing page ");
        Assert.assertTrue(landingPage.getFeaturedCourseTitle().isDisplayed());
        Assert.assertTrue(landingPage.getNavBar().isDisplayed());
    }

    @AfterTest
    public void teardown() {
        log.info("Closing the browser");
        driver.quit();
    }
}
