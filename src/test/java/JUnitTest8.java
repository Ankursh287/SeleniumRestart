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

public class JUnitTest8 {
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

    /*@Test
    public void test1() throws Exception {
        js.executeScript("window.scrollBy(0,600)");
        WebElement mouseHover = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover).perform();
        WebElement topElement = driver.findElement(By.xpath("//a[@href='#top']"));
        actions.moveToElement(topElement).click().perform();
    }*/
    @Test
    public void test2() throws Exception {
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        //1st way
        actions.clickAndHold().dragAndDrop(draggable, droppable).build().perform();
        //2nd way
        actions.dragAndDrop(draggable, droppable).build().perform();
    }
}
