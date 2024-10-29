package PageObject;
import Utilities.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;


public class MainScreen {

    @FindBy(how = How.CSS ,using = "div:nth-child(2).sub-container span")
    public WebElement Connection_Status ;

    @FindBy(how = How.CSS ,using = ".text.lang-text >span")
    public WebElement language ;

    @FindBy(how = How.CSS ,using = ".image > img")
    public WebElement selectJob_btn ;

    @FindBy(how = How.XPATH ,using = "//*[@id='select_value_label_12']/span[2]")
    public WebElement selectTicketTemplate_dropList ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"select_option_25\"]/div[2]")
    public WebElement ticketTemplate_checkbox ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"select_container_14\"]/md-select-menu/md-content/md-input-container/div/div[2]/button")
    public WebElement CloseTicketTemplate_checkbox ;

    @FindBy(how = How.CSS ,using = ".calc-btn > button")
    public WebElement calculate_btn ;

    @FindBy(how = How.XPATH ,using = "/html/body/div[2]/div[2]/div[1]/span")
    public WebElement machineName ;

    @FindBy(how = How.ID ,using = "filePicker")
    public WebElement uploadJob_input ;

    @FindBy(how = How.CSS ,using = "#optimizer-container > div.content > div.in-proccess-container.ng-scope > div > div.actions-container > div.job-image.picked-job > div.job-picked-container > div.job-label > span")
    public WebElement jobName ;

    @FindBy(how = How.CSS ,using = ".md-no-underline.jobUpload.select-ticket-template.ng-pristine.ng-untouched.ng-valid.ng-empty.ng-valid-md-multiple")
    public WebElement ticketTemplateList ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"select_container_14\"]/md-select-menu/md-content/md-input-container/div/div[2]/button")
    public WebElement closeTicketTemplate ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr/td[1]")
    public WebElement calculatedJobName ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr/td[2]")
    public WebElement calculatedTicketTemplateName ;

    @FindBy(how = How.CSS ,using = "tr > td:nth-child(3)")     //"tr:nth-child(1) > td:nth-child(5)"
    public WebElement calculatedDateTime ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr/td[6]")
    public WebElement calculatedProgressStatus ;

    @FindBy(how = How.CSS ,using = "td.md-cell>button.md-raised")
    public WebElement abort_btn ;

    @FindBy(how = How.CSS ,using = ".running-jobs-text > span")
    public WebElement numberOfJobsActive ;

    @FindBy(how = How.CSS ,using = "div.no-job-container span")
    public WebElement queueStatus ;

    @FindBy(how = How.CSS ,using = ".button.remove-btn >img")      // td.md-cell button
    public WebElement delete_btn ;

    @FindBy(how = How.CSS , using = "th.md-column.md-checkbox-column > md-checkbox > div.md-container.md-ink-ripple")
    public WebElement selectAllJobs_checkbox ;
    @FindBy(how = How.CSS , using = "div.not-supported-error > span")
    public WebElement fileNotSupported_lbl;

    @FindBy(how = How.CSS , using = ".table-content.md-body >tr")
    public  List<WebElement> jobList;

    @FindBy(how = How.CSS, using = ".ok-button")
    public WebElement close_btn;


    @FindBy(how = How.ID, using = "select_14")
    public WebElement ticketTemplateDropList;


    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_Mondi_Standard_75 \"]")
    public WebElement QA_Mondi_Standard_75;

    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_LitePlus_Standard_75\"]")
    public WebElement QA_LitePlus_Standard_75;



    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_Mondi_High_75\"]")
    public WebElement QA_Mondi_High_75;

    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_litePlus_High_75\"]")
    public WebElement QA_litePlus_High_75;

    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_LitePlus_Best_90\"]")
    public WebElement QA_litePlus_best_90;

    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_Mondi_Best_90\"]")
    public WebElement QA_Mondi_best_90;

    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_LitePlus_Standard_90\"]")
    public WebElement QA_litePlus_STD_90;

    @FindBy(how = How.XPATH, using = "//*[@value=\"QA_Mondi_STD_90\"]")
    public WebElement QA_Mondi_STD_90;
    @FindBy(how = How.XPATH, using = "#style-1 > tr > td.progress-status.md-cell > div > span:nth-child(1)")
    public WebElement JobStatus ;


    List<WebElement> myList =  base.driver.findElements(By.cssSelector(".table-content.md-body >tr"));




}
