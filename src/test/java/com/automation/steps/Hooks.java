package com.automation.steps;


import com.automation.utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Hooks extends Base  {
    public static Logger log = LogManager.getLogger(HomePageLogin.class.getName());
    Scenario scenario;

    @Before
    public void BeforeAll(Scenario scenario) throws IOException {
        this.scenario = scenario;
        initialiseDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        System.out.println("Scenario Name is:" + scenario.getName());
        if (scenario.isFailed()) {
           captureScreenshot(scenario.getName());
        }
        log.info("Closing the browser");
        driver.quit();
        driver = null;
    }
}
