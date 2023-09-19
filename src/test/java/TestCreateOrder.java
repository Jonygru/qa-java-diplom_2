import io.restassured.response.ValidatableResponse;
import org.example.order.ApiOrder;
import org.example.order.CheckOrder;
import org.example.order.Ingredients;
import org.example.user.Creds;
import org.junit.Test;

public class TestCreateOrder {
    Ingredients ingredients;
    private final ApiOrder endpoint = new ApiOrder();
    private  final CheckOrder check = new CheckOrder();

    @Test
    public void createOrderWithNotAutorization() {
        String[] ingr = {"61c0c5a71d1f82001bdaaa6d","61c0c5a71d1f82001bdaaa6f"};
        ingredients = new Ingredients(ingr);
        ValidatableResponse response = endpoint.createOrderWithoutAutorization(ingredients);
        Integer actual = check.createOrder(response);
        assert actual > 0;
    }
    @Test
    public void createOrderWithoutIbgredients() {
        String[] ingr = new String[0];
        ingredients = new Ingredients(ingr);
        ValidatableResponse response = endpoint.createOrderWithoutAutorization(ingredients);
        check.createOrderWithoutIbgredients(response);
    }

    @Test
    public void createOrderNotRealIbgredients() {
        String[] ingr = {"Test"};
        ingredients = new Ingredients(ingr);
        ValidatableResponse response = endpoint.createOrderWithoutAutorization(ingredients);
        check.createOrderNotRealIbgredients(response);
    }
}
