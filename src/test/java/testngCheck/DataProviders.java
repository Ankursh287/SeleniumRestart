package testngCheck;

import org.testng.annotations.*;

@Test()
public class DataProviders {
    @Test(dataProvider = "inputs")
    public void testMethod1(String input1, String input2) {
        System.out.println("Value of Input1 : " + input1);
        System.out.println("Value of Input2 : " + input2);
    }

    @DataProvider(name = "inputs")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"bmw","m5"},
                {"audi","a8"},
                {"mercedes","s500"}
        };
    }
}