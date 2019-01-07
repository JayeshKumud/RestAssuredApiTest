package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class GET {

    @Given("^User perform GET operation for \"([^\"]*)\" end point$")
    public void userPerformGETOperationForEndPoint(String basePath) throws Throwable {
        RestAssured.basePath = basePath;
    }

    @And("^User perform GET operation for \"([^\"]*)\" params$")
    public void userPerformGETOperationForParams(String params) throws Throwable {
        RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON);
        requestSpecification.param(params).then().body("author", containsInAnyOrder("", "", null));
    }

    @Then("^User should see the author name as \"([^\"]*)\"$")
    public void userShouldSeeTheAuthorNameAs(String author) throws Throwable {

    }
}
