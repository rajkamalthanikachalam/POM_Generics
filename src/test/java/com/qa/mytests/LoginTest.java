/**
 *
 */
package com.qa.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.mypages.HomePage;
import com.qa.mypages.LoginPage;

/**
 * @author Raj Kamal
 *
 */
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLoginPageTitle() {
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "HubSpot Login");

    }

    @Test(priority = 2)
    public void verifyLoginPageHeader() {
        String header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "HubSpot");

    }

    @Test(priority = 3)
    public void verifyLogin() {
        //Assigning it to the landing page
        HomePage hp = page.getInstance(LoginPage.class).Login("008rajkamal@gmail.com", "Aug$2019@");
        String headerHome = hp.getHomePageHeader();
        Assert.assertEquals(headerHome, "Getting started with HubSpot");

    }

}
