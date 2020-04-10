package test;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.ExcelUtil;

public class NewLoginTest extends AbstractTestBase {



     //login and verify that page title is a "DashBoard"
    @Test (groups = "smoke")
    public void verifyPageTitle(){
        // right click on any report and open in browser with chrome
        //right click on test-output and "show in explorer" for windows, for mac use reveal in Finder
        test=report.createTest("Verify page title"); //must add this every test at the beginning
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        test.info("Login as store manager");  // like system out.
        //loginPage.login("storemanager85","UserUser123"); you can also do that because it is constructor, you can initialize here as well
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard was verified");
    }
    // wrong username and password and get warning message verify
    @Test
    public void verifyWarningMessage(){
        test=report.createTest("Verify warning message");

        LoginPage loginPage=new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
       //takes screenShot
        BrowserUtils.getScreenshot("warning_message");

        test.pass("warning message is displayed"); // this will show up if assertion pass correct if it fails will go to AfterMethod
    }

    //this is how you connect DataProvider with login
    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) {      //this will run 3 times : because u have 3 username and password in Data Driven Below
        test = report.createTest("Verify page title"+userName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " + userName);//log some steps
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");
    }

     //this is a test data
    //creating Data Driven. If it is 1 colum [], if there are more than 2 colum [] []. It is a table
    @DataProvider
    public Object[][] credentials(){  // it can return single or 2D object or iterator
        return new Object[][]{
                {"storemanager85", "UserUser123"},  // provided username and password. it means test will be running 3 times
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"},
        };
    }
    // Read data from excel file

    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel(String execute, String username, String password, String firstname, String lastname, String result){
        test=report.createTest("Login test for: "+username);
        if(execute.equals("y")){
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as " + username);//log some steps
            test.pass("Successfully logged in as "+username);
            test.info(String.format("First name: %s, Last name %s, User name %s", firstname,lastname,username));
        }else{
            test.skip("Test was skipped for user: "+username);
            throw  new SkipException("test was skipped "+ username);
        }


    }

    //read from excell file and get user name and password
    @DataProvider
    public  Object [][] credentialsFromExcel(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        //execute

        return excelUtil.getDataArray(); // this data will pass into test, injected into our test
    }
}
