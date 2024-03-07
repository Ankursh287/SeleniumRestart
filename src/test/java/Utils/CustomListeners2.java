package Utils;

import org.testng.*;

import java.util.Arrays;

public class CustomListeners2 implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        //When test method starts
        System.out.println("onTestStart -> Test Name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //When test method is successful
        System.out.println("onTestSuccess -> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //When test method is fail
        System.out.println("onTestFailure -> Test Name: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //When test method is skipped
        System.out.println("onTestSkipped -> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        //Before <test> tag of testng.xml file
        System.out.println("onStart -> Test Tag Name: " + context.getName());
        var methods = context.getAllTestMethods();
        System.out.println("Below method will be executed in <test> tag: ");
        Arrays.stream(methods).map(ITestNGMethod::getMethodName).forEach(System.out::println);
    }

    @Override
    public void onFinish(ITestContext context) {
        //After <test> tag of testng.xml file
        System.out.println("onFinish -> Test Tag  Name: " + context.getName());
        var methods = context.getAllTestMethods();
        System.out.println("Below method will be executed in <test> tag: ");
        Arrays.stream(methods).map(ITestNGMethod::getMethodName).forEach(System.out::println);
    }
}
