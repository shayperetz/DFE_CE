package SanityTest_LP2;

import Extensions.verification;
import Utilities.commonOps;
import Utilities.helper;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (Utilities.listeners.class)
public class AAA_Settings extends commonOps
{
    static int numberOfJobsDone = 0 ;
    static String xmlFilename = "/LP2/Performance.xml" ;



    @Test(priority = 50000 )
    @Description("Test Description: Login Admin Level")
    public void test_login()
    {
        webFlows.login(getData("username" ,xmlFilename ),getData("password" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 1)
    @Description("Test Description: Verify Connection")
    public void test_connection()
    {
        verification.textInElement(costEstimator_MainScreen.Connection_Status, "Connected");

    }

    @Test (dependsOnMethods = {"test_login"} , priority = 5)
    @Description("Test Description: Delete All Jobs")
    public void deleteAllJobs()
    {
        try{
            while (costEstimator_MainScreen.jobList.size() > 0 )
            {
                webFlows.selectAllJobs();
                webFlows.deleteAllJobsInPage();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
    @Test(dependsOnMethods = {"test_login"} , priority = 9)
    @Description("Test Description: Verify Machine Name")
    public void test_verifyMachineName()
    {
        verification.textInElement(costEstimator_MainScreen.machineName, "HP PageWide C550");
        numberOfJobsDone  = costEstimator_ResultsPage.counterOfJobsResults.size();
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 13)
    @Description("Test Description: Verify Machine Name")
    public void test_verifySettingsSetToDefault()
    {
        webFlows.goToSettings();
        webFlows.defaultSettings();
    }



    @Test(dependsOnMethods = {"test_login"} , priority = 17)
    @Description("Test Description: Log Out")
    public void test_verify_logOut()
    {
        webFlows.logout();
        verification.textInElement(costEstimator_LoginPage.logIn_title , "Welcome to Cost Estimator" );
    }

    @BeforeMethod
    public static void idle()
    {
        System.out.println("Before Method Wait For 1 Sec");
        helper.wait_seconds(1000);
    }


}
