package JUnitSamples;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest1 {
    static WebDriver driver;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        System.out.println("Executed before Class..");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Executed after Class..");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Executed before Method..");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Executed after Method..");
    }

    @Test
    public void test1() throws Exception {
        System.out.println("Test Method#1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("Test Method#1");
    }
}
