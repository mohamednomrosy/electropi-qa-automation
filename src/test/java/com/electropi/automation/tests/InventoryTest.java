package com.electropi.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.electropi.automation.pages.InventoryPage;
import com.electropi.automation.pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test
    public void storeAdminCanCreateInventoryItem() {

        LoginPage loginPage = new LoginPage(page);
        InventoryPage inventoryPage = new InventoryPage(page);
        String baseUrl = System.getenv("ELECTROPI_BASE_URL");
        String username = System.getenv("ELECTROPI_USERNAME");
        String password = System.getenv("ELECTROPI_PASSWORD");

        if (baseUrl == null || username == null || password == null) {
            throw new IllegalStateException(
                    "Required environment variables are not configured: " +
                    "ELECTROPI_BASE_URL, ELECTROPI_USERNAME, ELECTROPI_PASSWORD"
            );
        }

        loginPage.navigateToLoginPage(baseUrl);

        loginPage.login(username, password);

        inventoryPage.navigateToInventory();

        inventoryPage.createProduct(
                "Wireless Mouse",
                "25.00"
        );

        Assert.assertTrue(
                inventoryPage.isSuccessToastDisplayed(),
                "Success toast should be displayed after saving the product."
        );

        Assert.assertTrue(
                inventoryPage.getSuccessToastMessage()
                        .toLowerCase()
                        .contains("success"),
                "Success toast should contain a success message."
        );
    }
}