import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class JUnitTest {
    static WebDriver driver;
    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://chromedriver.chromium.org/home");
        Thread.sleep(2000);
        driver.get("https://www.letskodeit.com/");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Executed after Class..");
        driver.quit();
    }

/*    @Before
    public void setUp() throws Exception {
        System.out.println("Executed before Method..");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Executed after Method..");
    }*/

    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("PRACTICE")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/practice']")).click();
    }

/*    @Test
    public void test2() throws Exception {
        System.out.println("Test Method#1");
    }*/
}
