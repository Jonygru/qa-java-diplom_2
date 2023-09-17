package org.example.user;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

public class CheckUser {

    public void createUserSaccess(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    public void createCloneUser(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .body("message", equalTo("User already exists"))
                .body("success", equalTo(false));

    }
    public void createUserNotHaveAnyField(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .body("message", equalTo("Email, password and name are required fields"))
                .body("success", equalTo(false));

    }
    public void logInUserSaccess(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    public void ligInUserNotReal(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("message", equalTo("email or password are incorrect"))
                .body("success", equalTo(false));

    }

    public void changeUser(User user, String email, String name){
        Assert.assertEquals(user.getEmail(), email);
        Assert.assertEquals(user.getName(), name);

    }
    public void changeUserUnAuthorization(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("message", equalTo("You should be authorised"))
                .body("success", equalTo(false));

    }
}
