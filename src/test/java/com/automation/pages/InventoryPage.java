package com.automation.pages;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
private WebDriver driver;
private WebDriverWait wait;
private By productsTitle = By.className("title");
private By addToCartButton =
By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
public InventoryPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
public boolean isProductsTitleDisplayed() {
    return driver.findElement(productsTitle).isDisplayed();
}

public boolean isCartBadgeDisplayed() {
    return driver.findElement(cartBadge).isDisplayed();
}

public String getCartBadgeText() {
    return driver.findElement(cartBadge).getText();
}

public void clickAddToCart() {
	wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click(); 
}

public void clickCart() {
    wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    //wait.until(ExpectedConditions.urlContains("cart.html"));
}

private By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
private By cartLink = By.cssSelector("[data-test='shopping-cart-link']");
}
