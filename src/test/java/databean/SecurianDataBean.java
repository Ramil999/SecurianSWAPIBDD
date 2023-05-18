package databean;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static utilities.CSVUtils.convertCSVToJson;
import static utilities.JsonUtils.getValueFromDataMap;
import static utilities.JsonUtils.readFileAsString;

public class SecurianDataBean{
    private String currentAge;
    private String retirement;
    private String currentAnnualIncome;
    private String spouseAnnualIncome;
    private String currentRetireSavings;
    private String currentRetireContribution;
    private String annualRetirementContributionIncrease;
    private String socialSecurityOverride;
    private String numberOfYearsRetirement;
    private String percentOfinFalAnnualIncomeDesired;
    private String preRetirementInvestmentReturn;
    private String postRetirementInvestmentReturn;
    private String additionalOtherIncome;

    Map<String, String> expectedResult = new LinkedHashMap<>();

    public SecurianDataBean(Services serviceName, String TC_ID) {

        convertCSVToJson(serviceName);
        DocumentContext dc = null;
        try {

            dc = JsonPath.parse(readFileAsString("src/test/resources/testdata/" + serviceName.getopFile() + ".json"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.currentAge = getValueFromDataMap(dc, "currentAge", TC_ID);
        this.retirement = getValueFromDataMap(dc, "retirement", TC_ID);
        this.currentAnnualIncome = getValueFromDataMap(dc, "currentAnnualIncome", TC_ID);
        this.spouseAnnualIncome = getValueFromDataMap(dc, "spouseAnnualIncome", TC_ID);
        this.currentRetireSavings = getValueFromDataMap(dc, "currentRetireSavings", TC_ID);
        this.currentRetireContribution = getValueFromDataMap(dc, "currentRetireContribution", TC_ID);
        this.annualRetirementContributionIncrease = getValueFromDataMap(dc, "annualRetirementContributionIncrease", TC_ID);
        this.socialSecurityOverride = getValueFromDataMap(dc, "socialSecurityOverride", TC_ID);
       this.numberOfYearsRetirement = getValueFromDataMap(dc, "numberOfYearsRetirement", TC_ID);
        this.percentOfinFalAnnualIncomeDesired = getValueFromDataMap(dc, "percentOfinFalAnnualIncomeDesired", TC_ID);
        this.preRetirementInvestmentReturn = getValueFromDataMap(dc, "preRetirementInvestmentReturn", TC_ID);
       this.postRetirementInvestmentReturn = getValueFromDataMap(dc, "postRetirementInvestmentReturn", TC_ID);
        this.additionalOtherIncome = getValueFromDataMap(dc, "additionalOtherIncome", TC_ID);
    }

    public String getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }

    public String getRetirement() {
        return retirement;
    }

    public void setRetirement(String retirement) {
        this.retirement = retirement;
    }

    public String getSocialSecurityOverride() {
        return socialSecurityOverride;
    }

    public void setSocialSecurityOverride(String socialSecurityOverride) {
        this.socialSecurityOverride = socialSecurityOverride;
    }

    public String getAdditionalOtherIncome() {
        return additionalOtherIncome;
    }

    public void setAdditionalOtherIncome(String additionalOtherIncome) {
        this.additionalOtherIncome = additionalOtherIncome;
    }

    public String getCurrentAnnualIncome() {
        return currentAnnualIncome;
    }

    public void setCurrentAnnualIncome(String currentAnnualIncome) {
        this.currentAnnualIncome = currentAnnualIncome;
    }

    public String getSpouseAnnualIncome() {
        return spouseAnnualIncome;
    }

    public void setSpouseAnnualIncome(String spouseAnnualIncome) {
        this.spouseAnnualIncome = spouseAnnualIncome;
    }

    public String getCurrentRetireSavings() {
        return currentRetireSavings;
    }

    public void setCurrentRetireSavings(String currentRetireSavings) {
        this.currentRetireSavings = currentRetireSavings;
    }

    public String getCurrentRetireContribution() {
        return currentRetireContribution;
    }

    public void setCurrentRetireContribution(String currentRetireContribution) {
        this.currentRetireContribution = currentRetireContribution;
    }

    public String getAnnualRetirementContributionIncrease() {
        return annualRetirementContributionIncrease;
    }

    public void setAnnualRetirementContributionIncrease(String annualRetirementContributionIncrease) {
        this.annualRetirementContributionIncrease = annualRetirementContributionIncrease;
    }

    public String getSocial_Security_income() {
        return socialSecurityOverride;
    }

    public void setSocial_Security_income(String social_Security_income) {
        socialSecurityOverride = social_Security_income;
    }

    public String getNumberOfYearsRetirement() {
        return numberOfYearsRetirement;
    }

    public void setNumberOfYearsRetirement(String numberOfYearsRetirement) {
        this.numberOfYearsRetirement = numberOfYearsRetirement;
    }

    public String getPercentOfinFalAnnualIncomeDesired() {
        return percentOfinFalAnnualIncomeDesired;
    }

    public void setPercentOfinFalAnnualIncomeDesired(String percentOfinFalAnnualIncomeDesired) {
        this.percentOfinFalAnnualIncomeDesired = percentOfinFalAnnualIncomeDesired;
    }

    public String getPreRetirementInvestmentReturn() {
        return preRetirementInvestmentReturn;
    }

    public void setPreRetirementInvestmentReturn(String preRetirementInvestmentReturn) {
        this.preRetirementInvestmentReturn = preRetirementInvestmentReturn;
    }

    public String getPostRetirementInvestmentReturn() {
        return postRetirementInvestmentReturn;
    }

    public void setPostRetirementInvestmentReturn(String postRetirementInvestmentReturn) {
        this.postRetirementInvestmentReturn = postRetirementInvestmentReturn;
    }

    public Map<String, String> getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(Map<String, String> expectedResult) {
        this.expectedResult = expectedResult;
    }
}
