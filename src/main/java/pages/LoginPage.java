package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {

    @FindBy(name="user-name")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginBtn;


    //Initializing the Page Objects:
    public LoginPage() {
        super(driver);
        PageFactory.initElements(driver, this);
    }


@Test
    public void validLogin() throws InterruptedException {
    Thread.sleep(3000);
    username.click();
    driver.get(prop.getProperty("username"));
    password.click();
    driver.get(prop.getProperty("password"));
    }
    }