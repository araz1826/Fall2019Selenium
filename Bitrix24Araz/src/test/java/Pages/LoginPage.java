package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {

    @FindBy (xpath= "//input[@name='USER_LOGIN']")
    public WebElement username;

    @FindBy (xpath= "//input[@name='USER_PASSWORD']")
    private WebElement password;

    @FindBy (xpath= "//input[@type='submit']")
    private WebElement login;

    @FindBy (linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy (xpath= "//div[@class='errortext']")
    private WebElement warningMessage;

    public LoginPage(){
       PageFactory.initElements(Driver.getDriver(), this); }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    public void login(String usernameValue, String passwordValue){
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }
    /*
    Java- to write a code
    Intellij- where we write a code
    Maven- project builder tool
    Selenium Webdriver-tool for automating web based applications
    TestNg- unit testing (mostly) and E2E testing framework
    Selenium: BDT (Behavior Driven Testing), TDD (Test Driven Development), Th

               TDD (Test Driven Development)- targeting lowest level of testing, it is targeting unit testing ex: method, small codes, mostly developers
                                      "write piece of code and validate test pass or fails"
                                      Developers writing code before writing functionalities, this is TDD
                                      On backgroud it assert negative and positive part to validate  to pass or fail
                                      result is Higher quality

              BDD (Behavior Driven Testing)-Entire team is being involved, writing AC (as a user I should ...) and Scenarios (calc app is open, I added 2 and 2  then cal should display 4)
                                        Write AC (based on user story), write BDD Scenarios,
                                        Based on the user story they develop code as we test it. Whole team is involved into discussion
                                        Discussing about clarification.

              TDD and BDT both about development and automated testing. Both cases tests will be written before dev.process
              TDD= dealing with raw code
              BDT/BBD= it is about testing the functionality from end-user perspective, we are not dealing with raw codes.

              BDD= it is about UI point of view.,

              Three Amigos: BA(providing req.documents) +DEV+Tester

              Feature File (extension is feature):Used to store BDD test scenarios. Without Feature file it is plain text

              BDD advantage: String Collaboration,  Documentation, Feature file is requirement and test scenario. Plain text easy to understand.

              What tools we gonna use?: to automate BDD in our test, we need cucumber (0pen sources) cucumber.io

              tdd, developers writes tests than develop application to pass those tests. bdd using same language with client,
              developer and tester. To make communication better.
     */


}
