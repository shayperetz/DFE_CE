package Extensions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import Utilities.helper;
import org.testng.annotations.BeforeTest;

import javax.swing.text.Utilities;
import java.sql.Time;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class verification extends commonOps
{
    @Step("Verify Text In Element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText() , expectedValue);
    }

    @Step("Verify substring In Element")
    public static void subStringInElement(WebElement elem, String expectedValue, char token)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText().substring(elem.getText().indexOf(token)+1) , expectedValue);
    }
    @Step("Verify Text In Element")
    public static void SpecialTextInElement(WebElement elem, String expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText().substring((elem.getText().length() - expectedValue.length()) , elem.getText().length()) , expectedValue);

    }

    @Step("Verify If Button Is Clickable")
    public static void isClickable(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.isEnabled() , true);


    }
    @Step("Verify Number Of Elements")
    public static void numberOfElements(List<WebElement> elem , int expectedValue)
    {
        int listSize = elem.size();
        assertEquals(elem.size() , expectedValue ) ;
    }

    @Step("Verify Status Of The Estimator")
    public static void checkStatus(WebElement elem , String value)
    {
        wait.until(ExpectedConditions.textToBePresentInElementValue(elem, value));

    }

    @Step("Verify If Button Is Not Clickable")
    public static void isNotClickable(WebElement elem)
    {
        wait.until(ExpectedConditions.invisibilityOf(elem));
        assertEquals(elem.isEnabled() , false);


    }

    @Step("Verify If Element Exsit")
    public static void isExist(WebElement elem)
    {
        wait.until(ExpectedConditions.invisibilityOf(elem));
        assertTrue(elem.isDisplayed());


    }

    @Step("Estimated +/- 4%")
    public static void isEstimated(WebElement elem ,  String expectedValue)
    {

        double tolerance = Float.parseFloat(getData("EstimationError" ,"TestConfig.xml" )) *  Float.parseFloat(expectedValue);
        assertEquals(Float.parseFloat(elem.getText()), Float.parseFloat(expectedValue),tolerance );

    }

    @Step("Estimated +/- 4%")
    public static void isEstimated(double elem ,  String expectedValue)
    {

        double tolerance = Float.parseFloat(getData("EstimationError" ,"TestConfig.xml" )) *  Float.parseFloat(expectedValue);
        assertEquals(elem , Float.parseFloat(expectedValue),tolerance );

    }

    @Step("Job duration should finish up to extra 6 second of the maximum measured")
    public static void timeOfCalculation(long start , long end , long expectedDuration)
    {
        //long tolerance =  Long.parseLong(getData("EstimationTimeTolerance" ,"TestConfig.xml" )) ;
        float duration = ((end - start )/1000);
        assertTrue(duration < expectedDuration );
        //assertEquals(duration , expectedDuration, tolerance );

    }


    @BeforeTest
    public static void idle()
    {
        System.out.println("Before Method Wait For 1 Sec");
        helper.wait_seconds(1000);
    }


  // REST API


    @Step("Verify Text In Element")
    public static void textInString(String str, String expectedValue)
    {
        assertEquals(str , expectedValue);
    }

}
