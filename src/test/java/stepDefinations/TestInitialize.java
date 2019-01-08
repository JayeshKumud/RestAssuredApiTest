package stepDefinations;

import cucumber.RestAssuredExtension;
import cucumber.api.java.Before;

public class TestInitialize {
    @Before
    public void Setup(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
