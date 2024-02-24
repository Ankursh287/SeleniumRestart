import Utils.GenericMethods;
import Utils.WaitTypes;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Random;

public class JUnitTest7 {
    private WebDriver driver;
    private GenericMethods gm;
    private WaitTypes wt;
    private JavascriptExecutor js;

    @Before
    public void setup() throws Exception {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://www.letskodeit.com/practice'");
        //driver.get("https://www.letskodeit.com/practice");
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
        // FileUtils.copyFile(sourceFile, new File(directory + filename));
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws Exception {
        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
        WebElement nameField = driver.findElement(By.id("name"));
        alertButton.click();
        Thread.sleep(2000);
        Alert a = driver.switchTo().alert();
        a.accept();
        confirmButton.click();
        Alert c = driver.switchTo().alert();
        c.dismiss();
        nameField.sendKeys("Test Successful");
    }
}
