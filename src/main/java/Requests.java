import Model.User;
import PageObject.EnvConfig;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class Requests extends Client {
    @Step("Send POST request to /auth/register")
    public Response createUser(User user){
        return spec()
                .body(user)
                .when()
                .post(EnvConfig.CREATE_USER);
    }

    @Step("Send DELETE request to /api/auth/user")
    public Response deleteUser(String token){
        return spec()
                .header("Authorization", token)
                .when()
                .delete(EnvConfig.UPDATE_USER);
    }

    @Step("Send POST request to /api/auth/login")
    public Response loginUser(User user){
        return spec()
                .body(user)
                .when()
                .post(EnvConfig.LOGIN_USER);
    }
}
