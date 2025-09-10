package creatingJson;

import creatingJson.pojoclass.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreatingJSONRuntimeUsingPOJO {
    public static void main(String[] args) {
        User obj = new User("test@gmail.com", "Kunal", "Chavan", "Apt-14", "Pune", "Maharashtra", "India");
        obj.setMobileNumbers(1234567890, 876567456, 977865454);
        Response response = given().contentType(ContentType.JSON).body(obj).log().all()
                .post("uri");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
