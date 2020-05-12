package com.odooerp.pages;


import com.odooerp.utilities.BrowserUtilities;
import com.odooerp.utilities.ConfigurationReader;
import com.odooerp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

    @FindBy(id = "login")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    public void login(){
       username.sendKeys(ConfigurationReader.getProperty("POS1"));
       password.sendKeys(ConfigurationReader.getProperty("POSPass"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }


    public void navigateTo(String tabName){
        String tabNameXpath = "//*[@class='oe_menu_text' and contains(text(),'"+tabName+"')]";
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        Actions actions = new Actions(driver);

        BrowserUtilities.wait(4);

        actions.moveToElement(tabElement).
                pause(1000).
                click(tabElement).
                build().perform();

        //increase this wait rime if still failing
        BrowserUtilities.wait(4);
    }


}
