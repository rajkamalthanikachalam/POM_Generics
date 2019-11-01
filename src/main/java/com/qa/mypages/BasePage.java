package com.qa.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Raj Kamal Thanikachalam
 * This is the base class for all
 */

public class BasePage extends AbstractPage {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {                        // Method Overriding : Declaring the method define in abstract class
        return driver.getTitle();
    }

    @Override
    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }

    @Override
    public WebElement getElement(By locator) {            // Wrapper function
        WebElement element = null;
        try {                                            // Exception handling using try, catch block
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            System.out.println("Exception occured while capturing element : " + locator.toString());
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public void WaitForElementPresent(By locator) {        // Exception handling using try, catch block
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Exception occured while capturing element : " + locator.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void WaitFprPageTitle(String title) {        // Exception handling using try, catch block
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            System.out.println("Exception occured while capturing element : " + title.toString());
            e.printStackTrace();
        }
    }

}
