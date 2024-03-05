package testngCheck;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class DataProviders1 {
    @Test(dataProvider = "inputs",dataProviderClass = Data.class)
    public void testMethod1(String input1, String input2) {
        System.out.println("Value of Input1 : " + input1);
        System.out.println("Value of Input2 : " + input2);
    }
}