package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


import java.io.File;
import java.util.List;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameInputLocator = By.name("user-name");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.id("login-button");
    private By errorMessageLocator = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private By itemPricesLocator = By.className("inventory_item_price");
    private By itemAddToCartButtonsLocator = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIconLocator = By.id("shopping_cart_container");
    private By cartItemsLocator = By.className("cart_item");

    // Constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    // Methods

    //Enter the username
    public void enterUsername(String username) {
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        WebElement usernameInput = driver.findElement(usernameInputLocator);
        usernameInput.sendKeys(username);
    }

    //Enter password
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    //Click login button
    public void clickLoginButton() {

        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    //verify error message
    public boolean errorMessage(){
        return driver.findElement(errorMessageLocator).isDisplayed();

    }

    // find the item
    public void findItem() {
        List<WebElement> prices = driver.findElements(itemPricesLocator);
        List<WebElement> addToCartButtons = driver.findElements(itemAddToCartButtonsLocator);

        double highestPrice = 0.0;
        int highestPriceIndex = 0;

        // Loop through prices and find the highest one
        for (int i = 0; i < ((List<?>) prices).size(); i++) {
            double price = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceIndex = i;
            }
        }

        // Click the corresponding "Add to Cart" button
        addToCartButtons.get(highestPriceIndex).click();
    }

    // Open the cart
    public void clickAddToCart() {
        driver.findElement(cartIconLocator).click();
    }

    // Verify the highest-priced item is in the cart
    public boolean checkCart() {
        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        return !cartItems.isEmpty(); // If cart has items, return true
    }
}