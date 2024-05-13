package utilities;

import base.Setup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends Setup implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");
        String methodName = result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        takeScreenShot(methodName);
    }
    public void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screenshot Screenshots folder with test method name
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshots/" + methodName + ".png"));
            System.out.println("***Placed screen shot in " + "Screenshots" + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
