package com.vytrack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.Driver;

/*
 Method for vytrack
 */
// this is fundamental class for all page classes. anything you can add here
public abstract class AbstractPageBase {
    protected WebDriver driver= Driver.getDriver();// why protected. protected is visible in the sub classes even teh out of package
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(css="#user-menu>a")
    protected WebElement currentUser;

    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }
  //calendar page under Activities   . this is common so we put this in page bas class.
    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    public void navigateTo(String tabName, String moduleName){  //tab is head, module is sub element
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";
             ////span[@class='title title-level-2' and contains(text(),'')]

        WebElement tabElement=driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement=driver.findElement(By.xpath(moduleXpath));

        Actions actions=new Actions(driver);
        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        BrowserUtils.wait(4);
    }
}
