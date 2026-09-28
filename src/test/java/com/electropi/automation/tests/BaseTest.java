package com.electropi.automation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.electropi.automation.utils.DriverFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class BaseTest {

    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        browser = DriverFactory.launchBrowser();

        context = browser.newContext();

        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {

        if (context != null) {
            context.close();
        }

        DriverFactory.closeBrowser();
    }
}