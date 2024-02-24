import Utils.GenericMethods;
import Utils.WaitTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Random;
import java.util.Set;

public class JUnitTest6 {
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
       // driver.manage().window().maximize();
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
        WebElement iframe;
        iframe = driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame("courses-iframe");
        //driver.switchTo().frame("iframe-name");

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Course']"));
        searchBox.sendKeys("python");

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");
        Thread.sleep(2000);
    }
}
