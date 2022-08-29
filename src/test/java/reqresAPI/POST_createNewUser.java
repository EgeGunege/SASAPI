package reqresAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class POST_createNewUser {
    String baseURI = RestAssured.baseURI = "https://reqres.in/api";
    String path = "users";
    @Test(description = "Post Create a New User")
    void createNewUser(){
        String name = "morpheus";
        String job = "leader";
        JSONObject newUserObject = new JSONObject();
        newUserObject.put("name",name);
        newUserObject.put("job",job);

        String newUserPayload = newUserObject.toString();

        Response createNewUser = given().header("Content-Type","application/json").body(newUserPayload).post(path);
        createNewUser.getBody().prettyPrint();
        createNewUser.then().assertThat().statusCode(201);

    }
}
