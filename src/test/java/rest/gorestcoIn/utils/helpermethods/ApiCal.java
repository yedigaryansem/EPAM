package rest.gorestcoIn.utils.helpermethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import rest.gorestcoIn.utils.User;

public class ApiCal {
    private static final Header header = new Header("Authorization", "Bearer 73e824b7f681b6e4d47c97ed07c2e26f6f91effd9a3496aad4f4960798709544");

    public static Response post(User user, String endPoint) {

        return RestAssured
                .given()
                .header(header)
                .contentType(ContentType.JSON)
                .body(user)
                .post(endPoint)
                .thenReturn();
    }

    public static Response get(String endPoint,int id) {

        return RestAssured.
                get(endPoint + id).thenReturn();
    }

    public static Response delete(int id, String endPoint) {
        return RestAssured
                .given()
                .header(header)
                .delete(endPoint + id)
                .thenReturn();
    }
}