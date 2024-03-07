package testngCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_ITestResultDemo {

    @Test
    public void test1() {
        System.out.println("Running -> testMethod1");
        Assert.assertTrue(false);
    }

    @Test
    public void test2() {
        System.out.println("Running -> testMethod2");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
      if (!(testResult.isSuccess())) {
            System.out.println("Reporting via isSuccess() method --> Test was not successful ");
        }
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Reporting FAILURE via getSuccess method --> Test was not successful " + testResult.getMethod().getMethodName());
        }
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Reporting SUCCESS via getSuccess method --> Test was not successful " + testResult.getName());
        }
    }
}
