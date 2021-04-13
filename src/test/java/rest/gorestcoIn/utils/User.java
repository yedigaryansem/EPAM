package rest.gorestcoIn.utils;

import io.restassured.path.json.JsonPath;

public class User {
    private String name;
    private String email;
    private String gender;
    private String status;

    public User(String body){

        JsonPath jsonPath = new JsonPath(body);

        this.name = jsonPath.get("name");
        this.email = jsonPath.get("email");
        this.gender = jsonPath.get("gender");
        this.status = jsonPath.get("status");
    }

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
