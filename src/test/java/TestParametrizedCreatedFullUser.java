import io.restassured.response.ValidatableResponse;
import org.example.user.ApiUser;
import org.example.user.CheckUser;
import org.example.user.FullUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestParametrizedCreatedFullUser {
    private final String email;
    private final String password;
    private final String name;

    public TestParametrizedCreatedFullUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    private final ApiUser endpoint = new ApiUser();
    private final CheckUser check = new CheckUser();

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"qwer@yandex.ru", null, "Oleg"},
                {"qwer@yandex.ru", "12345", null},
                {null, "12345", "Oleg"},
                {null, null, "Oleg"},
                {null, "12345", null},
                {"qwer@yandex.ru", null, null},
                {null, null, null},
                {"qwer@yandex.ru", "", "Oleg"},
                {"qwer@yandex.ru", "12345", ""},
                {"", "12345", "Oleg"},
                {"", "", "Oleg"},
                {"", "12345", ""},
                {"zekich", "", ""},
                {"", "", ""},
        };
    }

    @Test
    public void createUserNotHaveAnyFields() {
        FullUser fullUser = new FullUser(email, password, name);
        ValidatableResponse userResponse = endpoint.createUser(fullUser);
        check.createUserNotHaveAnyField(userResponse);
    }
}
