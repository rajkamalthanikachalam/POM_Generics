/**
 *
 */
package com.qa.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Raj Kamal Thanikachalam
 * This is the base class for all
 * naveenanimation20@gmail.com
 */
public abstract class AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    // Creating constructor, while abstract allows
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    // Abstract Methods : Every page will have this methods
    public abstract String getPageTitle();

    public abstract String getPageHeader(By locator);

    public abstract WebElement getElement(By locator);

    public abstract void WaitForElementPresent(By locator);

    public abstract void WaitFprPageTitle(String title);

    /*Generics : At a runtime, whatever page class is passing, I am checking the declared constructor(here driver) are passing
     * and creating the object of that class*/
    public <TPage extends BasePage> TPage getInstance(Class<TPage> PageClass) {

        try {
            return PageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
