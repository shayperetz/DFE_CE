package SanityTest_LP2;

import Extensions.verification;
import Utilities.commonOps;
import Utilities.helper;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (Utilities.listeners.class)
public class ZZZ_Performance extends commonOps
{
    static int numberOfJobsDone = 0 ;
    static String xmlFilename = "/LP2/Performance.xml" ;
    long startTime = 0 ;
    long endTime = 0 ;


    @Test(priority = 50000 )
    @Description("Test Description: Login Admin Level")
    public void test_login()
    {
        webFlows.login(getData("username" ,xmlFilename ),getData("password" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 50001)
    @Description("Test Description: Verify Connection")
    public void test_connection()
    {
        verification.textInElement(costEstimator_MainScreen.Connection_Status, "Connected");

    }

    @Test (dependsOnMethods = {"test_login"} , priority = 50002)
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
    @Test(dependsOnMethods = {"test_login"} , priority = 50003)
    @Description("Test Description: Verify Machine Name")
    public void test_verifyMachineName()
    {
        verification.textInElement(costEstimator_MainScreen.machineName, "HP PageWide C550");
        numberOfJobsDone  = costEstimator_ResultsPage.counterOfJobsResults.size();
    }


    @Test(dependsOnMethods = {"test_login"} , priority = 50004)
    @Description("Test Description: Verify Upload Job")
    public void test_uploadJob()
    {
        char token = ' ';
        webFlows.uploadJob(getData("Path" ,xmlFilename ));
      //  verification.subStringInElement(costEstimator_MainScreen.jobName , getData("FileName" ,xmlFilename),token);
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 50005)
    @Description("Test Description: Verify Selection Ticket Template")
    public void test_selectTicketTemplate()
    {

        webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_Mondi_STD_90);
        webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_Mondi_best_90);
        webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_Mondi_Standard_75);
        webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_Mondi_High_75);

       // webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_litePlus_STD_90);
       // webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_litePlus_best_90);
       // webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_LitePlus_Standard_75);
       // webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_litePlus_High_75);

    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 50010)
    @Description("Test Description: Start Calculation")
    public void verify_Calculation_Start()
    {
        webFlows.calculateJob();
        startTime = System.currentTimeMillis();
        System.out.println("Start time:  "  + startTime);
        helper.wait_seconds(1500);
        verification.textInElement(costEstimator_MainScreen.numberOfJobsActive , "4");

    }


    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 50014)
    @Description("Test Description: Verify Numbers Of Active Jobs")
    public void test_verify_numberOfActiveJobs()
    {
        verification.textInElement(costEstimator_MainScreen.numberOfJobsActive , "4");
    }

   @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 50016)
   @Description("Test Description: Verify Estimation Completed")
    public void test_verifyEstimationCompleted()
    {
        System.out.println(costEstimator_ResultsPage.counterOfJobsResults.size() + "   "  + numberOfJobsDone);
        //webFlows.fullPageResults();
        while ( costEstimator_MainScreen.jobList.size() < 4 )
        {
            helper.wait_seconds(4000);
        }
        endTime = System.currentTimeMillis();
        helper.wait_seconds(1500);
        //webFlows.minimumPageResults();
        //verification.textInElement(costEstimator_MainScreen.queueStatus , "No job in process");

    }

 //  @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 50017)
 //  @Description("Test Description: Verify Estimation Completed")
 //  public void test_verify_Total_Duration()
 //  {
 //      verification.textInElement(costEstimator_MainScreen.queueStatus , "No job in process");
 //  }




    @Test(dependsOnMethods = {"test_verifyEstimationCompleted"} , priority = 50051)
    @Description("Test Description: Verify Estimation Completed")
    public void test_verify_Total_Time_Duration()
    {
        System.out.println("Time Duration :   " + (endTime - startTime )/1000);
        verification.timeOfCalculation(startTime, endTime, Long.parseLong(getData("EstimationTime" ,xmlFilename )));
    }



    @Test(dependsOnMethods = {"test_verify_Total_Time_Duration"} , priority = 50060)
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
