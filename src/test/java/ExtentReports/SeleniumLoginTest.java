package ExtentReports;

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
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        baseURL = "https://www.letskodeit.com/";
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
        WebElement welcomeText = driver.findElement(By.cssSelector("#incorrectdetails"));
        Assert.assertNotNull(welcomeText);
        System.out.println("Login Successful");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
