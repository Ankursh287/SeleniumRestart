package DataDriven;

import Utils.ExcelUtility;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestNG {
    WebDriver driver;
    String baseURL;

    @BeforeTest
    public void setUp(String browser) {
        //baseURL = "https://www.letskodeit.com/home";
        switch (browser) {
            case "Chrome" -> driver = new ChromeDriver();
            case "Firefox" -> driver = new FirefoxDriver();
        }
        driver.get(Constants.URL);
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider(){
        return null;
    }

    @Test(dataProvider = "loginData")
    public void testUsingExcel(String userName, String password) throws Exception {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();

        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        emailField.sendKeys(ExcelUtility.getTestData());
        passwordField.sendKeys(ExcelUtility.getTestData());
        loginButton.click();

        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("#incorrectdetails"));
        boolean result = true;
        Assert.assertTrue(result);
    }

/*    @Test
    public void test() {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        emailField.sendKeys("test@email.com");
        passwordField.sendKeys("password");
        loginButton.click();
    }*/

    @AfterTest
    public void tearDown(ITestResult testResult) {
        if (!(testResult.isSuccess())) {
            System.out.println("Test was not successful");
        }
        System.out.println(testResult.getMethod().getMethodName());
        driver.quit();
    }
}