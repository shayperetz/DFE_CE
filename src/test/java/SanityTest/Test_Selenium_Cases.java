package SanityTest;

import Extensions.uiActions;
import Extensions.verification;
import Utilities.commonOps;
import Utilities.helper;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.naming.Name;
import javax.swing.*;
import java.util.List;

@Listeners (Utilities.listeners.class)
public class Test_Selenium_Cases extends commonOps
{
    static int numberOfJobsDone = 0 ;



    @Test(priority = 0 )
    @Description("Test Description: Login Admin Level")
    public void test_login()
    {
        webFlows.login(getData("username" ,"D_BRC_Mondi_Standard_RevC.xml" ),getData("password" ,"D_BRC_Mondi_Standard_RevC.xml" ));
    }




    @Test(dependsOnMethods = {"test_login"} , priority = 3)
    @Description("Test Description: Verify Upload Job")
    public void test_uploadJob()
    {
        webFlows.uploadJob(getData("Path" ,"D_BRC_Mondi_Standard_RevC.xml" ));
        verification.textInElement(costEstimator_MainScreen.jobName , "Uploaded: CE_ IQ Text_1300x1200.pdf");
    }

    @Test(dependsOnMethods = {"test_login"} , priority = 4)
    @Description("Test Description: Verify Selection Ticket Template")
    public void test_selectTicketTemplate()
    {
        //uiActions.click(costEstimator_TicketTemplatePage.ticketTemplateDropList);
       // uiActions.click(costEstimator_TicketTemplatePage.substrateList_txt);
        List<WebElement> ttmylist = driver.findElements(By.cssSelector("div.md-text"));
        int x = 0 ;
        for(int i = 0; i < ttmylist.size(); i++) {
            System.out.println( "list    :"  + ttmylist.get(i));
        }
    }















}
