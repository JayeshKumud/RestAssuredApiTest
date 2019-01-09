package stepDefinations;

import cucumber.RestAssuredExtension;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class PostSteps {

    private static ResponseOptions<Response> response;

    @Given("^User perform POST operation for \"([^\"]*)\" endpoint with below body$")
    public void userPerformPOSTOperationForEndpointWithBelowBody(String endPoint, DataTable table) throws Throwable {

        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("profileNumber", mapList.get(0).get("profile"));

        Map<String, String> body = new HashMap<>();
        body.put("name", mapList.get(0).get("name"));

        response = RestAssuredExtension.PostOpsWithBodyAndPathParams(endPoint, pathParams, body);
    }

    @And("^User should see body has name \"([^\"]*)\"$")
    public void userShouldSeeBodyHasName(String name) throws Throwable {
        assertThat(response.getBody().jsonPath().get("name"), Matchers.equalTo(name));
    }
}
