package steps;

import databean.Services;
import databean.SwapiDatabean;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import stepValidation.SwapiValidation;
import utilities.CommonApiService;
import utilities.Constants;

public class SwapiSteps {

    SwapiValidation swapiValidation = new SwapiValidation();
    Response response;
    SwapiDatabean swapiDatabean ;
    String jsonBody;

    @Then("I create request for {string} service with {string}")
    public void peopleEndpointIs(String service,String testDataKey) {
        if (service.equalsIgnoreCase(Constants.SWAPI_SERVICE)) {
            swapiDatabean = new SwapiDatabean(Services.SWAPI_SERVICE, testDataKey);
        }
    }

    @When("I do get request to {string} service")
    public void doGetRequestToService(String serviceName) {
        CommonApiService commonApiService = new CommonApiService(serviceName);
        Response responseGetCall = commonApiService.doGetRestRequest(serviceName);
        response=responseGetCall;
    }

    @Then("Validate {string} personal details")
    public void storePersonalDetailsOfUser(String key) {
        Assert.assertTrue(Constants.STATUS_CODE_200 == response.statusCode());
        swapiValidation.SwapiValidation(response.asString(),swapiDatabean);
    }
}
