package com.zerobank.step_definitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions extends BasePage {

    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("http://zero.webappsecurity.com/index.html");
    }

    @When("user logs in with user name and password")
    public void user_logs_in_with_user_name_and_password() {
    loginPage.login();
    }

    @Then("verify that user is on the login page")
    public void verify_that_user_is_on_the_login_page() {
        Assert.assertEquals("Zero - Account Summary",Driver.getDriver().getTitle());
        Driver.closeDriver();

    }


}
