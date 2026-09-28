# Electro Pi QA Automation

**Author:** Mohamed Mamdouh El Nomrosy

## Overview

This repository contains the UI automation solution developed for the Electro Pi QA Automation Engineer Technical Assessment.

The implementation uses Playwright with Java and TestNG and follows the Page Object Model (POM) design pattern.

## Technology Stack

* Java 17
* Playwright
* TestNG
* Maven
* Page Object Model (POM)

## Automated Scenario

The implemented test covers the following Store Admin workflow:

1. Navigate to the login page.
2. Log in as Store Admin.
3. Navigate to Inventory.
4. Enter Product Name.
5. Enter Product Price.
6. Click Save.
7. Verify that the success toast is displayed.
8. Validate the success message.

## Project Structure

```text
src
├── main
│   └── java
│       └── com.electropi.automation
│           ├── pages
│           │   ├── LoginPage.java
│           │   └── InventoryPage.java
│           │
│           └── utils
│               └── DriverFactory.java
│
└── test
    └── java
        └── com.electropi.automation
            └── tests
                ├── BaseTest.java
                └── InventoryTest.java
```

## Configuration

The test uses environment variables for the application URL and credentials.

Required environment variables:

```text
ELECTROPI_BASE_URL
ELECTROPI_USERNAME
ELECTROPI_PASSWORD
```

Credentials should not be committed to source control. In a CI/CD environment, they should be stored as secure repository or environment secrets.

## Running the Tests

After configuring the required environment variables, run:

```bash
mvn clean test
```

## Assessment Environment Assumption

The assessment did not provide a live application environment, application URL, authentication endpoint, credentials, or production selectors.

Therefore, the URL, selectors, and authentication configuration in this repository are placeholders based on the provided scenario.

The implementation is structured so these values can be replaced when the actual test environment becomes available.

## Stability Approach

The automation avoids hardcoded waits such as `Thread.sleep()`.

Playwright's built-in auto-waiting and explicit application-state synchronization are used to reduce flaky test behavior.

Stable selectors such as `data-testid` are assumed for the application components.

## Security

No real credentials or access tokens are included in this repository.

Sensitive configuration should be provided through environment variables or CI/CD secrets.

## Notes

This repository demonstrates the proposed automation architecture and implementation for the assessment scenario. Actual execution against the Electro Pi application requires the corresponding tes
