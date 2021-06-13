package net.fakerestapi.APITestingFramework.apis;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import net.fakerestapi.APITestingFramework.base.BaseTest;


public class GetlistAPI extends BaseTest {

    public int getStatusCode(){
        int statusCode =given()
                            .get("/api/v1/Books")
                            .getStatusCode();
        return statusCode;
    }

    public ResponseBody getResponseBody(){
        ResponseBody responseBody =given()
                        .get("/api/v1/Books")
                        .getBody();
        return responseBody;
    }

    public boolean findBook(String book){
        ResponseBody responseBody = getResponseBody();
        JsonPath jsonPath = responseBody.jsonPath();
        List<String> listTitles = jsonPath.getList("title");
        if (listTitles.contains(book)) {
            return true;
        }
        return false;
    }

    public int countBook(){
        ResponseBody responseBody = getResponseBody();
        JsonPath jsonPath = responseBody.jsonPath();
        List<String> listTitles = jsonPath.getList("id");
        return listTitles.size();
    }
}
