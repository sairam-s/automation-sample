package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;

    public WebDriver initialiseDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream is = new FileInputStream("E:\\Project\\automation-sample\\src\\main\\java\\com\\automation\\application.properties");
        prop.load(is);
        String browser = prop.getProperty("browser").toLowerCase();
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sairam\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sairam\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("No browser defined");
        }
driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;

    }

}
