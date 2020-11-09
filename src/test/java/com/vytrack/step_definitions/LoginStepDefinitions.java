package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user logs in")
    public void user_logs_in()  {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("prependedInput")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("prependedInput2")));
        loginPage.login();

    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText().trim();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");

    }

    //When user logs in as a "driver" --> public void user_logs_in_as_a(String string) -> loginPage.login(string); -> public void login(String role) { if role == "" do this..}
    //When user logs in as a "sales manager"
    //When user logs in as a "store manager"
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
    }

    //  String string = "storemanager85";
//  String string2 =  "wrong";
    //When user logs in with "storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    //    String expected = "Invalid user name or password."
//    Then user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected, actualResult);

    }



}
