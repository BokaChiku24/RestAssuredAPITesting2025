package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SendPOSTRequestUsingRestAssured {

    public static void main(String[] args) {
        Response response = given().auth().basic("username/token",
                "password/leave it bank in case of token")
                .formParam("parameterName", "value")
                .post("post url");
        response.prettyPrint();

        // -----------------------------------------------------------------

        String jsonBody = "{\"email\":\"test@gamil.com\"}";
        Response response1 = given().contentType(ContentType.JSON).body(jsonBody)
                             .post("URI");
        response1.prettyPrint();

        // -----------------------------------------------------------------

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "test@gamil.com");
        Response response2 = given().contentType(ContentType.JSON).body(map)
                             .post("URI");
        response2.prettyPrint();

        // -----------------------------------------------------------------

        Response response3 = given().contentType(ContentType.JSON)
                            .body(new File("JSON File Path")).log().all()
                            .post("URI");
        response3.prettyPrint();
    }

}
