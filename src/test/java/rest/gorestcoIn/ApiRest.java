package rest.gorestcoIn;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import rest.gorestcoIn.utils.User;
import rest.gorestcoIn.utils.helpermethods.ApiCal;

public class ApiRest {
    private String endPoint = "users/";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public-api/";

    }

    @Test
    public void postUser() {

        Header header = new Header("Authorization", "Bearer 73e824b7f681b6e4d47c97ed07c2e26f6f91effd9a3496aad4f4960798709544");



        User user = new User();

        Response responseForPost = ApiCal.post(user, header,endPoint);

        Assert.assertEquals(responseForPost.getStatusCode(), 200);

        int id = responseForPost.path("data.id");

        Response responseForGet = ApiCal.get(endPoint,id);

        Assert.assertEquals(responseForGet.getStatusCode(), 200);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseForGet.path("data.name"), user.getName());
        softAssert.assertEquals(responseForGet.path("data.email"), user.getEmail());
        softAssert.assertEquals(responseForGet.path("data.status"), user.getStatus());
        softAssert.assertEquals(responseForGet.path("data.gender"), user.getGender());
        softAssert.assertAll();

        Response responseForDel = ApiCal.delete(id, header, endPoint);

        Assert.assertEquals(responseForDel.getStatusCode(), 200);

        responseForGet = ApiCal.get(endPoint,id);

        Assert.assertEquals(responseForGet.getStatusCode(), 200);
        Assert.assertEquals(responseForGet.path("data.message"), "Resource not found");

    }
}