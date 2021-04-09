package rest.gorestCoIn.utils.helperMethodsForGorestCoIn;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class APICal {

    public static Response post(String jsonBody, Header header){

        ValidatableResponse response = RestAssured
                .given()
                .header(header)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("users")
                .then();

        return response.extract().response();
    }

    public static Response get(int id){
        ValidatableResponse response = RestAssured
                .given()
                .when()
                .get("users/" + id)
                .then();

        return response.extract().response();
    }

    public static Response delete(int id, Header header){
        ValidatableResponse response = RestAssured
                .given()
                .header(header)
                .when()
                .delete("users/" + id)
                .then();

        return response.extract().response();
    }
}

