package ExtentReports;

import Utils.Screenshots;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumLoginTestWithScreenshot {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        baseUrl = "http://www.letskodeit.com/";
        report = new ExtentReports(System.getProperty("user.dir") + "\\screenshots\\logintest.html");
        test = report.startTest("Verify Welcome Test");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO, "Browser Started..");
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Home Page opened up..");
    }

    @Test
    public void test() {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();
        test.log(LogStatus.INFO, "loginLink clicked..");
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        emailField.sendKeys("test@email.com");
        test.log(LogStatus.INFO, "email ID entered in field..");
        passwordField.sendKeys("password");
        test.log(LogStatus.INFO, "password entered in field..");
        loginButton.click();
        test.log(LogStatus.INFO, "login button clicked..");
        WebElement welcomeText = driver.findElement(By.cssSelector("#incorrectdetails"));
        Assert.assertNotNull(welcomeText);
        test.log(LogStatus.PASS, "Assertion completed and Success Message printed..");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.PASS, "Verify Welcome Text Failed", imagePath);
        }
        driver.quit();
        report.endTest(test);
        report.flush();
    }


    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String listOfCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * listOfCharacters.length());
            sb.append(listOfCharacters.charAt(index));
        }
        return sb.toString();
    }
}
