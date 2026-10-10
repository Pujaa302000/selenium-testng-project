package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productName = By.cssSelector("[data-test='inventory-item-name']");

    private By removeButton =
            By.cssSelector("[data-test='remove-sauce-labs-backpack']");

    private By checkoutButton =
            By.cssSelector("[data-test='checkout']");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public boolean isProductDisplayed() {
        return driver.findElements(productName).size() > 0;
    }

    public boolean isCartEmpty() {
    	 return wait.until(
    	            ExpectedConditions.invisibilityOfElementLocated(productName));
    }

    public void removeProduct() {

        System.out.println("Current URL before remove: " + driver.getCurrentUrl());

        System.out.println("Remove button count: "
                + driver.findElements(removeButton).size());

        wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton));

        System.out.println("Remove button is visible");

        wait.until(ExpectedConditions.elementToBeClickable(removeButton))
                .click();

        System.out.println("Remove button clicked");
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));

        System.out.println("Checkout page loaded: " + driver.getCurrentUrl());
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}