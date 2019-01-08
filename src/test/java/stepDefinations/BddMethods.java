package stepDefinations;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class BddMethods {

    public static void performGetEqual(String postNumber){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000" + postNumber)
        .then()
                .body("author", Matchers.is("Jayesh"));
    }

    public static void performContainsCollection(String endPoint){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000" + endPoint)
        .then()
                .body("author", Matchers.containsInAnyOrder("Jayesh", "Jayesh", null));
    }

    public static void performPathParameter(){
        given()
                .contentType(ContentType.JSON)
        .with()
                .pathParam("post", "1")
        .when()
                .get("http://localhost:3000/posts/{post}")
        .then()
                .body("author", Matchers.containsString("Jayesh"));
    }

    public static void performQueryParameter(){
        given()
                .contentType(ContentType.JSON)
        .with()
                .queryParam("id", "2")
        .when()
                .get("http://localhost:3000/posts/")
        .then()
                .body("author", Matchers.hasItem("Jayesh"));

    }

    public static void peformPostWithBodyParameter(){

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "4");
        hashMap.put("title", "Rest Assure Course");
        hashMap.put("author", "Kumud");

        given()
                .contentType(ContentType.JSON)
        .with()
                .body(hashMap)
        .when()
                .post("http://localhost:3000/posts/")
        .then()
                .body("author", Matchers.hasItem("Kumud"));

    }

}
