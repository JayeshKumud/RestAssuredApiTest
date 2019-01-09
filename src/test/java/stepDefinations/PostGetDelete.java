package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PostGetDelete {
    @Given("^User perform POST operation for \"([^\"]*)\" endpoint with body as$")
    public void userPerformPOSTOperationForEndpointWithBodyAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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
