package com.electropi.automation.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final String emailInput =
            "[data-testid='email']";

    private final String passwordInput =
            "[data-testid='password']";

    private final String loginButton =
            "[data-testid='login-button']";

    public LoginPage(Page page) {
        this.page = page;
    }

  public void navigateToLoginPage(String baseUrl) {
    page.navigate(baseUrl + "/login");
}
    

    public void login(String email, String password) {
        page.locator(emailInput).fill(email);
        page.locator(passwordInput).fill(password);
        page.locator(loginButton).click();
    }
}