package rest.gorestCoIn.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User {
    private String name;
    private String email;
    private String gender;
    private String status;
    String id = "1752";

    public User(String name,String email,String gender,String status){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
}
