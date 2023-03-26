package testcases;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
//    @Test
//    public void userLogin()  {
//        LoginPage login=new LoginPage();
//        login.ContactTestData();
//
//    }

    @Test(priority = 1)
    public static void registerUserPart1() throws InterruptedException {
        LoginPage login=new LoginPage();
        login.userRegistration();
    }

    @Test (priority = 2, dependsOnMethods={"registerUserPart1"})
    public static void deleteUserPart2() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.deleteUserFlow();
    }

    @Test(priority = 3)
    public static void mobileSiteCasePart3() throws InterruptedException {
        LoginPage login=new LoginPage();
        login.resizeSearchAndApply();
    }

}
