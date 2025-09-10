package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ParseComplexJSONInBody {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email,", "test@gmail.com");
        map.put("firstName,", "KC");
        map.put("lastName", "Chavan");

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(234232346);
        arrayList.add(115475663);

        map.put("mobile",arrayList);

        HashMap<String, String> address = new HashMap<String, String>();
        address.put("flatNo,", "test@gmail.com");
        address.put("city,", "KC");
        address.put("state", "Maharashtra");
        map.put("address,", address);

        Response response = given().contentType(ContentType.JSON)
                            .body(new File("..")).log().all()
                            .post("....");
        response.prettyPeek();
    }
}
