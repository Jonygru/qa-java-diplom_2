import io.restassured.response.ValidatableResponse;
import org.example.order.ApiOrder;
import org.example.order.CheckOrder;
import org.example.user.ApiUser;
import org.example.user.Creds;
import org.example.user.FullUser;
import org.example.user.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGetOrderWithAutorization {
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

        ValidatableResponse response = endpointOrder.getOrderUserWithAutorization(token);
        check.getOrderWithAutorization(response);
    }

    @After
    public void deleteUser(){
        endpointUser.logOutUser(refreshToken);
        endpointUser.deleteUser(token);
    }
}

