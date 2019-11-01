package com.qa.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Raj Kamal Thanikachalam
 * This is the base class for all
 */
public class HomePage extends BasePage {

    private By header = By.xpath("//h1[text()='Sales Dashboard']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderHomePage() {
        return getElement(header);
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }

    public String getHomePageHeader() {
        return getPageHeader(header);
    }

}