package com.automation.driver;


import com.automation.steps.HomePageAssertions;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public Properties prop = new Properties();
    String browser;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    public WebDriver initialiseDriver() throws IOException {
        InputStream is = getClass()
                .getClassLoader().getResourceAsStream("application.properties");
        //  FileInputStream is = new FileInputStream("E:\\Project\\automation-sample\\src\\main\\java\\com\\automation\\application.properties");
        prop.load(is);
        if(System.getProperty("browser")==null) {
             browser= prop.getProperty("browser").toLowerCase();
        } else{
            browser = System.getProperty("browser");
        }

        log.info("Browser Selected::" + browser);
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sairam\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sairam\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
           log.info("No browser defined");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public void captureScreenshot(String testName){
       File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("E:\\Project\\automation-sample\\screenshots\\"+testName+"-screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
