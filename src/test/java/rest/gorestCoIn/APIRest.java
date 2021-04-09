package rest.gorestCoIn;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APIRest{

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public-api/";

    }

    @Test
    public void postUser() {

        Header header = new Header("Authorization", "Bearer 73e824b7f681b6e4d47c97ed07c2e26f6f91effd9a3496aad4f4960798709544");

        String body = """
                    {
                    "name": "test",
                    "email": "test@tesssssssst.io",
                    "gender": "Male",
                    "status": "Active"
                    }
                """;

        ValidatableResponse response = RestAssured
                .given()
                .header(header)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("users")
                .then();


        response.extract().response().prettyPrint();

        response = RestAssured
                .given()
                .when()
                .get("users/")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

    }
}