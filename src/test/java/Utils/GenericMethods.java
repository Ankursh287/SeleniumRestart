package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            case "xpath":
                toBeReturned = this.driver.findElement(By.xpath(locator));
                break;
            case "css-selectors":
                toBeReturned = this.driver.findElement(By.cssSelector(locator));
                break;
            case "partialLinkText":
                toBeReturned = this.driver.findElement(By.partialLinkText(locator));
                break;
            case "id":
                toBeReturned = this.driver.findElement(By.id(locator));
                break;
            case "className":
                toBeReturned = this.driver.findElement(By.className(locator));
                break;
            case "name":
                toBeReturned = this.driver.findElement(By.name(locator));
                break;
            case "tagName":
                toBeReturned = this.driver.findElement(By.tagName(locator));
                break;
            default:
                System.out.println("Locator type not supported with " + type + " -> " + locator);
                break;
        }
        if (toBeReturned != null) {
            System.out.println("Element found with " + type + " -> " + locator);
            return toBeReturned;
        } else return null;
    }

    public List<WebElement> getElements(String locator, String type) {
        List<WebElement> toBeReturned = new ArrayList<>();
        type = type.toLowerCase();
        switch (type) {
            case "xpath":
                toBeReturned = this.driver.findElements(By.xpath(locator));
                break;
            case "css-selectors":
                toBeReturned = this.driver.findElements(By.cssSelector(locator));
                break;
            case "partialLinkText":
                toBeReturned = this.driver.findElements(By.partialLinkText(locator));
                break;
            case "id":
                toBeReturned = this.driver.findElements(By.id(locator));
                break;
            case "className":
                toBeReturned = this.driver.findElements(By.className(locator));
                break;
            case "name":
                toBeReturned = this.driver.findElements(By.name(locator));
                break;
            case "tagName":
                toBeReturned = this.driver.findElements(By.tagName(locator));
                break;
            default:
                System.out.println("Locator type not supported with " + type + " -> " + locator);
                break;
        }
        if (toBeReturned != null) {
            System.out.println("Element found with " + type + " -> " + locator);
            return toBeReturned;
        } else return null;
    }
}
