import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver", "C:\\Users\\ankur\\Documents\\Code\\Selenium\\libs\\drivers\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://chromedriver.chromium.org/home");
        driver.close();
    }
}
