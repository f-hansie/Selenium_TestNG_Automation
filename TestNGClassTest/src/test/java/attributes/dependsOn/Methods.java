package attributes.dependsOn;

import org.testng.annotations.Test;

public class Methods {

    @Test
    public void LoginTest(){

        System.out.println("Test: test case 01");

    }

    @Test(dependsOnMethods = "LoginTest")
    public void tc_02(){

        System.out.println("Test: test case 02");
    }

    @Test(dependsOnMethods = "tc_02")
    public void tc_03(){

        System.out.println("Test: test case 03");
    }

    @Test(dependsOnMethods = "tc_03")
    public void tc_04(){

        System.out.println("Test: test case 04");
    }
}
