package SanityTest_LP2;

import Extensions.verification;
import Utilities.commonOps;
import Utilities.helper;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class ZZ2_LP2_LitePlus_Gorila_BRC_STD_90_RevC extends commonOps
{

    static int numberOfJobsDone = 0 ;
    static String xmlFilename = "/LP2/ZZ2_LP2_Gorila_BRC_LitePlus_STD_90_RevC.xml" ;
    long startTime = 0 ;
    long endTime = 0 ;

    @Test(priority = 6800 )
    @Description("Test Description: Login Admin Level")
    public void test_login()
    {
        webFlows.login(getData("username" ,xmlFilename ),getData("password" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 6801)
    @Description("Test Description: Verify Connection")
    public void test_connection()
    {
        verification.textInElement(costEstimator_MainScreen.Connection_Status, "Connected");

    }

    @Test (dependsOnMethods = {"test_login"} , priority = 6802)
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
    @Test(dependsOnMethods = {"test_login"} , priority = 6803)
    @Description("Test Description: Verify Machine Name")
    public void test_verifyMachineName()
    {
        verification.textInElement(costEstimator_MainScreen.machineName, "HP PageWide C550");
        numberOfJobsDone  = costEstimator_ResultsPage.counterOfJobsResults.size();
    }


    @Test(dependsOnMethods = {"test_login"} , priority = 6804)
    @Description("Test Description: Verify Upload Job")
    public void test_uploadJob()
    {
        char token = ' ';
        webFlows.uploadJob(getData("Path" ,xmlFilename ));
        verification.subStringInElement(costEstimator_MainScreen.jobName , getData("FileName" ,xmlFilename),token);
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 6805)
    @Description("Test Description: Verify Selection Ticket Template")
    public void test_selectTicketTemplate()
    {
        webFlows.selectTicketTemplate(costEstimator_MainScreen.QA_litePlus_STD_90);
        //webFlows.selectTicketTemplate(getData("TicketTemplate" ,xmlFilename ));
        // verification.textInElement(costEstimator_MainScreen.ticketTemplateList, getData("TicketTemplate" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6810)
    @Description("Test Description: Start Calculation")
    public void verify_Calculation_Start()
    {
        webFlows.calculateJob();
        startTime = System.currentTimeMillis();
        helper.wait_seconds(1500);
        verification.textInElement(costEstimator_MainScreen.numberOfJobsActive , "1");
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6811)
    public void test_verify_calculated_JobName()
    {
        char token = ';';
        verification.subStringInElement(costEstimator_MainScreen.calculatedJobName , getData("FileName" ,xmlFilename ),token);
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6812)
    @Description("Test Description: Verify Usage of Ticket Template")
    public void test_verify_calculated_TicketTemplate()
    {
        verification.textInElement(costEstimator_MainScreen.calculatedTicketTemplateName , getData("TicketTemplate" ,xmlFilename ));
    }

    //@Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 68)
    //@Description("Test Description: Verify Date & Time Correct")
    //public void test_verify_calculated_dateTime()
    //{
    //    String dateTime = helper.getDateTime();
    //    verification.textInElement(costEstimator_MainScreen.calculatedDateTime , dateTime);
    //}


    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6814)
    @Description("Test Description: Verify Numbers Of Active Jobs")
    public void test_verify_numberOfActiveJobs()
    {
        verification.textInElement(costEstimator_MainScreen.numberOfJobsActive , "1");
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6815)
    @Description("Test Description: Verify Abort Button Enable")
    public void test_verify_abortIsActive()
    {
        verification.isClickable(costEstimator_MainScreen.abort_btn );
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6816)
    @Description("Test Description: Verify Estimation Completed")
    public void test_verifyEstimationCompleted()
    {
        System.out.println(costEstimator_ResultsPage.counterOfJobsResults.size() + "   "  + numberOfJobsDone);
        while (Integer.parseInt(costEstimator_MainScreen.numberOfJobsActive.getText().toString()) > 0  )
        {
            helper.wait_seconds(100);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Job Start:   "  + startTime + "||" + "JobEnd:   " + endTime );
        verification.textInElement(costEstimator_MainScreen.queueStatus , "No job in process");
        numberOfJobsDone++;
    }

    @Test(dependsOnMethods = {"test_verifyEstimationCompleted"} , priority = 6817)
    @Description("Test Description: Verify Estimation Completed")
    public void test_verify_Total_Time_Duration()
    {
        System.out.println("Time Duration :   " + (endTime - startTime )/1000);
        verification.timeOfCalculation(startTime, endTime, Long.parseLong(getData("EstimationTime" ,xmlFilename )) );
    }
    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6818)
    @Description("Test Description: Verify Board Size In Print Direction")
    public void test_verifyBoardSize_printDirection()
    {
        verification.textInElement(costEstimator_ResultsPage.lastResult_boardPrintDirection , getData("PrintDirection" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6819)
    @Description("Test Description: Verify Board Size In Cross Print Direction")
    public void test_verifyBoardSize_xPrintDirection()
    {
        verification.textInElement(costEstimator_ResultsPage.lastResult_boardxPrintDirection , getData("xPrintDirection" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"test_selectTicketTemplate"} , priority = 6820)
    @Description("Test Description: Verify More Info Is Appear")
    public void A_moreInfo_is_Open()
    {

        webFlows.openMoreInfo();
    }
 //   @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6840)
 //   @Description("Test Description: Verify Print Mode OK")
 //   public void test_verify_printMode()
 //   {
 //       verification.textInElement(costEstimator_ResultsPage.lastResult_printMode , getData("PrintMode" ,xmlFilename ));
 //   }

    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6841)
    @Description("Test Description: Verify Total Ink Consumption")
    public void test_verify_totalInkConsumption()
    {
        String totalInk_ml = costEstimator_ResultsPage.lastResult_CMYK_total_ink.getText();
        String totalInk    = totalInk_ml.substring(0, 4);
        double totalInkConsumption = Double.parseDouble(totalInk);
        verification.isEstimated(totalInkConsumption , getData("totalInkConsumption" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6842)
    @Description("Test Description: Verify Fixer Consumption")
    public void test_verify_BA_consumption()
    {
        String total_BA_ml = costEstimator_ResultsPage.lastResult_BA_total_ink.getText();
        String totalBA   = total_BA_ml.substring(0, 4);
        double total_BA_Consumption = Double.parseDouble(totalBA);
        verification.isEstimated(total_BA_Consumption , getData("FixerConsumption" ,xmlFilename ));
    }


    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6843)
    @Description("Test Description: Verify Cyan Ink Consumption")
    public void test_verify_Cyan_consumption()
    {
        verification.isEstimated(costEstimator_ResultsPage.barCyan , getData("CyanConsumption" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6844)
    @Description("Test Description: Verify Magenta Ink Consumption")
    public void test_verify_Magenta_consumption()
    {
        verification.isEstimated(costEstimator_ResultsPage.barMagenta , getData("MagentaConsumption" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6845)
    @Description("Test Description: Verify Yellow Ink Consumption")
    public void test_verify_Yellow_consumption()
    {
        verification.isEstimated(costEstimator_ResultsPage.barYellow , getData("YellowConsumption" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6846)
    @Description("Test Description: Verify Black Ink Consumption")
    public void test_verify_Black_consumption()
    {
        // verification.textInElement(costEstimator_ResultsPage.barBlack , getData("BlackConsumption" ,xmlFilename ));
        verification.isEstimated(costEstimator_ResultsPage.barBlack , getData("BlackConsumption" ,xmlFilename ));
    }

    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6847)
    @Description("Test Description: Verify Fixer Ink Consumption")
    public void test_verify_Fixer_consumption()
    {
        verification.isEstimated(costEstimator_ResultsPage.barFixer , getData("BAConsumption" ,xmlFilename ));
    }
    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6848)
    @Description("Test Description: Verify Fixer Ink Consumption")
    public void test_verify_Cost_Per_Board()
    {
        verification.textInElement(costEstimator_ResultsPage.costPerBoard , getData("CostPerBoard" ,xmlFilename ));
    }


    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6849)
    @Description("Test Description: Verify Fixer Ink Consumption")
    public void test_verify_Cost_Per_SQm()
    {
        verification.textInElement(costEstimator_ResultsPage.costPerSQM , getData("CostPerSQM" ,xmlFilename ));
    }
    @Test(dependsOnMethods = {"A_moreInfo_is_Open"} , priority = 6850)
    @Description("Test Description: Delete and Verify")
    public void delete_last_job_results()
    {
        webFlows.deleteResult();
        helper.wait_seconds(1500);
        verification.numberOfElements(costEstimator_ResultsPage.counterOfJobsResults,numberOfJobsDone-1);
        numberOfJobsDone--;
    }

    @Test(dependsOnMethods = {"delete_last_job_results"} , priority = 6860)
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
