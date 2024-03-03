package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckConnection {
    static WebDriver driver = null;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.guru99.com/xpath-selenium.html");
        List<WebElement> listOfLinks = clickableLinks(driver);
        System.out.println(listOfLinks.size());
        for (WebElement link : listOfLinks) {
            String href = link.getAttribute("href");
            try {
                System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<WebElement> clickableLinks(WebDriver driver) {
        List<WebElement> linksToClick = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement e : elements) {
            if ((e.getAttribute("href")) != null) {
                linksToClick.add(e);
            }
        }
        return linksToClick;
    }

    public static String linkStatus(URL url) {
        try {
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            String responseMessage = http.getResponseMessage();
            http.disconnect();
            return responseMessage;
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
