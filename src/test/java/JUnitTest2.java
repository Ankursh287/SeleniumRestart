import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest2 {
    static WebDriver driver;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        System.out.println("Executed before Class..");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.letskodeit.com/");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(5000);
        System.out.println("Executed after Class..");
        driver.quit();
    }


    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("PRACTICE")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//a[@href='/practice']")).click();
        //driver.findElement(By.xpath("//a[@href='/login']")).click();
        WebElement nameField = driver.findElement(By.xpath("//input[@id='email' and @placeholder='Email Address']"));
        nameField.clear();
        nameField.sendKeys("test@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordField.clear();
        passwordField.sendKeys("Test");
        nameField.clear();
        passwordField.clear();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().forward();
    }

}
