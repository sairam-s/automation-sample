package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;
    By login = By.xpath("//span[contains(text(),'Login')]");
    By navBar = By.cssSelector(".navbar-collapse");
    By featuredCourseTitle = By.xpath("//h2[contains(text(),'Featured Courses')]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public WebElement getNavBar(){ return driver.findElement(navBar);}

    public WebElement getFeaturedCourseTitle(){ return driver.findElement(featuredCourseTitle);}
}