package DataDriven;

import org.testng.annotations.Test;
import testngCheck.Data;

@Test()
public class DataProviders1 {
    @Test(dataProvider = "inputs",dataProviderClass = Data.class)
    public void testMethod1(String input1, String input2) {
        System.out.println("Value of Input1 : " + input1);
        System.out.println("Value of Input2 : " + input2);
    }
}