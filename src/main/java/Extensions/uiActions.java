package Extensions;

//import io.qameta.allure.Step;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Utilities.commonOps;

import java.util.List;

public class uiActions extends commonOps
{

    @Step("Click On Element")
    public static void click(WebElement elem)
    {
        delayAction();
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Select Element")
    public static void select(WebElement selection)
    {
        //selection.get
    }

    @Step("Send Text To Text Box")
    public static void updateText(WebElement elem, String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(text);
        System.out.println("DEBUG:   "  + elem.getTagName());
    }


    @Step("Select In Drop Down")
    public static void updateDropDown(WebElement elem, String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select myValue = new Select((elem));
        myValue.selectByVisibleText(value);
    }

    @Step("DELET?")
    public static void  uploadJob(WebElement elem , String path)
    {
      // try {
      //     Thread.sleep(6000);
      // } catch (InterruptedException e) {
      //     e.printStackTrace();
      // }
        elem.sendKeys(path);
    }
    @Step("Select In Drop Down _2 ")
    public static void selectDropList(WebElement elem , String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        selection = new Select(elem);
        selection.selectByVisibleText(value);
    }


    public static void delayAction()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
