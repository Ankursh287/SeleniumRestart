package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    WebDriver driver;

    public GenericMethods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type) {
        WebElement toBeReturned = null;
        type = type.toLowerCase();
        switch (type) {
            case "xpath" -> toBeReturned = this.driver.findElement(By.xpath(locator));
            case "css-selectors" -> toBeReturned = this.driver.findElement(By.cssSelector(locator));
            case "partialLinkText" -> toBeReturned = this.driver.findElement(By.partialLinkText(locator));
            case "id" -> toBeReturned = this.driver.findElement(By.id(locator));
            case "className" -> toBeReturned = this.driver.findElement(By.className(locator));
            case "name" -> toBeReturned = this.driver.findElement(By.name(locator));
            case "tagName" -> toBeReturned = this.driver.findElement(By.tagName(locator));
            default -> System.out.println("Locator type not supported with " + type + " -> " + locator);
        }
        if (toBeReturned != null) {
            System.out.println("Element found with " + type + " -> " + locator);
            return toBeReturned;
        } else return null;
    }

    public List<WebElement> getElements(String locator, String type) {
        List<WebElement> toBeReturnedList = new ArrayList<>();
        type = type.toLowerCase();
        switch (type) {
            case "xpath":
                toBeReturnedList = this.driver.findElements(By.xpath(locator));
                break;
            case "cssselectors":
                toBeReturnedList = this.driver.findElements(By.cssSelector(locator));
                break;
            case "partiallinktext":
                toBeReturnedList = this.driver.findElements(By.partialLinkText(locator));
                break;
            case "id":
                toBeReturnedList = this.driver.findElements(By.id(locator));
                break;
            case "classname":
                toBeReturnedList = this.driver.findElements(By.className(locator));
                break;
            case "name":
                toBeReturnedList = this.driver.findElements(By.name(locator));
                break;
            case "tagname":
                toBeReturnedList = this.driver.findElements(By.tagName(locator));
                break;
            default:
                System.out.println("Locator type not supported");
                break;
        }
        if (toBeReturnedList.isEmpty()) {
            System.out.println("Element not found with " + type + " -> " + locator);

        } else {
            System.out.println("Element found with " + type + " -> " + locator);
        }
        return toBeReturnedList;
    }

    public boolean isElementPresent(String locator, String type) {
        List<WebElement> listOfElements = getElements(locator, type);
        return !listOfElements.isEmpty();
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

    public void clickWhenReady(By locator, int timeout) {
        try {
            WebElement element = null;
            System.out.println("Waiting a maximum of " + timeout + " seconds for element to be clickable");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Element is clicked in desired time on the webpage ");
        } catch (Exception e) {
            System.out.println("Element is not clickable in desired time on the webpage " + e.getMessage());
        }
    }
}
