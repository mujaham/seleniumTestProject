package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver=null;

    public static Properties prop;

        @BeforeMethod
        public static void initialization () {
            String browserName = "chrome";
            if (browserName.equals("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get("https://www.bayt.com/");
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            }
        }

        public static void resizeWindow(){
                int width = 320;
                int height = 568;
                Dimension dimension = new Dimension(width, height);
                driver.manage().window().setSize(dimension);
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }

        public static void waitForElement(WebElement locator){
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(locator));
        }

        public static void switchWindowHandles(){
            Set<String> windows= driver.getWindowHandles();
            Iterator<String> it= windows.iterator();
            String parentId=it.next();
            String childId=it.next();
            driver.switchTo().window(childId);
        }

        public static void fluentWaitForElementLoad(WebElement element){
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementClickInterceptedException.class);
            wait.until(driver -> {
                return element;});
        }


        public static void uploadFileInput(String filePath){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('fileUpload').style.display = 'block';");
            driver.findElement(By.id("fileUpload")).sendKeys(filePath);
            js.executeScript("document.getElementById('fileUpload').style.display = 'none';");
        }

        public static void scrollToBottomOfPage(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        }

    public static void scrollToElement(WebElement loc){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loc);
    }

    public static void uploadFileSimple(String filePath){
            driver.findElement(By.id("fileUpload")).sendKeys(filePath);
    }

    public static void launchUrl(){
        driver.get("https://www.bayt.com/en/login/");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public static void capture(WebDriver driver) throws IOException {
//        TakesScreenshot ts=(TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String destinationPath=System.getProperty("user.dir")+"/TestReport/screenshots/"+"screenShotName"+".png";
//        File destination=new File(destinationPath);
//        FileHandler.copy(source, destination);
//        String[] relatvePath = destination.toString().split("Report");
//        destinationPath = ".\\" + relatvePath[1];
//        System.out.println(destinationPath);
//    }


    @AfterMethod
    public static void wrapUp () {
            driver.quit();
    }


//    @AfterClass
//    public static void quit () {
//            driver.quit();
//        }

}

