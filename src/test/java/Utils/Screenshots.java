package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = System.getProperty("user.dir") + "\\screenshots\\";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(directory + fileName);
        FileUtils.copyFile(sourceFile, destination);
        String screenshotDestination = directory + fileName;
        return screenshotDestination;
    }
}
