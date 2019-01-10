package stepDefinations;

import cucumber.RestAssuredExtension;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import testDataType.Posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGetDelete {

    private static ResponseOptions<Response> response;

    @Given("^User perform POST operation for \"([^\"]*)\" endpoint with body as$")
    public void userPerformPOSTOperationForEndpointWithBodyAs(String endPoint, DataTable table) throws Throwable {

        List<Posts> posts = table.asList(Posts.class);
        System.out.println(posts.get(0).id);
        System.out.println(posts.get(0).author);
        System.out.println(posts.get(0).title);

        //response = RestAssuredExtension.postOpsWithBody(endPoint, body);
    }

    @And("^User perform GET operation for path parameter \"([^\"]*)\"$")
    public void userPerformGETOperationForPathParameter(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User should see body with title as \"([^\"]*)\"$")
    public void userShouldSeeBodyWithTitleAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User perform DELETE operation for \"([^\"]*)\"$")
    public void userPerformDELETEOperationFor(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User should not see body with title as \"([^\"]*)\"$")
    public void userShouldNotSeeBodyWithTitleAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
