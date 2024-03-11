package ExtentReports;

import Utils.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;
    String baseURL;
    ExtentTest test;
    ExtentSparkReporter spark;
    ExtentReports reports;

    @BeforeClass
    public void beforeClass() {
        baseURL = "http://www.letskodeit.com";
        driver = new ChromeDriver();
        spark = ExtentFactory.Instance2();
        reports.attachReporter(spark);
        test.log(Status.INFO, "Browser Started..");
        driver.get(baseURL);
        test.log(Status.INFO, "Web Application opened");
    }

    @Test
    public void test1_validationLoginTest() throws Exception {
        WebElement signInLink = driver.findElement(By.xpath("//a[text()='Sign In']"));
        test.log(Status.INFO, "Clicked on Sign in link");
        signInLink.click();
        /*Thread.sleep(2000);*/


        WebElement emailId = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        emailId.sendKeys("test@email.com");
        test.log(Status.INFO, "Enter User Id");
        /*Thread.sleep(2000);*/

        WebElement passwordId = driver.findElement(By.cssSelector("#login-password"));
        passwordId.sendKeys("test");
        test.log(Status.INFO, "Enter password");
        /*Thread.sleep(2000);*/

        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        loginButton.click();
        test.log(Status.INFO, "Clicked Login button");
        /*Thread.sleep(2000);*/

        Thread.sleep(3000);

        WebElement actualErrortext = driver.findElement(By.cssSelector("#incorrectdetails"));
        String desiredErrorText = actualErrortext.getText();
        //System.out.println("Error Message is : " + desiredErrorText);
        Assert.assertEquals(actualErrortext.getText(), "Incorrect login details. Please try again.", "Strings matched");
        test.log(Status.PASS, "Error Messages matched");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        reports.flush();
    }
}
