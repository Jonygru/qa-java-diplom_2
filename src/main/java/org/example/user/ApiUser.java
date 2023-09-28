package org.example.user;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApiUser {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String API_V_1 = "/api/auth";

    public ValidatableResponse createUser(FullUser fullUser){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(fullUser)
                .when()
                .post(API_V_1 + "/register")
                .then().log().all();
    }
    public String getToken(ValidatableResponse response){
        String token =
                response.extract().path("accessToken");
        return token;
    }

    public String getRefreshToken(ValidatableResponse response){
        String refreshToken =
                response.extract().path("refreshToken");
        return refreshToken;
    }

    public ValidatableResponse logInUser(Creds creds){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(creds)
                .when()
                .post(API_V_1 + "/login")
                .then().log().all();
    }

    public ValidatableResponse logOutUser(String refreshToken){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(refreshToken)
                .when()
                .post(API_V_1 + "/logout")
                .then().log().all();
    }
    public UserChangeRespons changeUser(String token, EditUser editUser){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .body(editUser)
                .when()
                .patch(API_V_1 + "/user")
                .body().as(UserChangeRespons.class);

    }
    public UserChangeRespons getUser(String token){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .get(API_V_1 + "/user")
                .body().as(UserChangeRespons.class);
    }
    public ValidatableResponse deleteUser(String token){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .delete(API_V_1 + "/user")
                .then().log().all();
    }
    public ValidatableResponse changeUserUnAuthorization(EditUser editUser){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(editUser)
                .when()
                .patch(API_V_1 + "/user")
                .then().log().all();

    }




}
