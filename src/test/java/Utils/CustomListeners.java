package Utils;

import org.testng.*;

import java.util.Arrays;

public class CustomListeners implements IInvokedMethodListener, ITestListener, ISuiteListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        //Before any method in class
        /*IInvokedMethodListener.super.beforeInvocation(method, testResult);*/
        System.out.println("Before Invocation: " + testResult.getClass().getName() + " => " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        //After any method in class
        /*        IInvokedMethodListener.super.afterInvocation(method, testResult);*/
        System.out.println("After Invocation: " + testResult.getClass().getName() + " => " + method.getTestMethod().getMethodName());
    }

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

    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart -> " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish -> " + suite.getName());
    }
}
