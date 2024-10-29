package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static String getData(String nodename , String fileName  )
    {
        File fxmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        String filePath = "./Configuration/" + fileName;
        try{
            fxmlFile = new File(filePath);
            //fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);

        }
        finally {
            return doc.getElementsByTagName(nodename).item(0).getTextContent();

        }
    }


    public static String getData(String nodename , String fileName , int nodeNumber )
    {
        File fxmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        String filePath = "./Configuration/" + fileName;
        try{
            fxmlFile = new File(filePath);
            //fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);

        }
        finally {
            return doc.getElementsByTagName(nodename).item(nodeNumber).getTextContent();

        }
    }

    public void initBrowser(String BrowserType)
    {
        if (BrowserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (BrowserType.equalsIgnoreCase("firefox"))
            driver = initFireFoxDriver();

        else throw new RuntimeException("Invalid Browser Type");
    }

    public WebDriver initChromeDriver()
    {
        //System.setProperty("webdriver.chrome.whitelistedIps", "");
        //System.setProperty("webdriver.chrome.driver" , "C:\\webDrivers\\chromedriver-win64\\chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver() ;
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver.get(getData("URL", "DataConfig.xml"));
       // wait = new WebDriverWait(driver, (Time.valueOf(getData("TimeOut_SECONDS", "DataConfig.xml"))));
        driver.manage().window().fullscreen();
        return driver ;
    }
    public WebDriver initFireFoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver() ;
        driver.get(getData("URL", "DataConfig.xml"));
        driver.manage().window().maximize();
        return driver ;
    }


    @BeforeClass
    public void initChromeBrowser()
    {
        initBrowser(getData("BrowserType", "DataConfig.xml"));
        wait = new WebDriverWait(driver , (Duration.ofMillis(Integer.parseInt(getData("TimeOut", "DataConfig.xml")))));
        managePages.init();

    }

    @AfterClass
    public void closeSession()
    {
        try {
            Thread.sleep(Long.parseLong(getData("TimeOut_waitForRespond", "DataConfig.xml")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @AfterMethod
    public static void waitForRespond()
    {
        try {
            Thread.sleep(Long.parseLong(getData("TimeOut", "DataConfig.xml")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public static void waitAfterTest()
    {
        try {
            Thread.sleep(Long.parseLong(getData("TimeOut", "DataConfig.xml")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
