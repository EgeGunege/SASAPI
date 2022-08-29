package reqresAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class POST_login {
    String baseURI = RestAssured.baseURI = "https://reqres.in/api";
    String path = "login";
    String email = "eve.holt@reqres.in";
    String password = "cityslicka";

    @Test(description = "Post successful Login")
    void successfulLogin(){
        JSONObject loginObject = new JSONObject();
        loginObject.put("email",email);
        loginObject.put("password",password);
        String loginPayload = loginObject.toString();

        String expectedToken = "QpwL5tke4Pnpja7X4";

        Response loginResponse = given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .post(path)
                .then().extract().response();
        loginResponse.then().assertThat().statusCode(200);
        loginResponse.getBody().prettyPrint();
        String actualToken = loginResponse.jsonPath().getString("token");
        Assert.assertEquals(actualToken,expectedToken);
    }
    @Test(description = "Post unsuccessful Login")
    void unsuccessfulLogin(){
        JSONObject loginObject = new JSONObject();
        loginObject.put("email",email);
        String loginPayload = loginObject.toString();

        String expectedError = "Missing password";
        Response loginResponse = given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .post(path)
                .then().extract().response();
        loginResponse.then().assertThat().statusCode(400);
        loginResponse.getBody().prettyPrint();
        String actualError = loginResponse.jsonPath().getString("error");
        Assert.assertEquals(actualError,expectedError);
    }
}
