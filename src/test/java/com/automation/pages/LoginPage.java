package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(id = "user_email")
    private WebElement userName;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement login;
    @FindBy(css = ".alert")
    private WebElement loginError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getLoginError() {
        return loginError;
    }
}
