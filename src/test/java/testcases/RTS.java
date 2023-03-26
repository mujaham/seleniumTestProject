package testcases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RTS {

    @Test
    public void getRequest(){

        Response res = given().get("https://www.boredapi.com/api/activity").then().extract().response();
        int statusCode = res.getStatusCode();
        Assert.assertEquals(200, statusCode);
        JsonPath json= res.jsonPath();
        Assert.assertEquals(json.get("type"), "Cooking");


//        given().when().get("https://www.boredapi.com/api/activity")
//                .then()
//                .assertThat().statusCode(200);

    }

    @Test
    public void putRequest(){
        String payload= "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

       Response res =  given().body(payload) .put("https://reqres.in/api/users/2");
        int statusCode = res.getStatusCode();
        Assert.assertEquals(200, statusCode);

    }
}
