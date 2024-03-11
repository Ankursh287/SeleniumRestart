package ExtentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*import com.relevantcodes.extentreports.ExtentTest;*/
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumLoginTestWithAventstackExtentReports {
    WebDriver driver;
    String baseURL;
    ExtentReports report;
    ExtentSparkReporter spark;
    ExtentTest test;
    @BeforeClass
    public void beforeClass() {
        report = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\screenshots\\logintest.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Reports Demo");
        report.attachReporter(spark);
        test = report.createTest("Verify Welcome Test");
        driver = new ChromeDriver();
        test.log(Status.INFO,"Browser Started..");
        baseURL = "https://www.letskodeit.com/";
        driver.get(baseURL);
        test.log(Status.INFO, "Home Page opened up..");
    }

    @Test
    public void test() {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();
        test.log(Status.INFO, "loginLink clicked..");
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        emailField.sendKeys("test@email.com");
        test.log(Status.INFO, "email ID entered in field..");
        passwordField.sendKeys("password");
        test.log(Status.INFO, "password entered in field..");
        loginButton.click();
        test.log(Status.INFO, "login button clicked..");
        WebElement welcomeText = driver.findElement(By.cssSelector("#incorrectdetails"));
        Assert.assertNotNull(welcomeText);
        test.log(Status.INFO, "Assertion completed and Success Message printed..");
    }

    @AfterTest
    public void tearDown() throws IOException {
            String filename = getRandomString(10) + ".png";
            String directory = System.getProperty("user.dir") + "\\screenshots\\";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(directory + filename);
            FileUtils.copyFile(sourceFile, destinationFile);
           // test.pass(MediaEntityBuilder.createScreenCaptureFromPath(directory+filename))
            test.pass( MediaEntityBuilder.createScreenCaptureFromPath(directory+filename).build());
        test.pass( MediaEntityBuilder.createScreenCaptureFromBase64String(directory+filename).build());
        driver.quit();
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
