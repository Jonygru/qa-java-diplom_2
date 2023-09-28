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

public class TestGetOrderWithoutAutorization {

    private final ApiOrder endpointOrder = new ApiOrder();
    private  final CheckOrder check = new CheckOrder();

    @Test
    public void createOrderWithNotAutorization() {

        ValidatableResponse response = endpointOrder.getOrderUserWithoutAutorization();
        check.getOrderWithoutAutorization(response);
    }

}
