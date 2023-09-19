package org.example.order;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.CoreMatchers.equalTo;

public class CheckOrder {
    public Integer createOrder(ValidatableResponse response){
        Integer number = response.assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("success", equalTo(true))
                .extract().path("order.number");

        return number;

    }
    public void createOrderWithoutIbgredients(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("success", equalTo(false))
                .body("message", equalTo("Ingredient ids must be provided"));


    }
    public void createOrderNotRealIbgredients(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
    public void getOrderWithAutorization(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("success", equalTo(true));
    }

    public void getOrderWithoutAutorization(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));
    }
}
