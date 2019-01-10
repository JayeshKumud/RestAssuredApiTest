package stepDefinitions;

import cucumber.RestAssuredExtension;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;


public class GetPostSteps {


    private static ResponseOptions<Response> response;

    @And("^User perform GET operation for \"([^\"]*)\" params$")
    public void userPerformGETOperationForParams(String param) throws Throwable {
        BddMethods.performGetEqual(param);
    }

    @Then("^User should see the author names$")
    public void userShouldSeeTheAuthorNames() {
        BddMethods.performContainsCollection("/posts");
    }

    @Then("^User should see list of Path parameter$")
    public void userShouldSeeListOfPathParameter() {
        BddMethods.performPathParameter();
    }

    @Then("^User should see list of Query parameter$")
    public void userShouldSeeListOfQueryParameter() {
        BddMethods.performQueryParameter();
    }


    @Given("^User perform GET operation for \"([^\"]*)\" endpoint$")
    public void userPerformGETOperationForEndpoint(String endPoint) throws Throwable {
        response = RestAssuredExtension.getOps(endPoint);
    }

    @Then("^User should see the author name as \"([^\"]*)\"$")
    public void userShouldSeeTheAuthorNameAs(String authorName) throws Throwable {
        MatcherAssert.assertThat(response.getBody().jsonPath().get("author"), Matchers.hasItem(authorName));
    }

    @Given("^User perform POST operation$")
    public void userPerformPOSTOperation() {
        //BddMethods.performPostWithBodyParameter();
    }


}
