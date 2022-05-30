package base;

//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;


    public BaseTest(WebDriver driver){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream( "C:\\Users\\VenD\\Documents\\SeleniumTestProject\\src\\main\\java\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }}


@BeforeClass
        public static void initialization() {
            String browserName = prop.getProperty("browser");

            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\VenD\\Documents\\SeleniumTestProject\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(prop.getProperty("url"));

            }

        }
        @AfterClass
    public static void quit(){
        driver.quit();
        }


}

