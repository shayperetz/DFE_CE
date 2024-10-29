package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base {

    public static void init ()
    {
        costEstimator_LoginPage = PageFactory.initElements(driver, PageObject.loginPage.class);
        costEstimator_MainScreen = PageFactory.initElements(driver, PageObject.MainScreen.class);
        costEstimator_MenuPage = PageFactory.initElements(driver, PageObject.MenuPage.class);
        costEstimator_ResultsPage = PageFactory.initElements(driver, PageObject.ResultsPage.class);
    }

}
