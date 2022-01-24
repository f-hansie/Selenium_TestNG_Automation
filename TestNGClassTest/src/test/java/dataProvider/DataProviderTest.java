package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "data-set")
    public static Object [][] DataSet(){

        Object [][] obj = {{1,2,3},{"test1","test2","test3"}};

        return obj;
    }

    @Test(dataProvider = "data-set")
    public void DataProvideSampleTest(Object obj1, Object obj2, Object obj3){

        System.out.println(obj1 +  " " + obj2 +  " " + obj3);


    }


}
