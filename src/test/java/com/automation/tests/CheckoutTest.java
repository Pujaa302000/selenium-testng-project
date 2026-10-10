package com.automation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.config.Config;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;

public class CheckoutTest extends BaseTest {

	@Test(groups = "regression",description = "Verify that user can successfully complete checkout")
    public void checkoutTest() {
    	
        driver.get(Config.URL);

    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.login(Config.USERNAME, Config.PASSWORD);
    	
    	//System.out.println("Current URL: " + driver.getCurrentUrl());

    	InventoryPage inventoryPage = new InventoryPage(driver);
    	inventoryPage.clickAddToCart();
    	inventoryPage.clickCart();
    	
    	CartPage cartPage = new CartPage(driver);
    	Assert.assertTrue(cartPage.isProductDisplayed(),"Product was not added to the cart");
    	cartPage.clickCheckout();
    	System.out.println("Checkout URL: " + driver.getCurrentUrl());
    	System.out.println("Checkout Title: " + driver.getTitle());
    	CheckoutPage checkoutPage = new CheckoutPage(driver);

    	checkoutPage.enterCheckoutDetails("Puja", "Ravi", "560001");

    	checkoutPage.clickContinue();
    	System.out.println("Overview Title: " + driver.findElement(By.cssSelector(".title")).getText());    	
    	
    	//Assert.assertTrue(false);
    	checkoutPage.clickFinish();

    	System.out.println("After Finish URL: " + driver.getCurrentUrl());
    	System.out.println("After Finish Title: " + driver.getTitle());

    	Assert.assertTrue(checkoutPage.isOrderSuccessful());
    }
    
}

