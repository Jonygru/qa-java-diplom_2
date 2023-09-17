import io.restassured.response.ValidatableResponse;
import org.example.user.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestChanheUserUnAuthorization {
    private String email = "qwerasdf@yandex.ru";
    private String name = "Stepan";



    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();
    private final ApiUser endpoint = new ApiUser();
    private final CheckUser check = new CheckUser();

    EditUser editUser;
    ValidatableResponse response;

    String token;


    @Before
    public void createUser(){
        fullUser = userGenerator.generic();
        response = endpoint.createUser(fullUser);
        token = endpoint.getToken(response);
    }

    @Test
    public void realUserLogIn() {
        editUser = new EditUser(email, name);
        response = endpoint.changeUserUnAuthorization(editUser);
        check.changeUserUnAuthorization(response);
    }
    @After
    public void deleteUser(){
        endpoint.deleteUser(token);
    }
}
