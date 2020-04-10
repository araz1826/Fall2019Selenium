package test;

import Pages.LoginPage;
import org.testng.annotations.Test;

// Object repository is same as your page classes
public class NewVehiclesTests extends AbstractTestBase {

@Test
public void verifyTitle(){
LoginPage loginPage = new LoginPage();


loginPage.login();

}


}
