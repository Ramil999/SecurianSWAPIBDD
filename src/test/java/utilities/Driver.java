package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

//Base capabilities class
public class Driver {

    private Driver() {

    }
    public static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome=headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

            }

        }
        //=========================================================================
        //SSL is used to establish encrypted connection between browser and server
        DesiredCapabilities ch = new DesiredCapabilities().chrome();
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        ChromeOptions c = new ChromeOptions();
        c.merge(ch);
        System.setProperty("WebDriver.chromeDriver","");
        WebDriver driver1= new ChromeDriver(c);
        //==================================================================

        //Resize the browser
        Dimension d = new Dimension(480,620);
        driver1.manage().window().setSize(d);

    return driver;


}
public static void tearDownDriver(){
    if(driver!=null){
        driver.quit();
        driver=null;
    }
}
}
