package stepDefinitions;

import cucumber.RestAssuredExtension;
import cucumber.api.java.Before;

public class Hook {
    @Before
    public void Setup(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
