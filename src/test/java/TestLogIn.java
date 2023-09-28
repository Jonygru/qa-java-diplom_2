import io.restassured.response.ValidatableResponse;
import org.example.user.*;
import org.junit.Test;

public class TestLogIn {
    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();
    private final ApiUser endpoint = new ApiUser();
    private final CheckUser check = new CheckUser();

    Creds creds;
    String token;
    String refreshToken;


    @Test
    public void realUserLogIn() {
        fullUser = userGenerator.generic();
        endpoint.createUser(fullUser);
        creds = Creds.from(fullUser);
        ValidatableResponse userResponse = endpoint.logInUser(creds);
        refreshToken = endpoint.getRefreshToken(userResponse);
        check.logInUserSaccess(userResponse);
        endpoint.logOutUser(refreshToken);
        token = endpoint.getToken(userResponse);
        endpoint.deleteUser(token);

    }

    @Test
    public void notRealUserLogIn() {
        creds = new Creds("nmbvjh@yandex.ru","123456");
        ValidatableResponse userResponse = endpoint.logInUser(creds);
        check.ligInUserNotReal(userResponse);

    }



}
