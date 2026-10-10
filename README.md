# SauceDemo Selenium Test Automation Framework

## Project Overview

This project is a UI test automation framework developed using Java, Selenium WebDriver, TestNG, and Maven. It automates key user workflows on the SauceDemo demo website.

## Technologies Used

* Java
* Selenium WebDriver 4.35.0
* TestNG 7.11.0
* Maven
* ExtentReports 5.1.2
* Eclipse IDE
* Git and GitHub
* Google Chrome

## Framework Features

* **Page Object Model (POM):** Separates page elements and actions from test classes.
* **TestNG:** Organizes and executes automated test cases.
* **Data-Driven Testing:** Uses TestNG DataProvider for invalid login scenarios.
* **Test Listener:** Captures test execution results and handles failure screenshots.
* **ExtentReports:** Generates an HTML report with test execution status and screenshots for failures.
* **Maven Integration:** Manages project dependencies and test execution.
* **Test Suite:** Uses `testng.xml` to configure the test suite.

## Test Scenarios

* Verify login with valid credentials.
* Verify login with invalid credentials using DataProvider.
* Verify removing a product from the shopping cart.
* Verify the checkout workflow.

## Project Structure

```text
selenium-testng-project/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/automation/
│       │       ├── config/
│       │       │   └── Config.java
│       │       ├── listeners/
│       │       │   └── TestListener.java
│       │       ├── pages/
│       │       │   ├── LoginPage.java
│       │       │   ├── InventoryPage.java
│       │       │   ├── CartPage.java
│       │       │   └── CheckoutPage.java
│       │       ├── tests/
│       │       │   ├── BaseTest.java
│       │       │   ├── LoginTest.java
│       │       │   ├── InvalidLoginTest.java
│       │       │   ├── RemoveCartTest.java
│       │       │   └── CheckoutTest.java
│       │       └── utils/
│       │           ├── ScreenshotUtil.java
│       │           └── ExtentReportManager.java
│       └── resources/
│           └── config.properties
├── testng.xml
├── pom.xml
└── README.md
```

## Prerequisites

* Java Development Kit (JDK)
* Maven
* Google Chrome
* Git

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/Pujaa302000/selenium-testng-project.git
   ```
2. Navigate to the project directory:

   ```bash
   cd selenium-testng-project
   ```
3. Run the test suite:

   ```bash
   mvn test
   ```

## Test Reports

* **ExtentReports:** Generated at `test-output/ExtentReport.html`
* **TestNG/Surefire Reports:** Available under `target/surefire-reports/`

Generated reports and screenshots are excluded from Git tracking through `.gitignore`.

## Execution Status

The latest verified test execution completed with **5 tests passed and 0 failures**.

## Repository

[GitHub Repository](https://github.com/Pujaa302000/selenium-testng-project)
