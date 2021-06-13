package net.fakerestapi.APITestingFramework.apis;

import static io.restassured.RestAssured.given;
import java.io.File;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.fakerestapi.APITestingFramework.base.BaseTest;
import org.hamcrest.Matchers;


public class GetBookAPI extends BaseTest {

    public int getStatusCode(int bookID){
        int statusCode =given()
                            .get("/api/v1/Books/" + bookID)
                            .getStatusCode();
        return statusCode;
    }

    public void validateJSONSchema(int bookID){
        given()
                .get("/api/v1/Books/" + bookID)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File((System.getProperty("user.dir")+"\\src\\test\\resources\\schema\\schema_book.json"))));
    }
}
