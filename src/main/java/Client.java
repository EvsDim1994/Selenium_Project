import static io.restassured.RestAssured.given;

import PageObject.EnvConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Client {


    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(EnvConfig.BASE_URL)
                .basePath(EnvConfig.BASE_PATH);
    }
}
