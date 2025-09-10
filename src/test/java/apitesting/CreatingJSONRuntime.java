package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreatingJSONRuntime {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("email", "test@gmail.com");
        object.put("firstName", "Rahul");
        object.put("lastName", "Aurora");

        JSONArray listOfMobiles = new JSONArray();
        listOfMobiles.put(896758273);
        listOfMobiles.put(232358273);

        object.put("mobile", listOfMobiles);

        JSONObject address = new JSONObject();
        address.put("flatNo", "A-131");
        address.put("city", "Pune");
        address.put("State", "Maharashtra");
        address.put("country", "India");

        object.put("address", address);

        Response response = given().contentType(ContentType.JSON).body(object.toString())
                                   .post("uri");

        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }
}
