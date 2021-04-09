package rest.gorestCoIn;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import rest.gorestCoIn.utils.User;
import rest.gorestCoIn.utils.helperMethodsForGorestCoIn.APICal;

public class APIRest{

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public-api/";

    }

    @Test
    public void postUser() {

        Header header = new Header("Authorization", "Bearer 73e824b7f681b6e4d47c97ed07c2e26f6f91effd9a3496aad4f4960798709544");

        String body = "{\n" +
                      "\"name\": \"tester\",\n" +
                      "\"email\": \"tesdsdsdsstssststs@test.io\",\n" +
                      "\"gender\": \"Male\",\n" +
                      "\"status\": \"Active\"\n" +
                      "}";
        User user = new User(body);

        Response response = APICal.post(body, header);

        Assert.assertEquals(response.getStatusCode(), 200);

        int id = response.path("data.id");

        Response response1 = APICal.get(id);

        Assert.assertEquals(response1.getStatusCode(),200);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.path("data.name"),user.getName());
        softAssert.assertEquals(response.path("data.email"),user.getEmail());
        softAssert.assertEquals(response.path("data.status"),user.getStatus());
        softAssert.assertEquals(response.path("data.gender"),user.getGender());
        softAssert.assertAll();

        Response response2 = APICal.delete(id, header);

        Assert.assertEquals(response2.getStatusCode(),200);

        response1 = APICal.get(id);

        Assert.assertEquals(response1.path("data.message"),"Resource not found");
    }
}