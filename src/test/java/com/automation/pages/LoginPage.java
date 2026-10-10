package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.config.Config;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By usernameField = By.cssSelector("#user-name");

    public void enterUsername(String username) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        ).sendKeys(username);
    }

    private By passwordField = By.cssSelector("#password");

    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);
    }

    private By loginButton = By.cssSelector("#login-button");

    public void clickLoginButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    private By loginError = By.cssSelector("[data-test='error']");

    public String getLoginErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginError)
        ).getText();
    }

    public boolean isLoginSuccessful() {

        return wait.until(
                ExpectedConditions.urlToBe(Config.INVENTORY_URL)
        );
    }
}