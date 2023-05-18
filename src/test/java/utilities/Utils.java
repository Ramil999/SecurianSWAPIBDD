package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class Utils {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);


    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForElementToPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void selectElement(WebElement element){
        Select select = new Select(element);

    }

    public static void moveToElement(WebElement element){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
    }


}
