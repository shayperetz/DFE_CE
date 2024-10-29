package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class loginPage
{
    @FindBy(how = How.CSS,using = "div.input-username-container > input")
    public WebElement userName_txt ;

    @FindBy(how = How.CSS ,using = "div.input-password-container > input")
    public WebElement password_txt ;

    @FindBy(how = How.CSS ,using = ".submit-btn > button")
    public WebElement login_btn ;

    @FindBy(how =How.CSS , using = ".login-title ")
    public WebElement logIn_title ;

    @FindBy(how =How.CSS , using =  ".error-msg.ng-scope > span") //"div.error-msg span:nth-child(1)") //"div.error-msg span" )
    public WebElement logIn_error_msg ;
}
