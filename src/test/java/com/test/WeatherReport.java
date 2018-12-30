package com.test;

import com.framework.RestAssuredConfiguration;
import com.google.gson.Gson;
import com.test.bin.Datum;
import com.test.bin.Weather;
import com.test.common.EndPoint;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WeatherReport {

    @Test
    public void validateCountries() {
        given().get(EndPoint.GET_ALL_COUNTRIES).then().statusCode(200).log().all();
    }

    @Test
    public void validateCountriesQueryParams() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam("key", "N8DyZwa5D69oTGYyX").log().all();
        given().spec(requestSpecification).get(EndPoint.GET_ALL_COUNTRY).then().statusCode(200).log().all();
    }

    @Test
    public void validateStatesQueryParams() {
        Map<String, String> queryParams = new HashMap();
        queryParams.put("country", "USA");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParams(queryParams).log().all();
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
        List<Datum> data = weather.getData();
        data.forEach(s ->
        {
            softAssert.assertNotEquals(s.getCity(), "", "City Blank");
            softAssert.assertNotEquals(s.getCity(), null, "City Null");
        });
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
