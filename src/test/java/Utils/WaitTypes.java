package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTypes {
    WebDriver driver;

    public WaitTypes(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting a maximum of " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element appeared in desired time on the webpage ");
        } catch (Exception e) {
            System.out.println("Element not appeared in desired time on the webpage " + e.getMessage());
        }
        return element;
    }
}
