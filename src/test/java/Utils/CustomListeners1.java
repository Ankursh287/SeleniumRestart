package Utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListeners1 implements IInvokedMethodListener {

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
}
