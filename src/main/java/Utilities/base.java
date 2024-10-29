package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.comparison.ImageDiff;
//import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class base
{
    //----------------Cost Estimator----------------------------//
    public static WebDriver driver ;
    public static WebDriverWait wait ;
    public static Actions actions ;
    public static Select selection  ;

   // public static Screenshot imageScreenShot;
   // public static ImageDiffer imageDiffer = new ImageDiffer();
   // public static ImageDiff imageDiff ;

    public static PageObject.loginPage costEstimator_LoginPage;
    public static PageObject.MainScreen costEstimator_MainScreen;
    public static PageObject.MenuPage costEstimator_MenuPage;
    public static PageObject.ResultsPage costEstimator_ResultsPage ;
    public static PageObject.SettingsPage  costEstimator_SettingsPage;
}
