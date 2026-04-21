package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ApiUtils {

    public static void setBaseUri() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public static Response get(String endpoint) {
        return RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response post(String endpoint, Map<String, Object> body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response delete(String endpoint) {
        return RestAssured
                .given()
                .log().all()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}