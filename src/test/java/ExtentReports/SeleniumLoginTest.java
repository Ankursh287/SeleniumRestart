package ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumLoginTest {
    WebDriver driver;
    String baseURL;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        report = new ExtentReports(System.getProperty("user.dir") + "\\screenshots\\logintest.html");
        test = report.startTest("Verify Welcome Test");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO, "Browser Started..");
        baseURL = "https://www.letskodeit.com/";
        driver.get(baseURL);
        test.log(LogStatus.INFO, "Home Page opened up..");
    }

    @Test
    public void test() {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        emailField.sendKeys("test@email.com");
        passwordField.sendKeys("password");
        loginButton.click();
        WebElement welcomeText = driver.findElement(By.cssSelector("#incorrectdetails"));
        Assert.assertNotNull(welcomeText);
        System.out.println("Login Successful");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
