package testNgTests;

import testNG.RestAssuredConfiguration;
import com.google.gson.Gson;
import testDataType.City;
import testDataType.WR;
import testDataType.Weather;
import testNG.EndPoint;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WeatherReport {

    @Test
    public void validateCountries() {
        given().get(EndPoint.GET_ALL_COUNTRIES).then().statusCode(200).log().all();
    }

    @Test
    public void validateCountriesQueryParams() {

        // Get requirement specification = RestAssured.given().ContentType(ContentType.json)
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();

        // Updated requirement specification with Query parameter and log the same
        requestSpecification.queryParam("key", "N8DyZwa5D69oTGYyX").log().all();

        // Submit the request with End Point URL and check the status code
        given().spec(requestSpecification).get(EndPoint.GET_ALL_COUNTRY).then().statusCode(200).log().all();
    }

    @Test
    public void validateStatesQueryParams() {

        // Create Map reference to store the multiple query parameter
        Map<String, String> queryParams = new HashMap();
        queryParams.put("country", "USA");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");

        // Get the requirement specification (RestAssured.Given().ContentType(ContentType.json)
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();

        //  Updated requirement specification with Query parameter and log the same
        requestSpecification.queryParams(queryParams).log().all();

        // Submit the request with End Point URL and check the status code
        given().spec(requestSpecification).get(EndPoint.GET_ALL_STATE).then().statusCode(200).log().all();
    }

    @Test(groups = "demo")
    public void validateCityQueryParams() {

        Map<String, String> queryParams = new HashMap();
        queryParams.put("country", "USA");
        queryParams.put("state", "New York");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParams(queryParams).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_ALL_CITIES).then().statusCode(200).log().all();

        // Getting Response
        Response response = given().spec(requestSpecification).get(EndPoint.GET_ALL_CITIES);

        // Assert Response Time
        Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS) <= 10, "Response Time is not with in limit.");

        // Hard Assertion
        response.then().body("data[0].city", equalTo("Addison"));

        // Soft Assertion
        response.then().body("data[0].city", equalTo("Addison"), "data[1].city", equalTo("Albany"),
                "data[2].city", equalTo("Buffalo"), "data[3].city", equalTo("Carmel"));


        // Path Validation
        // Hard Assertion
        Assert.assertEquals(response.path("data[0].city"), "Addison");
        // Soft Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.path("data[0].city"), "Addison");
        softAssert.assertEquals(response.path("data[1].city"), "Albany");
        softAssert.assertEquals(response.path("data[2].city"), "Buffalo");
        softAssert.assertAll();

        // Java object 1st way
        Weather weather = response.as(Weather.class, ObjectMapperType.GSON);
        List<City> data = weather.getData();
        data.forEach(s ->
        {
            softAssert.assertNotEquals(s.getCity(), "", "City Blank");
            softAssert.assertNotEquals(s.getCity(), null, "City Null");
        });
        softAssert.assertAll();

        Gson gson = new Gson();
        WR wr = response.as(WR.class, ObjectMapperType.GSON);

        softAssert.assertEquals(wr.status, "success");
        softAssert.assertTrue(wr.data.stream().anyMatch(s -> s.city.equals("Addison")), "Fail to identify 'Addison' in the list");
        softAssert.assertTrue(wr.data.stream().filter(s -> s.city.equals("Addison")).findAny().isPresent(), "Fail to identify 'Addison' in the list");
        softAssert.assertAll();
    }

    @Test
    public void validateNearestCityQueryParams() {
        Map<String, String> queryParams = new HashMap();
        queryParams.put("lat", "48.02");
        queryParams.put("lon", "50.02");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParams(queryParams).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_NEAREST_CITY).then().statusCode(200).log().all();
    }
}
