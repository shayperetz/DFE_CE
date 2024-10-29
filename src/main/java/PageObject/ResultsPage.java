package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class ResultsPage
{

    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr[1]")
    public WebElement lastResult ;


    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr[1]/td[7]")
    public WebElement lastResult_boardPrintDirection ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr[1]/td[8]")
    public WebElement lastResult_boardxPrintDirection ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"style-1\"]/tr[1]/td[9]")
    public WebElement lastResult_printMode ;

    @FindBy(how = How.CSS ,using = "div.cmyk-usage > div.results > span")
    public WebElement  lastResult_CMYK_total_ink ;

    @FindBy(how = How.CSS ,using = " div.ba-usage > div.results > span")
    public WebElement lastResult_BA_total_ink ;

    @FindBy(how = How.CSS ,using = "#history-table > thead.md-head.ng-isolate-scope > tr > th.md-column.md-checkbox-column > md-checkbox")
    public WebElement lastResult_check_box ;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"optimizer-container\"]/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[2]")
    public WebElement lastResult_delete_btn;

    @FindBy(how = How.CSS ,using = "td.info-label.not-displayed-on-narrow.md-cell > div")  //".arrow.collapsed"
    public WebElement moreInfo_btn ;

    @FindBy(how = How.CSS ,using = "div.bar.cyan")
    public WebElement barCyan ;

    @FindBy(how = How.CSS ,using = "div.bar.magenta")
    public WebElement barMagenta ;

    @FindBy(how = How.CSS ,using = "div.bar.yellow")
    public WebElement barYellow ;

    @FindBy(how = How.CSS ,using = "div.bar.black")
    public WebElement barBlack ;

    @FindBy(how = How.CSS ,using = "div.bar.ba")
    public WebElement barFixer ;

    @FindBy( how = How.CSS , using = "tbody>tr.md-row")
    public List<WebElement> counterOfJobsResults ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"style-1\"]/tr[1]/td[13]/div")
    public WebElement costPerBoard ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"style-1\"]/tr[1]/td[14]/div/span")
    public WebElement costPerSQM ;

    @FindBy( how = How.CSS , using = "#optimizer-container > div.content > div.result-table-container > div > div.result-block > div.filter-wrapper > div > div.filters > div.button.full-screen > img")
    public WebElement fullScreenResults ;

    @FindBy( how = How.CSS , using = "#history-table > thead.md-head.ng-isolate-scope > tr > th.md-column.md-checkbox-column > md-checkbox > div.md-container.md-ink-ripple")
    public WebElement minimumScreenResults ;


}
