package com.qa.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Raj Kamal Thanikachalam
 * This is the base class for all
 */
public class LoginPage extends BasePage {

    // Page Locators : Encapsulation is achieved through calling page locators in privates
    private By emailId = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("loginBtn");
    private By header = By.className("auth-box marketing-box");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Private variables of this class will not be accessible out of the class, so achieving through getter and setters
    //to achieve encapsulation
    public WebElement getEmailId() {            // To perfom .click. sendkeys, following way can be achieved
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public WebElement getHeader() {
        return getElement(header);
    }

    public String getLoginPageTitle() {
        return getPageTitle();
    }

    public String getLoginPageHeader() {
        return getPageHeader(header);
    }

    //Generic Method to call the landing page
    public HomePage Login(String userName, String password) {
        getEmailId().sendKeys(userName);
        getPassword().sendKeys(password);
        getLoginButton().click();
        return getInstance(HomePage.class);
    }

    //Method Overloading : Login method without parameters
    public void Login() {
        getEmailId().sendKeys();
        getPassword().sendKeys();
        getLoginButton().click();
    }

    // Method Overlaoding for Negative testing
    public void Login(String userName) {
        if (userName.contains("userName")) {
            getEmailId().sendKeys(userName.split(":")[1].trim());
        } else if (userName.contains("password")) {
            getEmailId().sendKeys(userName.split(":")[1].trim());
        }
        getLoginButton().click();

    }

}