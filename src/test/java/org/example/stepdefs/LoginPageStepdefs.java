package org.example.stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.example.pages.LoginPage;

public class LoginPageStepdefs {


    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


    @Given ("I am on the Sauce demo login page")
    public void i_am_on_the_Sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);

    }

    @When ("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When ("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }


    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        loginPage.errorMessage();
    }
    @When("I manually identify the highest price item")
    public void i_manually_identify_the_highest_price_item() {
        loginPage.findItem();
    }

    @When("I add the highest price item to the cart")
    public void i_add_the_highest_price_item_to_the_cart() {
        loginPage.findItem();
    }

    @Then("The highest price item should be in the cart")
    public void the_highest_price_item_should_be_in_the_cart() {
        loginPage.clickAddToCart();
        loginPage.checkCart();
    }
}