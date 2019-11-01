package com.qa.mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.mypages.AbstractPage;
import com.qa.mypages.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    WebDriver driver;
    public AbstractPage page;

    @Parameters(value = "browser")
    @BeforeMethod
    public void setUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            //To avoid mentioning the path, we use the following way, where bonigarcia take care of it, which was mentioned in POM.XML
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("No browser defined");
        }
        driver.manage().window().fullscreen();
        driver.get("https://app.hubspot.com/login");    // later pass from the config file

        //Pass the base class constructor to this page, which is defined in abstract class and calling through the child class
        page = new BasePage(driver);    // failing to call this method result in null pointer exceptions
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
