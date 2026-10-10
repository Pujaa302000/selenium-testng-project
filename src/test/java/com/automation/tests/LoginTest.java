package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.config.Config;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = "smoke", description = "Verify that valid user can successfully login")
    public void loginTest() {

        driver.get(Config.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(Config.USERNAME, Config.PASSWORD);

        Assert.assertTrue(loginPage.isLoginSuccessful(),"Login was not successful");

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isProductsTitleDisplayed(),"Products page was not displayed");
    }
}

