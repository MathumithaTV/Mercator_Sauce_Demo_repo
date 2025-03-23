package org.example.utilities;

import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Driver {

    public static void main(String[] args) {
        // Step 1: Initialize WebDriver
        WebDriver driver = LoginPage.initializeDriver();

        // Step 2: Open the Login Page
        driver.get("https://www.saucedemo.com/");

        // Step 3: Create an instance of LoginPage
        LoginPage loginPage = new LoginPage(driver);

//        // Step 4: Perform Login Actions
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickLoginButton();

        // Step 5: Wait for a few seconds (Optional for visibility)
        try {
            Thread.sleep(3000); // Not recommended for real test automation, use WebDriverWait instead.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 6: Close the browser
        driver.quit();
    }
}
