package reqresAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DELETE_user {
    String baseURI = RestAssured.baseURI = "https://reqres.in/api";
    String path = "users";
    @Test(description = "DELETE an user")
    void deleteUser(){
        Response deleteUser = given().pathParam("id",2).delete(path+"/{id}");
        deleteUser.then().assertThat().statusCode(204);
    }
}
