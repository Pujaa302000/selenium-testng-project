package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");

    private By continueButton = By.id("continue");

    private By overviewTitle = By.cssSelector(".title");

    private By finishButton = By.id("finish");

    private By successMessage = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCheckoutDetails(String first, String last, String zip) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(first);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys(last);

        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode))
                .sendKeys(zip);
    }

    public void clickContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(continueButton))
                .click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(overviewTitle,"Checkout: Overview"));

        System.out.println("Overview page loaded: " + driver.getCurrentUrl());
    }

    public boolean isOverviewDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(overviewTitle)).getText().equals("Checkout: Overview");
    }

    public void clickFinish() {

        wait.until(ExpectedConditions.elementToBeClickable(finishButton))
                .click();
    }

    public boolean isOrderSuccessful() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                .getText()
                .equals("Thank you for your order!");
    }
}