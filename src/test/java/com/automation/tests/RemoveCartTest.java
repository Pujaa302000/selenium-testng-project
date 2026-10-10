package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.config.Config;
import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;

public class RemoveCartTest extends BaseTest {
	@Test(groups = "regression",description = "Verify that user can remove a product from cart")
    public void removeProductFromCartTest() {
		driver.get(Config.URL);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(Config.USERNAME, Config.PASSWORD);
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCart();
        inventoryPage.clickCart();
        
        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after removing the product");
    }
}
