package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {

    @FindBy(xpath="//input[@id='user-name']")
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



    public void validLogin(String un, String pwd) throws InterruptedException {

    Thread.sleep(3000);
     username.click();
     username.sendKeys(un);
     password.click();
     password.sendKeys(pwd);

    }
    }