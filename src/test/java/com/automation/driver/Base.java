package com.automation.driver;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    private static final String DRIVER_PATH = String.format("%s\\src\\test\\resources\\drivers", System.getProperty("user.dir"));
    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());
    public Properties prop = new Properties();
    String browser;

    public WebDriver initialiseDriver() throws IOException {
        InputStream is = getClass()
                .getClassLoader().getResourceAsStream("application.properties");
        prop.load(is);
        if (System.getProperty("browser") == null) {
            browser = prop.getProperty("browser").toLowerCase();
        } else {
            browser = System.getProperty("browser");
        }

        log.info("Browser Selected::" + browser);
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            log.info("No browser defined");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public void captureScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("E:\\Project\\automation-sample\\screenshots\\" + testName + "-screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
