package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    public static void JavascriptExecutor() {
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", cybertekSchoolLink);

        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        executor.executeScript("arguments[0].click();", Driver.getDriver().findElement(By.xpath("//div[@id='mceu_34']/button")));
    }

    //1)soft assert will run the test and not throw an exception if the assert failed
    //2)This is used when the test requires multiple assertions to be executed and
    // -we want all of the assertions to be executed before failing test
    @Test
    public void softAssertion(){
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert");
        softAssertion.assertTrue(false);
        softAssertion.assertAll();

    }

    //1)hard assert will throw the exception immediately, and then continue with the testing process
    //2)Hard Assert throws Exception Immediately if the assert statement fails and move to the next testcase
    // and if there is any code in the current test case after assert statement it will
    // not execute that statement
    @Test
    public void hardAssertion(){
        System.out.println("hardAssert");
        Assert.assertTrue(false);
        System.out.println("hardAssert");
    }

  /*  NoSuchElementException:  When an element is not found on the page it throws that exception
    TimeoutException: When a specified timeout is exceeded we are getting that exception
    StaleElementReferenceException: When a previously located element is no longer valid or entirely deleted we get that exception
    ElementNotVisibleException: When an element is not visible on the page it throws that exception
    WebDriverException: A general exception for WebDriver-related issues.*/
}
