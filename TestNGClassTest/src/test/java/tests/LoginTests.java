package tests;

import static utils.extentReports.ExtentTestManager.startTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.excelUtils.ExcelUtil;
import utils.logs.Log;

public class LoginTests extends BaseTest{

    @BeforeTest
    public void setupTestData() throws IOException {
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        Log.info(method.getName() + " test is starting.");

        homePage
                .goToN11()
                .goToLoginPage()
                .loginToN11WithExcelData(ExcelUtil.getRowData(1))
                .verifyLogError()
                .saveTestResults(1, 5);
    }

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
        Log.info(method.getName() + " test is starting.");

        homePage
                .goToN11()
                .goToLoginPage()
                .loginToN11WithExcelData(ExcelUtil.getRowData(2))
                .verifyLoginUserName(ExcelUtil.getCellData(2, 3))
                .verifyLoginPassword(ExcelUtil.getCellData(2, 4))
                .saveTestResults(2, 5);
    }

//    @Test(priority = 0, description = "Valid Login Scenario with valid username and password.")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test Description: Login test with valid username and valid password.")
//    @Story("Valid username and password login test")
//    public void validLoginTest_ValidUserAndValidPassword(Method method) {
//        //ExtentReports Description
//        startTest(method.getName(), "Valid Login Scenario with valid username and password.");
//        Log.info(method.getName() + " test is starting.");
//
//        homePage
//                .goToN11()
//                .goToLoginPage()
//                .loginToN11WithExcelData(ExcelUtil.getRowData(3))
//                .verifyValidUserNameAndPassword(ExcelUtil.getCellData(3, 1))
//                .verifyValidUserNameAndPassword(ExcelUtil.getCellData(3, 2))
//                .saveTestResults(3, 5);
//    }
}
