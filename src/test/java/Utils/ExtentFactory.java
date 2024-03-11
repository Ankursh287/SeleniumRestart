package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentFactory<E, T> {
    static ExtentReports reports;
    static ExtentTest test;
    static ExtentSparkReporter spark;

    public static ExtentReports Instance1() {
        reports = new ExtentReports();
        return reports;
    }

    public static ExtentTest Instance3() {
        String path = System.getProperty("user.dir") + "\\screenshots\\login.html";
        test = reports.createTest("Verify Welcome Test");
        return test;
    }


    public static ExtentSparkReporter Instance2() {
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\screenshots\\login.html");
        reports = new ExtentReports();
        test = reports.createTest("Verify Welcome Test");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Reports Demo");
        reports.attachReporter(spark);
        return spark;
    }
}
