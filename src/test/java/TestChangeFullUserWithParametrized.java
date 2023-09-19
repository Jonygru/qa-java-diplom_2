import io.restassured.response.ValidatableResponse;
import org.example.user.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestChangeFullUserWithParametrized {
    private final String email;
    private final String name;

    public TestChangeFullUserWithParametrized(String email, String name) {
        this.email = email;
        this.name = name;
    }

    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();
    private final ApiUser endpoint = new ApiUser();
    private final CheckUser check = new CheckUser();

    EditUser editUser;
    ValidatableResponse responseCreateUser;
    String token;
    String refreshToken;


    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"zxcvbn@yandex.ru", null},
                {null, "dmitriy"},
                {"zxcvbn@yandex.ru", "dmitriy"},
        };
    }
    @Before
    public void createUser(){
        fullUser = userGenerator.generic();
        responseCreateUser = endpoint.createUser(fullUser);
        token = endpoint.getToken(responseCreateUser);
    }

    @Test
    public void realUserLogIn() {
        editUser = new EditUser(email, name);
        UserChangeRespons userChangeRespons = endpoint.changeUser(token,editUser);
        check.changeUser(userChangeRespons.getUserFieldResponse(),
                userChangeRespons.getUserFieldResponse().getEmail(),userChangeRespons.getUserFieldResponse().getName());
    }
    @After
    public void deleteUser(){
        endpoint.deleteUser(token);
    }

}
