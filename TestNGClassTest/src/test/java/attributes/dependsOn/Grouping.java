package attributes.dependsOn;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Grouping {

    @Test(groups = "loginTest")
    public void LoginTest(){

        System.out.println("Test: test case 01" );

        throw new SkipException("skipped test");
    }

    @Test(groups = "account")
    public void AccountTest(){

        System.out.println("Test: test case account");

    }

    @Test(dependsOnGroups = {"loginTest","account"} , groups = {"tc03"})
    public void tc_03(){

        System.out.println("Test: test case 03");
    }

    @Test(dependsOnGroups = {"loginTest","account"}, groups = {"tc4"})
    public void tc_04(){

        System.out.println("Test: test case 04");
    }

    @Test(dependsOnGroups = {"loginTest","account"}, groups = {"tc05"})
    public void tc_05(){

        System.out.println("Test: test case 05");
    }
}
