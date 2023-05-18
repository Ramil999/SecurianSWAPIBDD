package utilities;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CommonApiService {

    private String endpoint;
    Response response;

    public CommonApiService(String endpoint) {
        this.endpoint = endpoint;
    }

    public Response doGetRestRequest(String serviceName) {
        if(serviceName.contains("SWAPI")) {
            response =
                    given()
                            .log().all()
                            .baseUri(ConfigurationReader.getProperty("swapiService"))
                            .when()
                            .get();
            response.prettyPeek();
            return response;
        }else{
            return null;
        }
    }
}
