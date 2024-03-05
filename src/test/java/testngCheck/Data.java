package testngCheck;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class Data {
    @DataProvider(name = "inputs")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"bmw","m5"},
                {"audi","a8"},
                {"mercedes","s500"}
        };
    }
}