package test;

import Pages.LoginPage;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class LoginTest extends AbstractTestBase{

    @Test
    public void loginTest(){

        LoginPage loginPage=new LoginPage();
        loginPage.login("helpdesk51@cybertekschool.com","UserUser");
        BrowserUtils.wait(4);

    }
}
