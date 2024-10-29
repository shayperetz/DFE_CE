package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class LogIn
{
    WebDriver driver;

    public void test01()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.get("http://15.16.155.181:48000/#!/Login");
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }


    public void test02()
    {
        String userName = "/html/body/div[4]/div/div/div/div/div/div/div/div/div[2]/div[2]/div[2]/input";
        String password = "/html/body/div[4]/div/div/div/div/div/div/div/div/div[2]/div[3]/div[2]/input";
        String login_btn = "/html/body/div[4]/div/div/div/div/div/div/div/div/div[3]/button";
        //userName_txt.sendKeys("Admin");
        driver.findElement(By.xpath(password)).sendKeys("adm");
        driver.findElement(By.xpath(login_btn)).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // @Test(dependsOnMethods = {"test02"})
    public void verifyConnection()
    {
        String connected = "//*[@id=\"optimizer-container\"]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div[2]";
        String my = driver.findElement(By.xpath(connected)).getText() ;
        System.out.println("DEBUG:    "  +   my);
        assertEquals(driver.findElement(By.xpath(connected)).getText(), "Connected");
    }
}
