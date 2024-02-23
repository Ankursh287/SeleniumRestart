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

public class JUnitTest4 {
    private WebDriver driver;
    private GenericMethods gm;
    private WaitTypes wt;
    private JavascriptExecutor js;

    @Before
    public void setup() throws Exception {
        System.out.println("Executed before Class..");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();
        //driver.get("https://www.letskodeit.com/practice");
        js.executeScript("window.location = 'https://www.letskodeit.com/practice'");//Using JavascriptExecutor to open page rather than driver.get() method
    }

    @After
    public void tearDown() throws Exception {
        Random rand = new Random();
        String filename = rand.nextInt(5) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        Thread.sleep(2000);
        System.out.println("Executed after Class..");
        driver.quit();
    }


    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");
        WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name')");
        textBox.sendKeys("test");

        long height = (long) js.executeScript("return window.innerHeight;");
        long width = (long) js.executeScript("return window.innerWidth;");

        System.out.println("Height is : " + height + " & Width is : " + width);

        //Scroll Down
        js.executeScript("window.scrollBy(0,1031);");
        Thread.sleep(3000);
        //Scroll Top
        js.executeScript("window.scrollBy(0,-1031);");
        Thread.sleep(3000);
        //Scroll Element into View
        WebElement element = (WebElement) js.executeScript("return document.getElementById('mousehover');");
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-190);");
        Thread.sleep(3000);


    }

}
