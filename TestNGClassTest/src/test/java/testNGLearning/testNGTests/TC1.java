package testNGLearning.testNGTests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends BasePage {



    @Test
    public void testPageTitle(){

        driver.navigate().to("http://www.google.com");
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
    }

    @Test
    public void tc_report(){

        System.out.println("Test: testcase report logic");
    }
}
