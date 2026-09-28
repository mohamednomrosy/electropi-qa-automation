package com.electropi.automation.pages;

import com.microsoft.playwright.Page;

public class InventoryPage {

    private final Page page;

    private final String inventoryMenu =
            "[data-testid='inventory-menu']";

    private final String productNameInput =
            "[data-testid='product-name']";

    private final String productPriceInput =
            "[data-testid='product-price']";

    private final String saveButton =
            "[data-testid='save-product']";

    private final String successToast =
            "[data-testid='success-toast']";

    public InventoryPage(Page page) {
        this.page = page;
    }

    public void navigateToInventory() {
        page.locator(inventoryMenu).click();
        page.waitForURL("**/inventory");
    }

    public void createProduct(String productName, String price) {
        page.locator(productNameInput).fill(productName);
        page.locator(productPriceInput).fill(price);
        page.locator(saveButton).click();
    }

    public boolean isSuccessToastDisplayed() {
        return page.locator(successToast).isVisible();
    }

    public String getSuccessToastMessage() {
        return page.locator(successToast).innerText();
    }
}