package Pages;

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

public abstract class AbstractPageBase {
    protected WebDriver driver= Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(css="#user-name")
    protected WebElement currentUser;

    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    public void navigateTo(String activities){
        String tabNameXpath = "//span[@class='menu-item-link-text' and contains(text(),'"+activities+"')]";

        WebElement elements=driver.findElement(By.xpath(tabNameXpath));
        elements.click();
        BrowserUtils.wait(4);
    }
}
