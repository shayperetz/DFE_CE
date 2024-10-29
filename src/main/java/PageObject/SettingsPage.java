package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SettingsPage
{

    @FindBy(how = How.CSS ,using = "#settings-form > div.form-section.middle-section.consumable-prices > div.left-side > div.price.ink-price > div.input-price.cmyk > div.input-wrapper > md-input-container input")
    public WebElement CMYK_Price;

    @FindBy(how = How.XPATH ,using = "/html/body/div[4]/div[2]/div/div[2]/form/div[1]/div[1]/div[3]/md-input-container/md-select/md-select-value/span[1]")
    public WebElement currencySelection;

    @FindBy(how = How.XPATH ,using = "select_option_171")
    public WebElement US_Dollar;

    @FindBy(how = How.XPATH , using ="input_118")
    public WebElement wipingCassettesSet;
    @FindBy(how = How.XPATH , using ="input_117")
    public WebElement BA_Price;
    @FindBy(how = How.XPATH , using ="input_119")
    public WebElement PrintHead_Price;
    @FindBy(how = How.XPATH , using ="input_120")
    public WebElement PrintHeadLiftSpan;
    @FindBy(how = How.XPATH , using ="input_121")
    public WebElement wipingCassettesPerSQM;
    @FindBy(how = How.CSS , using ="#settings-form > div.form-section.buttons-section > div > div.action-btn-container.btn-container.save-btn > button")
    public WebElement save_btn;

    @FindBy(how = How.CSS , using ="#settings-form md-input-container input")
    public List<WebElement> costSettings;


}
