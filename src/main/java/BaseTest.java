import Model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
    protected static final Requests requests = new Requests();

    protected static String userToken;

    protected static User user;

    @BeforeClass
    public static void createUser() {
        user = User.random();
        requests.createUser(user)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }
    @AfterClass
    public static void deleteCourier() {
        if (userToken != null && !userToken.isEmpty()) {
            requests.deleteUser(userToken)
                    .then()
                    .assertThat()
                    .statusCode(202);
        }
    }
}

