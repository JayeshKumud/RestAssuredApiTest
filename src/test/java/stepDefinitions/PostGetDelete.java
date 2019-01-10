package stepDefinitions;

import cucumber.RestAssuredExtension;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import testDataType.Posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGetDelete {

    private static ResponseOptions<Response> response;

    @Given("^User perform POST operation for \"([^\"]*)\" endpoint with body as$")
    public void userPerformPOSTOperationForEndpointWithBodyAs(String endPoint, DataTable table) throws Throwable {

        List<Posts> posts = table.asList(Posts.class);
        Map<String, String> body = new HashMap();
        body.put("id", posts.get(0).id);
        body.put("author", posts.get(0).author);
        body.put("title", posts.get(0).title);

        response = RestAssuredExtension.postOpsWithBody(endPoint, body);
    }

    @And("^User perform GET operation for path parameter \"([^\"]*)\"$")
    public void userPerformGETOperationForPathParameter(String endPoint, DataTable table) throws Throwable {
        List<Posts> posts = table.asList(Posts.class);
        Map<String, String> pathParams = new HashMap();
        pathParams.put("postId", posts.get(0).id);

        response = RestAssuredExtension.getOpsWithPathParams(endPoint, pathParams);

    }

    @And("^User should see body with title as \"([^\"]*)\"$")
    public void userShouldSeeBodyWithTitleAs(String title) throws Throwable {
        MatcherAssert.assertThat(response.body().jsonPath().get("title"), Matchers.is(title));
    }

    @And("^User perform DELETE operation for \"([^\"]*)\"$")
    public void userPerformDELETEOperationFor(String arg0) throws Throwable {
        System.out.println("Test");
    }

    @And("^User should not see body with title as \"([^\"]*)\"$")
    public void userShouldNotSeeBodyWithTitleAs(String arg0) throws Throwable {
        System.out.println("Test");
    }
}
