package com.automation.pages;

import com.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends Base{

    public WebDriver driver;
    private By login = By.xpath("//span[contains(text(),'Login')]");
    private By navBar = By.cssSelector(".navbar-collapse");
    private By featuredCourseTitle = By.xpath("//h2[contains(text(),'Featured Courses')]");

   public LandingPage(WebDriver driver) {
        this.driver = driver;
    }



    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public WebElement getNavBar() {
        return driver.findElement(navBar);
    }

    public WebElement getFeaturedCourseTitle() {
        return driver.findElement(featuredCourseTitle);
    }
}
