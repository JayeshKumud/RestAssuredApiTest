package com.test;

import com.framework.RestAssuredConfiguration;
import com.test.common.EndPoint;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class WeatherReport {

    @Test
    public void validateCountries(){
        given().get(EndPoint.GET_ALL_COUNTRIES).then().statusCode(200).log().all();
    }

    @Test
    public void validateCountriesQueryParams(){
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam("key", "N8DyZwa5D69oTGYyX").log().all();
        given().spec(requestSpecification).get(EndPoint.GET_ALL_COUNTRY).then().statusCode(200).log().all();
    }

    @Test
    public void validateStatesQueryParams(){
        Map<String, String> queryParams = new HashMap();
        queryParams.put("country", "USA");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParams(queryParams).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_ALL_STATE).then().statusCode(200).log().all();
    }

    @Test
    public void validateCityQueryParams(){
        Map<String, String> queryParams = new HashMap();
        queryParams.put("lat", "USA");
        queryParams.put("lon", "New York");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParams(queryParams).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_ALL_CITIES).then().statusCode(200).log().all();
    }

    @Test(groups = "demo")
    public void validateNearestCityQueryParams(){
        Map<String, String> queryParams = new HashMap();
        queryParams.put("lat", "48.02");
        queryParams.put("lon", "50.02");
        queryParams.put("key", "N8DyZwa5D69oTGYyX");
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParams(queryParams).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_NEAREST_CITY).then().statusCode(200).log().all();
    }
}
