package validation.jsonpath;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ExtractFieldValuesFromResponse {
    public static void main(String[] args) {
        Response reponse = given().auth().basic("token", "")
                .formParam("name", "Rahul")
                .formParam("email", "trainer@waygoogle.com")
                .formParam("preferred_locals[0]", "yes")
                .formParam("address.[line1]", "A-131 New Mumbai")
                .when().post("uri");

        reponse.prettyPrint();

        JsonPath path = reponse.jsonPath();

        System.out.println("ID is = " + path.get("id"));

        System.out.println(reponse.jsonPath().get("name").toString());

        System.out.println(reponse.jsonPath().get("address.line1").toString());

        System.out.println(reponse.jsonPath().get("preferred_locals[0]").toString());

        System.out.println(reponse.jsonPath().getMap("$").size());

        System.out.println(reponse.jsonPath().getMap("address").size());

        System.out.println(reponse.jsonPath().getList("preferred_locals").size());


    }
}
