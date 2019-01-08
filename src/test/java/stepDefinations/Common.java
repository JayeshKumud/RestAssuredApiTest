package stepDefinations;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class Common {
    @Given("^User perform \"([^\"]*)\" URL using REST Assured$")
    public void userPerformURLUsingRESTAssured(String url) throws Throwable {
        RestAssured.baseURI = url;
    }
}
