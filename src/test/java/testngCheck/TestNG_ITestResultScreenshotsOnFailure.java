package testngCheck;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestNG_ITestResultScreenshotsOnFailure {
    WebDriver driver;
    String baseURL;

    @BeforeTest
    public void setUp() {
        baseURL = "https://www.letskodeit.com/home";
        driver = new ChromeDriver();
        driver.get(baseURL);
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
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Failed: " + testResult.getName());
            String filename = getRandomString(10) + ".jpg";
            String directory = System.getProperty("user.dir") + "//screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + filename));
        }
        driver.quit();
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
