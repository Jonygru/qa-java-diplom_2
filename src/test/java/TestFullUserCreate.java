import io.restassured.response.ValidatableResponse;

import org.example.user.*;
import org.junit.After;
import org.junit.Test;


public class TestFullUserCreate {
    FullUser fullUser;
    String token;
    ValidatableResponse userResponse;
    private final UserGenerator userGenerator = new UserGenerator();
    private final ApiUser endpoint = new ApiUser();
    private final CheckUser check = new CheckUser();


    @Test
    public void createNewUser() {
        fullUser = userGenerator.generic();
        userResponse = endpoint.createUser(fullUser);
        check.createUserSaccess(userResponse);
    }

    @Test
    public void createCloneUser() {
        fullUser = userGenerator.generic();
        userResponse = endpoint.createUser(fullUser);
        ValidatableResponse userResponseCheck = endpoint.createUser(fullUser);
        check.createCloneUser(userResponseCheck);
    }

    @After
    public void deleteUser(){
        token = endpoint.getToken(userResponse);
        endpoint.deleteUser(token);
    }

}
