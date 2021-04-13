package rest.gorestcoIn.utils.helpermethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class APICal {

    public static Response post(String jsonBody, Header header) {

        return RestAssured
                .given()
                .header(header)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .post("users")
                .thenReturn();
    }

    public static Response get(int id) {

        return RestAssured.
                get("users/" + id).thenReturn();
    }

    public static Response delete(int id, Header header) {
        return RestAssured
                .given()
                .header(header)
                .delete("users/" + id)
                .thenReturn();
    }
}