package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.logs.Log;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver","src/test/resources/browsers/chromedriver97");
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        Log.info("Closing the page");
        driver.quit();
    }
}
