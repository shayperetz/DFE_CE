package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener
{
    public void onFinish(ITestContext arg0)
    {
        System.out.println("------ Test onFinish: " +arg0.getName() + "  ------");
    }

    public void onStart(ITestContext arg0)
    {
        System.out.println("------ Starting Test: " +arg0.getName() + "  ------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        System.out.println( "------ Test partially success: " +arg0.getName() + "  ------");
    }

    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("------ Fail Test: " +arg0.getName() + "  ------");
        getScreenCapture();
    }

    public void onTestSkipped(ITestResult arg0)
    {
        System.out.println("------ Skipping Test: " +arg0.getName() + "  ------");
    }

    public void onTestStart(ITestResult arg0)
    {
        System.out.println( "------ Test on Test Start: " +arg0.getName() + "  ------");
    }

    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("------ Skipping Test: " +arg0.getName() + "  ------ Succeeded------ ");

    }

    @Attachment(value = "Page screenshot" , type = "image/png")
    public byte [] getScreenCapture()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
