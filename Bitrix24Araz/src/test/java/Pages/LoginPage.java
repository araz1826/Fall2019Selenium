package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

/*
    creating a model page for passwords usernmames. it is organizable
    used to store collection
     */
public class LoginPage {

    @FindBy (id= "prependedInput") // id: locator type,   "prependedInput": value
    public WebElement username;
    //public webelement username2=Driver.getDriver().finelement(By.id("")) it is same as above method

    @FindBy (id= "prependedInput2")
    private WebElement password;

    @FindBy (id= "_submit")
    private WebElement login;

    @FindBy (linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy (css= "div[class='alert alert-error']")
    private WebElement warningMessage; // incorrect password and invalid username warning

    public LoginPage(){
        //to connect our webdriver, page class and page factory
        //PageFactory-used to use @FindBy annotations
        //PageFactory-helps to find webelement
        PageFactory.initElements(Driver.getDriver(), this);  // this line is only for using FindBy
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    //version #1
    public void login(String usernameValue, String passwordValue){  // this is overloaded
        this.username.sendKeys(usernameValue);  // you do not have to put this, because there is only 1 username
        this.password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }
    //version #2  login as a default user (but either top or this are same)
    public void login(){
       username.sendKeys(ConfigurationReader.getProperty("store_manager"));  // you do not have to put this, because there is only 1 username
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

}
