package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProv_SeleniumTest {

    WebDriver driver;

    @DataProvider(name = "data-set")
    public static Object [][] DataSet(){

        Object [][] obj = {

                {"valid","standard_user","secret_sauce"},
                {"invalid","standard_user","1234"}
                };

        return obj;
    }

    @Test(dataProvider = "data-set")
    public void DataProvideSampleTest(String type, String username, String password) throws InterruptedException {

        System.out.println(type + "" +  username + " " +  password);
        //get chrome driver location
        System.setProperty("webdriver.chrome.driver","src/test/resources/browsers/chromedriver97");

        driver = new ChromeDriver();
        //wait or delay method
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("*******************");
        System.out.println("launching chrome browser");
        driver.manage().window().maximize();
        driver.navigate().to("http://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        if(type.equals("valid")){

             wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='title']")));

        }else{

              wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));

              Thread.sleep(2000);
              driver.quit();
        }

    }
}
