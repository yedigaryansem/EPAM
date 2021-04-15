package rest.gorestcoIn.utils;

import io.restassured.path.json.JsonPath;

public class User {
    private String name = "tester" + System.currentTimeMillis();
    private String email = "tester" + System.currentTimeMillis() + "@test.io";
    private final String gender = "Male";
    private final String status = "Active";


    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}