package testngCheck;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class TestNG_ReportersAndLogs {
    @BeforeClass
    public void setUp() {
        //System.out.println("TestNG_ReportersAndLogs -> This runs once before class");
        Reporter.log("TestNG_ReportersAndLogs -> This runs once before class", true);
    }

    @AfterClass
    public void cleanUp() {
        //System.out.println("TestNG_ReportersAndLogs -> This runs once after class");
        Reporter.log("TestNG_ReportersAndLogs -> This runs once after class",true);
    }

    @BeforeMethod
    public void beforeMethod() {
        //System.out.println("TestNG_ReportersAndLogs -> This runs once before every Method");
        Reporter.log("TestNG_ReportersAndLogs -> This runs once before every Method",true);
    }

    @AfterMethod
    public void AfterMethod() {
        //System.out.println("TestNG_ReportersAndLogs -> This runs once after every Method");
        Reporter.log("TestNG_ReportersAndLogs -> This runs once after every Method",true);
    }

    @Test
    public void testMethod1() {
        Reporter.log("TestNG_ReportersAndLogs -> testMethod1",true);
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod2() {
        Reporter.log("TestNG_ReportersAndLogs -> testMethod2",true);
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "testMethod2")
    public void testMethod3() {
        Reporter.log("TestNG_ReportersAndLogs -> testMethod3",true);
        Assert.assertTrue(true);
    }
}
