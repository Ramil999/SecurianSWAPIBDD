package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SecurianPages {

    public SecurianPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

  @FindBy(xpath ="//input[contains(@id,'current-age')]")
    public WebElement currentAge;

    @FindBy(id ="retirement-age")
    public WebElement retirement;

    @FindBy(xpath ="//input[starts-with(@id,'current-income')]")
    public WebElement currentAnnualIncome;

    @FindBy(xpath ="//input[@id='spouse-income']")
    public WebElement spouseAnnualIncome;

    @FindBy(xpath ="//input[@id='current-total-savings']")
    public WebElement currentRetireSavings;

    @FindBy(xpath ="//input[@id='current-annual-savings']")
    public WebElement currentRetireContribution;

    @FindBy(xpath ="//input[@id='savings-increase-rate']")
    public WebElement annualRetirementContributionIncrease;

    @FindBy(xpath ="(//label[contains(text(),'Yes')])[1]")
    public WebElement socialSecurityIncome;

    @FindBy(xpath ="//label[contains(text(),'Married')]")
    public WebElement relatantipStatus;

    @FindBy(xpath ="//input[@id='social-security-override']")
    public WebElement socialSecurityOverride;

    @FindBy(xpath = "//input[@id='additional-income']")
    public WebElement additionalOtherIncome;

    @FindBy(xpath ="//input[@id='retirement-duration']")
    public WebElement numberOfYearsRetirement;

    @FindBy(xpath ="//legend[@id='inflation-label']/following-sibling::ul/li/label")
    public WebElement postRetirementIncomeIncreaseWithInflation;

    @FindBy(xpath ="//input[@id='retirement-annual-income']")
    public WebElement percentOfinFalAnnualIncomeDesired;

    @FindBy(xpath ="//input[@id='pre-retirement-roi']")
    public WebElement preRetirementInvestmentReturn;

    @FindBy(xpath ="//input[@id='post-retirement-roi']")
    public WebElement postRetirementInvestmentReturn;

    @FindBy(xpath ="//li[@id='assumption-desc']/following-sibling::li/a")
    public WebElement adjustDefaultValuesButton;

    @FindBy(xpath ="(//button[@class='dsg-btn-primary btn-block'])[2]")
    public WebElement saveButton;

    @FindBy(xpath ="//button[@data-tag-id='submit']")
    public WebElement calculatorButton;

    @FindBy(xpath ="//h3[contains(text(),'Results')]")
    public WebElement results;

  @FindBy(className = "usa-label")
  public WebElement portfolio;

  @FindBy(className = "usa-form-group")
  public WebElement heal;

  @FindBy(className = "usa-label")
  public WebElement portfoliowithxpath;

  @FindBy(xpath = "//div[@class='usa-form-group desktop:grid-col-3']")
  public WebElement healwithxpath;

}
