package com.automation.utils;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
    private static final String DRIVER_PATH = String.format("%s\\src\\test\\resources\\drivers", System.getProperty("user.dir"));
    private static final String SCREENSHOT_PATH = String.format("%s\\test-output\\screenshots\\", System.getProperty("user.dir"));
    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());
    String browser;

    public WebDriver initialiseDriver() throws IOException {
        if (System.getProperty("browser") == null) {
            browser = getProperty("browser").toLowerCase();


        } else {
            browser = System.getProperty("browser");
        }

        log.info("Browser Selected::" + browser);
        if (browser.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            log.info("No browser defined");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public String getProperty(String key) throws IOException {
         Properties prop = new Properties();
           InputStream is = getClass()
                  .getClassLoader().getResourceAsStream("application.properties");
          prop.load(is);
        return prop.getProperty(key);
    }

    public void captureScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(SCREENSHOT_PATH + testName + "-screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
