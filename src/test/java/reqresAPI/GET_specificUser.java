package reqresAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GET_specificUser {
    String baseURI = RestAssured.baseURI = "https://reqres.in/api";
    String path = "users";
    @Test(description = "Get valid specific user information")
    void validSpecificUser(){
        Response specificUser = given().pathParam("id",2).get(path+"/{id}");
        specificUser.getBody().prettyPrint();
        specificUser.then().assertThat().statusCode(200);
    }
    @Test(description = "Get invalid specific user information")
    void invalidSpecificUser(){
        Response specificUser = given().pathParam("id",23).get(path+"/{id}");
        specificUser.getBody().prettyPrint();
        specificUser.then().assertThat().statusCode(404);
    }
}
