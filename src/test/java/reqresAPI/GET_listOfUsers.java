package reqresAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static io.restassured.RestAssured.*;

public class GET_listOfUsers {
    String baseURI = RestAssured.baseURI = "https://reqres.in/api";
    String path = "users";
    @Test(description = "Get list of users")
    void listOfUsers(){
        Response listOfUsers = given().get(path);
        listOfUsers.then().assertThat().statusCode(200);
        int totalUser = listOfUsers.getBody().path("total");
        System.out.println("Total User: " + totalUser);
        listOfUsers.getBody().prettyPrint();
    }
}
