package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signinButton;

    @FindBy (id = "user_login")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;


    public void singInButton(){
     signinButton.click();
    }

    public void login(){
     wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("user_login"))));
     username.sendKeys(ConfigurationReader.getProperty("username"));
     password.sendKeys(ConfigurationReader.getProperty("password"));

    }
    public void login(String username1, String password1){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("user_login"))));
        username.sendKeys(ConfigurationReader.getProperty(username1));
        username.sendKeys(ConfigurationReader.getProperty(password1), Keys.ENTER);

    }
}










