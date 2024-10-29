package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MenuPage
{
    @FindBy(how = How.CSS ,using = ".icon.settings-link-icon")
    public WebElement Menu_btn;

    @FindBy(how = How.CSS , using ="div:nth-child(1) > div > div.item-text-container")
    public WebElement settings_btn;
    @FindBy(how = How.CSS , using ="div:nth-child(2) > div > div.item-text-container")
    public WebElement substrateSync_btn;
    @FindBy(how = How.CSS , using ="div:nth-child(3) > div > div.item-text-container")
    public WebElement pressCredentials_btn;
    @FindBy(how = How.CSS , using ="div:nth-child(4) > div > div.item-text-container")
    public WebElement changePassword_btn;
    @FindBy(how = How.CSS , using ="div:nth-child(5) > div > div.item-text-container")
    public WebElement restart_btn;
    @FindBy(how = How.CSS , using ="div:nth-child(6) > div > div.item-text-container")
    public WebElement logOut_btn;

}
