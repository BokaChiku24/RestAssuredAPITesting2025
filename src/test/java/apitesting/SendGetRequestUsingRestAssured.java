package apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SendGetRequestUsingRestAssured {

    public static void main(String[] args) {
        RestAssured.baseURI="";
        Response response = given().auth().basic("username/token",
                "password/leave it bank in case of token").when().get("URI");

        response.prettyPrint();
        System.out.println("Response code is: "+ response.statusCode());

        // AAlternative for line 15

        String jsonResponse = response.asString();
        System.out.println(jsonResponse);


        given().param("limit", 3).auth().basic("username/token",
                "password/leave it bank in case of token").when().get("URI");
        // given().contentType(ContentType.JSON);
        // given().contentType("application/json");
        // given().header("content-type","application/json");
    }
}
