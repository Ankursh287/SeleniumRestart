import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest3 {
    static WebDriver driver;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        System.out.println("Executed before Class..");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.google.com/");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(2000);
        System.out.println("Executed after Class..");
        driver.quit();
    }


    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");
//        WebElement searchBox = driver.findElement(By.xpath("//textarea[@title='Search']"));
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("LetsKodeit" + Keys.ENTER);
    }

}
