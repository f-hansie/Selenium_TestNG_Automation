package dataProvider;

import org.testng.annotations.Test;

public class DataProviderTest2 {

    // calling the data provider test class on another class
    @Test(dataProvider = "data-set",dataProviderClass = DataProviderTest.class)
    public void DataProvideSampleTest(Object obj1, Object obj2, Object obj3){

        System.out.println(obj1 +  " " + obj2 +  " " + obj3);


    }
}
