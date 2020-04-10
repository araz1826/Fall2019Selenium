package test;

import Pages.LoginPage;
import Pages.VehiclesPages;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class VehiclesModelTest extends AbstractTestBase {

    @Test
    public void VehicleModels(){
        LoginPage loginPage=new LoginPage();
        VehiclesPages vehiclesPages=new VehiclesPages();

        loginPage.login();
        vehiclesPages.navigateTo("Fleet","Vehicles Model");
        String expectedTitle = "All - Vehicles Model - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
