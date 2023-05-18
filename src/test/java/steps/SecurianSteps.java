package steps;

import databean.SecurianDataBean;
import databean.Services;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SecurianPages;
import utilities.ConfigurationReader;
import utilities.Constants;
import utilities.Driver;
import utilities.Utils;

public class SecurianSteps extends SecurianPages {
    Utils utils = new Utils();
    SecurianDataBean dt;

    @When("I launch the application")
    public void user_user_launch_the_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty(Constants.SECURIAN_APPLICATION));
    }


   @Then("I enter {string} to inputBox")
   public void user_enters_to_quantity(String testDataKey) {
       dt = new SecurianDataBean(Services.SECURIAN,testDataKey);
           currentAge.click();
           currentAge.sendKeys(dt.getCurrentAge());
           retirement.click();
           retirement.sendKeys(dt.getRetirement());
           currentAnnualIncome.click();
           currentAnnualIncome.sendKeys(dt.getSpouseAnnualIncome());
           spouseAnnualIncome.click();
           spouseAnnualIncome.sendKeys(dt.getCurrentAnnualIncome());
           currentRetireSavings.click();
           currentRetireSavings.sendKeys(dt.getCurrentRetireSavings());
           currentRetireContribution.click();
           currentRetireContribution.sendKeys(dt.getCurrentRetireContribution());
           annualRetirementContributionIncrease.click();
           annualRetirementContributionIncrease.sendKeys(dt.getAnnualRetirementContributionIncrease());
           socialSecurityIncome.click();
           relatantipStatus.click();
           socialSecurityOverride.click();
           socialSecurityOverride.sendKeys(dt.getSocialSecurityOverride());
           adjustDefaultValuesButton.click();
           additionalOtherIncome.click();
           additionalOtherIncome.sendKeys(dt.getAdditionalOtherIncome());
           numberOfYearsRetirement.click();
           numberOfYearsRetirement.sendKeys(dt.getNumberOfYearsRetirement());
           postRetirementIncomeIncreaseWithInflation.click();
           percentOfinFalAnnualIncomeDesired.click();
           percentOfinFalAnnualIncomeDesired.sendKeys(dt.getPercentOfinFalAnnualIncomeDesired());
           preRetirementInvestmentReturn.click();
           preRetirementInvestmentReturn.sendKeys(dt.getPreRetirementInvestmentReturn());
           postRetirementInvestmentReturn.click();
           postRetirementInvestmentReturn.sendKeys(dt.getPostRetirementInvestmentReturn());
   }

    @Then("I click on {string} button")
    public void user_user_click_on_button(String key) {
       if (key.equalsIgnoreCase(Constants.SAVE)) {
            saveButton.click();
        } else if (key.equalsIgnoreCase(Constants.CALCULATE)) {
            calculatorButton.click();
        }
    }

    @Then("I validate {string} is displayed")
    public void user_user_validates_on_is_displayed(String string) {
utils.waitForElementToPresent(results);
        Assert.assertTrue(results.isDisplayed());
    }
}
