package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.util.concurrent.TimeUnit;


public class Hooks {

    @After()
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()) {

            Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            byte[] screenshoot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshoot, "image/png", scenario.getName());

        }
          Driver.tearDownDriver();


    }



}