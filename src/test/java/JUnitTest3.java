import Utils.GenericMethods;
import Utils.WaitTypes;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest3 {
    private WebDriver driver;
    private GenericMethods gm;
    private WaitTypes wt;

    @Before
    public void setup() throws Exception {
        System.out.println("Executed before Class..");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.google.com/");
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        System.out.println("Executed after Class..");
        driver.quit();
    }


    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");
//      WebElement searchBox = driver.findElement(By.xpath("//textarea[@title='Search']"));
        // WebElement textGmail = driver.findElement(By.xpath("//a[text()='Gmail']"));
        // String nameOfElement = textGmail.getText();
        // WebElement attributeOfGoogleImage = driver.findElement(By.xpath("//img[@alt='Google']"));
        System.out.println("Attribute of WebElement is: " + gm.getElement("//img[@alt='Google']", "xpath").getAttribute("src"));
        gm.waitForElement(By.xpath("//a[@aria-label=\"Google apps\"]"), 3).click();
        gm.clickWhenReady(By.xpath("//a[@aria-label=\"Google apps\"]"), 3);
        System.out.println("Is WebElement present?: " + gm.isElementPresent("source", "tagName"));
        System.out.println("Is WebElement present?: " + gm.isElementPresent("img", "tagName"));

        // System.out.println(attributeOfGoogleImage.getAttribute("src"));
        // System.out.println("nameOfElement : " + nameOfElement);
        // WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        // searchBox.sendKeys("LetsKodeit" + Keys.ENTER);
    }

}
