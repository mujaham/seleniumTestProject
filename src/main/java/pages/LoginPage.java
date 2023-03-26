package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseTest {

    static JavascriptExecutor executor = (JavascriptExecutor)driver;
    static String email;
    static String password = "R108testuser";
    public LoginPage() {
    }

//    public static void ContactTestData(){
////        driver.findElement(By.id("contact-link")).click();
////        Select selector = new Select(driver.findElement(By.id("id_contact")));
////        selector.selectByIndex(2);
////        driver.findElement(By.id("email")).sendKeys("test@toptal.com");
////        driver.findElement(By.id("id_order")).sendKeys("R108");
////        driver.findElement(By.id("fileUpload")).sendKeys("/Users/vend/Downloads/image.png");
////        driver.findElement(By.id("message")).sendKeys("Complaint about order R108");
////        driver.findElement(By.id("submitMessage")).click();
////        BaseTest.waitForElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")));
////        String message = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
////        Assert.assertEquals(message, "Your message has been successfully sent to our team.");
//
//    }


    public static void userRegistration() throws InterruptedException {
        BaseTest.scrollToBottomOfPage();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'About Us')]"))));
        driver.findElement(By.xpath("//*[contains(text(),'About Us')]")).click();
        WebElement cardList = driver.findElement(By.xpath("//div[@class='card-head']//child::a"));
        BaseTest.scrollToElement(cardList);
        executor.executeScript("arguments[0].click();", cardList);
        BaseTest.switchWindowHandles();
        driver.findElement(By.id("applyButton")).click();
        fillForm();
        verifyMsgDisplayed();
    }

    public static void resizeSearchAndApply() throws InterruptedException {
        BaseTest.resizeWindow();
        driver.findElement(By.id("text_search1")).click();
        driver.findElement(By.xpath("//div[12]/div[1]/div[2]/div/input")).sendKeys("Quality Assurance Engineer");
        driver.findElement(By.xpath("//li[@data-text='quality assurance engineer']")).click();
        driver.findElement(By.id("search_icon_submit_1")).click();
        Thread.sleep(4000);
        BaseTest.scrollToElement(driver.findElement(By.xpath("//a[contains(text(),'Easy apply')]")));
        JavascriptExecutor ext = (JavascriptExecutor)driver;
        ext.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[contains(text(),'Easy apply')]")));
        Assert.assertEquals(driver.getTitle(), "Job Seeker Sign up - Bayt.com");
    }

    public static void deleteUserFlow() throws InterruptedException {
        BaseTest.launchUrl();
        driver.findElement(By.id("LoginForm_username")).sendKeys(email);
        driver.findElement(By.id("LoginForm_password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        verifyMsgDisplayed();
        driver.findElement(By.xpath("//*[@class='icon is-ellipsis-v']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Account Settings')]")).click();
        WebElement deleteAccount = driver.findElement(By.xpath("//a[contains(text(),'Delete My Account')]"));
        BaseTest.scrollToElement(driver.findElement(By.xpath("//*[contains(text(),'Delete My Account')]")));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", deleteAccount);
        driver.findElement(By.xpath("//button[@class='btn is-danger']")).click();
        driver.findElement(By.xpath("//div[@class='modal-dialog has-attachments']//child::button[contains(text(),'Yes')]")).click();
        verifyLoginButtonIsDisplayed();
        Thread.sleep(4000);
    }

    public static void fillForm() throws InterruptedException {
        BaseTest.waitForElement(driver.findElement(By.xpath("//input[@id='JsApplicantRegisterForm_firstName']")));
        Random random = new Random();
        int x = random.nextInt(500);
        email = "testuserbayt"+ x +"@gmail.com";
        password = "R108testuser";
        driver.findElement(By.xpath("//input[@id='JsApplicantRegisterForm_firstName']")).sendKeys("Testuser");
        driver.findElement(By.id("JsApplicantRegisterForm_lastName")).sendKeys("Bayt");
        driver.findElement(By.id("JsApplicantRegisterForm_email")).sendKeys(email);
        driver.findElement(By.id("JsApplicantRegisterForm_password")).sendKeys(password);
        driver.findElement(By.id("JsApplicantRegisterForm_mobPhone")).sendKeys("3012345678");
        scrollToElement(driver.findElement(By.id("register")));
        WebElement registerBtn = driver.findElement(By.id("register"));
        executor.executeScript("arguments[0].click();", registerBtn);
    }

    public static void verifyMsgDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='msg is-warning ']")).isDisplayed());
    }

    public static void verifyLoginButtonIsDisplayed(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        BaseTest.waitForElement(driver.findElement(By.xpath("//a[contains(text(),'Log In')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).isDisplayed());
    }

}


