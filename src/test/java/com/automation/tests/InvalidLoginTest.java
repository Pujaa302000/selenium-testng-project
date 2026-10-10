package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.config.Config;
import com.automation.pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][] {
            {"invalid_user", "invalid_password"},
            {"wrong_user", "wrong_password"}
        };
    }

    @Test(dataProvider = "invalidLoginData", groups = "negative",
    		description = "Verify that invalid login credentials display an error message")
    public void invalidLoginTest(String username, String password) {

        driver.get(Config.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        String errorMessage = loginPage.getLoginErrorMessage();

        Assert.assertTrue(
                errorMessage.contains("Username and password do not match"),
                "Expected login error message was not displayed"
        );
    }
}