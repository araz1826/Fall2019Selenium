package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPages extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")         //findAll or FindBys
    private WebElement createCar;

    public void clickToCreateCar(){ // because of wait time we need this method
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }

}
