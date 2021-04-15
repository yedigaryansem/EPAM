package rest.gorestcoIn.utils.helpermethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import rest.gorestcoIn.utils.User;

public class ApiCal {

    public static Response post(User user, Header header, String endPoint) {

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

    public static Response delete(int id, Header header,String endPoint) {
        return RestAssured
                .given()
                .header(header)
                .delete(endPoint + id)
                .thenReturn();
    }
}