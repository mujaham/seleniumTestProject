package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage login = new LoginPage();

    public LoginTest() {
        super(driver);
    }
    @Test
    public void userLogin() throws InterruptedException {
        login.validLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
}
