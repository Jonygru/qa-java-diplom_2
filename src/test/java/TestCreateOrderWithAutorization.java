import io.restassured.response.ValidatableResponse;
import org.example.order.ApiOrder;
import org.example.order.CheckOrder;
import org.example.order.Ingredients;
import org.example.user.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCreateOrderWithAutorization {
    Ingredients ingredients;
    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();

    private final ApiUser endpointUser = new ApiUser();
    private final ApiOrder endpointOrder = new ApiOrder();
    private  final CheckOrder check = new CheckOrder();
    Creds creds;
    String token;
    String refreshToken;
    @Before
    public void createAndLogInUser() {
        fullUser = userGenerator.generic();
        endpointUser.createUser(fullUser);
        creds = Creds.from(fullUser);
        ValidatableResponse userResponse = endpointUser.logInUser(creds);
        refreshToken = endpointUser.getRefreshToken(userResponse);
        token = endpointUser.getToken(userResponse);
    }

    @Test
    public void createOrderWithNotAutorization() {
        String[] ingr = {"61c0c5a71d1f82001bdaaa6d","61c0c5a71d1f82001bdaaa6f"};
        ingredients = new Ingredients(ingr);
        ValidatableResponse response = endpointOrder.createOrderWithAutorization(ingredients, token);
        Integer actual = check.createOrder(response);
        assert actual > 0;
    }

    @After
    public void deleteUser(){
        endpointUser.logOutUser(refreshToken);
        endpointUser.deleteUser(token);
    }
}
