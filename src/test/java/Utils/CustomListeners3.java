package Utils;

import org.testng.*;

import java.util.Arrays;

public class CustomListeners3 implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart -> " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish -> " + suite.getName());
    }
}
