package JUnitSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    public static void main(String[] args) throws InterruptedException {
       // System.setProperty("webdriver.chromedriver", "C:\\Users\\ankur\\Documents\\Code\\Selenium\\libs\\drivers\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://chromedriver.chromium.org/home");
        Thread.sleep(2000);
        driver.get("https://www.letskodeit.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("PRACTICE")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/practice']")).click();
        driver.quit();
    }
}
