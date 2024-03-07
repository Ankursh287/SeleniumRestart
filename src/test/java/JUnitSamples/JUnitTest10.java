package JUnitSamples;

import Utils.GenericMethods;
import Utils.WaitTypes;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.Random;

public class JUnitTest10 {
    private WebDriver driver;
    private GenericMethods gm;
    private WaitTypes wt;
    private JavascriptExecutor js;

    @Before
    public void setup() throws Exception {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
    }

    @After
    public void tearDown() throws Exception {
        Random rand = new Random();
        String filename = rand.nextInt(5) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test2() throws Exception {
        WebElement signIn = driver.findElement(By.xpath("//a[text()='Sign In']"));
        signIn.click();

        WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        emailAddress.sendKeys(Keys.SHIFT + "test@email.com");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(Keys.SHIFT + "test@email.com" + Keys.ENTER);

        Thread.sleep(2000);

    }
}
