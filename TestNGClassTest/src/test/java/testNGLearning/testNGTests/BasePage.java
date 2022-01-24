package testNGLearning.testNGTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage {

    WebDriver driver;

    @BeforeMethod
    public void OpenAuth(){

        System.out.println("BeforeMethod: open the auth");
    }

    @AfterMethod
    public void CloseAuth(){

        System.out.println("AfterMethod: close auth");
    }

    @BeforeClass
    public void OpenBrowser(){

        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver","src/test/resources/browsers/chromedriver97");
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){

        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }
}
