package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;


public class HomePage extends BasePage {

    /**Constructor*/
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**Variables*/
    String baseURL = "http://www.n11.com/";


    /**Web Elements*/
    By signInButtonClass = By.className("btnSignIn");

    /**Page Methods*/
    //Go to Homepage
    @Step("Open N11 Step...")
    public HomePage goToN11() {
        Log.info("Opening N11 Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public LoginPage goToLoginPage() {
        Log.info("Going to Login Page..");
        click(signInButtonClass);
        return new LoginPage(driver);
    }
}
