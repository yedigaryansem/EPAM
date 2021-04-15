package rest.gorestcoIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import rest.gorestcoIn.utils.User;
import rest.gorestcoIn.utils.helpermethods.ApiCal;

public class ApiRest {
    private final String endPoint = "users/";
    private int userID;

    private final Integer postStatusCode = 201;
    private final Integer errorStatusCode = 404;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public-api/";
    }

    @Test
    public void postUserTest() {

        User user = new User();

        Response responseForPost = ApiCal.post(user, endPoint);

        Assert.assertEquals(responseForPost.path("code"), postStatusCode);

        userID = responseForPost.path("data.id");

        Response responseForGet = ApiCal.get(endPoint, userID);

        Assert.assertEquals(responseForGet.getStatusCode(), 200);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseForGet.path("data.name"), user.getName());
        softAssert.assertEquals(responseForGet.path("data.email"), user.getEmail());
        softAssert.assertEquals(responseForGet.path("data.status"), user.getStatus());
        softAssert.assertEquals(responseForGet.path("data.gender"), user.getGender());
        softAssert.assertAll();

//      after posting user we should delete created user.
        ApiCal.delete(userID, endPoint);
    }

    @Test
    public void deleteUserTest() {

//      for deleting user we should post user.
        User user = new User();
        ApiCal.post(user, endPoint);

        Response responseForDel = ApiCal.delete(userID, endPoint);

        Assert.assertEquals(responseForDel.getStatusCode(), 200);

        Response responseForGet = ApiCal.get(endPoint, userID);

        Assert.assertEquals(responseForGet.path("code"), errorStatusCode);
        Assert.assertEquals(responseForGet.path("data.message"), "Resource not found");
    }
}