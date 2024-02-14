package utilities;
import io.restassured.internal.support.Prettifier;
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
                           // .pathParam("name","Luke Skywalker")
                            .when()
                            .get();

            response.prettyPeek();
            //    response.prettyPrint();

//            Prettifier prettifier = new Prettifier();
//            String prettyResponseBody = prettifier.getPrettifiedBodyIfPossible(response, response.getBody());
//            System.out.println(   prettyResponseBody.contains("Ramil"));
           // System.out.println(prettyResponseBody);

            return response;
        }else{
            return null;
        }
    }
}
