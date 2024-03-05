package JUnitSamples;

import Utils.GenericMethods;
import Utils.WaitTypes;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Random;
import java.util.Set;

public class JUnitTest5 {
    private WebDriver driver;
    private GenericMethods gm;
    private WaitTypes wt;
    private JavascriptExecutor js;

    @Before
    public void setup() throws Exception {
        System.out.println("Executed before Test Method..");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        js.executeScript("window.location='https://www.letskodeit.com/practice'");
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
        System.out.println("Executed after Test Method..");
        driver.quit();
    }


    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");

        //Get the handle
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);

        //Find Open Window button
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();

        //Get all Handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        //Switching between handles
        for (String handle : allWindowHandles) {
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Course']"));
                searchBox.sendKeys("python");
                Thread.sleep(2000);
                driver.close();
                break;
            }
        }

        //Switch back to parent window
        driver.switchTo().window(parentHandle);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("name");
        Thread.sleep(2000);
    }

}
