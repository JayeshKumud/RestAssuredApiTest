package cucumber;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification request;

    public RestAssuredExtension(){
        // Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> getOps(String endPoint) {
        return request.get(endPoint);
    }

    public static ResponseOptions<Response> getOpsWithPathParams(String endPoint, Map<String, String> pathParams) {
        request.pathParams(pathParams);
        return request.get(endPoint);
    }

    public static ResponseOptions<Response> deleteOpsWithPathParams(String endPoint, Map<String, String> pathParams){
        request.pathParams(pathParams);
        return request.delete(endPoint);
    }

    public static ResponseOptions<Response> postOpsWithBody(String endPoint, Map<String, String> body){
        request.body(body);
        return request.post(endPoint);
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String endPoint, Map<String, String> pathParams, Map<String, String> body) {
        request.pathParams(pathParams);
        request.body(body);
        return request.post(endPoint);
    }

}
