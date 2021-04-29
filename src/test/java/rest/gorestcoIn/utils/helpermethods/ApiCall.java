package rest.gorestcoIn.utils.helpermethods;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import okhttp3.Request;
import rest.gorestcoIn.utils.User;

public class ApiCall {

    public static Response post(User user, String endPoint) {

        return RestAssured
                .given()
                .spec(getRequestSpecification())
                .body(user)
                .post(endPoint)
                .thenReturn();
    }

    public static Response get(String endPoint, int id) {

        return RestAssured.
                get(endPoint + id).thenReturn();
    }

    public static Response delete(int id, String endPoint) {
        return RestAssured
                .given()
                .spec(getRequestSpecification())
                .delete(endPoint + id)
                .thenReturn();
    }

    private static RequestSpecification getRequestSpecification() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        return specBuilder
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer 73e824b7f681b6e4d47c97ed07c2e26f6f91effd9a3496aad4f4960798709544")
                .build();
    }
}