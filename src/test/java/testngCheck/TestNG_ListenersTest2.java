package testngCheck;

import Utils.CustomListeners1;
import Utils.CustomListeners2;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners2.class)
public class TestNG_ListenersTest2 {
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
