package WorkFlows;
import Extensions.uiActions;
import Utilities.commonOps;
import Utilities.helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class webFlows extends commonOps
{

    static String xmlFilename = "/Sanity/B_Text_LitePlus_High_RevC.xml" ;

    @Step("Log in Cost Estimator")
    public static void login(String userName , String password)
    {
        uiActions.updateText(costEstimator_LoginPage.userName_txt, userName);
        uiActions.updateText(costEstimator_LoginPage.password_txt, password);
        uiActions.click(costEstimator_LoginPage.login_btn);
    }

    @Step("Upload New Job")
    public static void uploadJob(String path) {
        System.out.println("THE PATH IS    :" + path);
        uiActions.uploadJob(costEstimator_MainScreen.uploadJob_input, path);
        helper.wait_seconds(1000);
    }

    @Step("Select Ticket Template")
    public static void selectTicketTemplate(WebElement TTName)
    {
        //System.out.println(TTName);
        uiActions.click(costEstimator_MainScreen.ticketTemplateDropList);
        //WebElement tt = driver.findElement(By.cssSelector(TTName));
        uiActions.click(TTName);
        //uiActions.click(costEstimator_MainScreen.QA_Mondi_Standard_75);
        uiActions.click(costEstimator_MainScreen.close_btn);

    }

    @Step("Calculate Job")
    public static void calculateJob()
    {
        uiActions.click(costEstimator_MainScreen.calculate_btn);
    }

    @Step("Check More Info View")
    public static void openMoreInfo()
    {
        uiActions.click(costEstimator_ResultsPage.moreInfo_btn);
    }

    @Step("Delete Results Of A Job")
    public static void deleteResult() {
        uiActions.click(costEstimator_ResultsPage.lastResult_check_box);
        uiActions.click(costEstimator_ResultsPage.lastResult_delete_btn);
    }

    @Step("Log Out System")
    public static void logout() {
        uiActions.click(costEstimator_MenuPage.Menu_btn);
        uiActions.click(costEstimator_MenuPage.logOut_btn);
    }

    @Step("Full Screen Results")
    public static void fullPageResults()
    {
        uiActions.click(costEstimator_ResultsPage.fullScreenResults);
    }

    @Step("Full Screen Results")
    public static void minimumPageResults()
    {
        uiActions.click(costEstimator_ResultsPage.minimumScreenResults);
    }

    @Step ("Select All Jobs")
    public static void  selectAllJobs ()
    {
        uiActions.click(costEstimator_MainScreen.selectAllJobs_checkbox);
    }

    @Step ( "Delete All Jobs In The page")
    public static void  deleteAllJobsInPage()
    {
        uiActions.click(costEstimator_MainScreen.delete_btn);
    }

    @Step ( "Go To Settings")
    public static void  goToSettings()
    {
        uiActions.click(costEstimator_MenuPage.Menu_btn);
        uiActions.click(costEstimator_MenuPage.settings_btn);
    }

    @Step ("Settings to default")
    public static void  defaultSettings()
    {
      //driver.findElement(By.cssSelector("#settings-form > div.form-section.middle-section.consumable-prices > div.left-side > div.price.ink-price > div.input-price.cmyk > div.input-wrapper > md-input-container input")).sendKeys("38");

        uiActions.updateText(costEstimator_SettingsPage.CMYK_Price, getData("CMYK_Price" ,"TestConfig.xml" ));
        uiActions.click(costEstimator_SettingsPage.save_btn);
    }



}
