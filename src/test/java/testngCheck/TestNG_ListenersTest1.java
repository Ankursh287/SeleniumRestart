package testngCheck;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(CustomListeners1.class)
public class TestNG_ListenersTest1 {
    @BeforeClass
    public void setUp(){
        System.out.println("Code in Before Class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("Code in After Class");
    }

    @Test
    public void testMethod1(){
        System.out.println("Code in Test Method#1");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod2(){
        System.out.println("Code in Test Method#2");
        Assert.assertTrue(false);
    }
}
