package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RandomTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static String baseURL;
    static WebElement element;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        baseURL = "https://www.expedia.co.in/";
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='multi-product-search-form-1']//a[contains(@href,'/Flights')]"))));
        element.click();

        element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@data-testid='uitk-date-selector-input1-default']"))));
        element.click();

        List<WebElement> listOfDates;
        listOfDates = wait.until(ExpectedConditions.visibilityOfAllElements((driver.findElements(By.xpath("//section[@data-testid='popover-sheet']//table[contains(@aria-label,'March')]//td//div[@aria-disabled='false']//div[contains(@class,'uitk-date-number')]")))));////h2[contains(text(),'March')]//parent::div//button
        System.out.println(listOfDates.size());
        //       listOfDates.forEach(System.out::println);

        String month = "April";
        String date = "20";
        WebElement requiredDate = driver.findElement(By.xpath("//section[@data-testid='popover-sheet']//table[contains(@aria-label,'" + month + "')]//td//div[@aria-disabled='false']//div[starts-with(text(),'" + date + "')]"));
        requiredDate.click();
        System.out.println("Click Performed");
    }
}
