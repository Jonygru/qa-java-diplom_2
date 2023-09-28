package org.example.order;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApiOrder {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String API_V_1 = "/api";

    public ValidatableResponse createOrderWithoutAutorization(Ingredients ingredients){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(ingredients)
                .when()
                .post(API_V_1 + "/orders")
                .then().log().all();
    }
    public ValidatableResponse createOrderWithAutorization(Ingredients ingredients, String token){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .body(ingredients)
                .when()
                .post(API_V_1 + "/orders")
                .then().log().all();
    }
    public ValidatableResponse getOrderUserWithoutAutorization(){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(API_V_1 + "/orders")
                .then().log().all();
    }
    public ValidatableResponse getOrderUserWithAutorization(String token){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .get(API_V_1 + "/orders")
                .then().log().all();
    }
}
