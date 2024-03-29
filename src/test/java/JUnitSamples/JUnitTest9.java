package JUnitSamples;

import Utils.GenericMethods;
import Utils.WaitTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.Random;

public class JUnitTest9 {
    private WebDriver driver;
    private GenericMethods gm;
    private WaitTypes wt;
    private JavascriptExecutor js;

    @Before
    public void setup() throws Exception {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://jqueryui.com/slider/");
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
    public void test2() throws Exception {
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
        //WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        //1st way
//        actions.clickAndHold(slider).moveToLocation(10,0).build().perform();
        //2nd way
        actions.dragAndDropBy(slider, 100, 0).build().perform();

        Thread.sleep(2000);
    }
}
