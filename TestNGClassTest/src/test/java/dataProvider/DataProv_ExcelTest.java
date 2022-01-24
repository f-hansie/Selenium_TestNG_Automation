//package dataProvider;
//
//
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//
//public class DataProv_ExcelTest {
//
//    public WebDriver driver;
//    public WebDriverWait wait;
//    String appURL = "https://www.saucedemo.com/";
//
//    //Locators
//    private By byUsername = By.id("user-name");
//    private By byPassword = By.id("password");
//    private By byLoginBtn = By.id("login-button");
//    private By byError = By.id("global-alert-queue");
//
//    @BeforeClass
//    public void testSetup() {
//        System.setProperty("webdriver.chrome.driver","src/test/resources/browsers/chromedriver96");
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, 5);
//    }
//
//
//    @Test(dataProvider="empLogin")
//    public void VerifyInvalidLogin(String userName, String password) {
//        driver.navigate().to(appURL);
//        driver.findElement(byUsername).sendKeys(userName);
//        driver.findElement(byPassword).sendKeys(password);
//        //wait for element to be visible and perform click
//        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn));
//        driver.findElement(byLoginBtn).click();
//
//        //Check for error message
//        wait.until(ExpectedConditions.presenceOfElementLocated(byError));
//        String actualErrorDisplayed = driver.findElement(byError).getText();
//        String requiredErrorMessage = "Please correct the marked field(s) below.";
//        Assert.assertEquals(requiredErrorMessage, actualErrorDisplayed);
//
//    }
//
//    @DataProvider(name="empLogin")
//    public Object[][] loginData() {
//
//        Object[][] arrayObject = getExcelData("TestData","Sheet 1");
//        return arrayObject;
//    }
//
//    /**
//     * @param "File Name"
//     * @param "Sheet Name"
//     * @return
//     */
//    public String[][] getExcelData(String fileName, String sheetName) {
//
//        String filePath = System.getProperty("user.dir")+"/Users/hansiemaphanga/Documents";
//        File file =    new File(filePath+"/"+fileName);
//
//        String[][] arrayExcelData = null;
//        try {
//            FileInputStream fs = new FileInputStream(file);
//            Workbook wb = Workbook.getWorkbook(fs);
//
//            Sheet sh = wb.getSheet(sheetName);
//
//            int totalNoOfCols = sh.getColumns();
//            int totalNoOfRows = sh.getRows();
//
//            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
//
//            for (int i= 1 ; i < totalNoOfRows; i++) {
//
//                for (int j=0; j < totalNoOfCols; j++) {
//                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
//                }
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
//        return arrayExcelData;
//    }
//
//    @Test
//    public void tearDown() {
//        driver.quit();
//    }
//}
