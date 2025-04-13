import Model.User;
import PageObject.EnvConfig;
import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class RegistrationTests {
    @Rule
    public DriverRule factory = new DriverRule();

    private WebDriver driver;

    private static User user;

    private static Requests requests = new Requests();

    private static String userToken;

    @Before
    public void setUp() {
        driver = factory.getDriver();
        driver.get(EnvConfig.BASE_URL);
        user = User.random();
    }

    @AfterClass
    public static void deleteUser() {
        var credentials = new User(user.getEmail(), user.getPassword());
        userToken = requests.loginUser(credentials)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
        if (userToken != null && !userToken.isEmpty()) {
            requests.deleteUser(userToken)
                    .then()
                    .assertThat()
                    .statusCode(202);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistrationTest(){

        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalEntryButton();

        var registration = authorizationPage.clickRegistrationFormButton();

        registration.inputEmail(user.getEmail());

        registration.inputPassword(user.getPassword());

        registration.inputName(user.getName());

        registration.clickRegistrationButton();

        authorizationPage.checkAuthorizationWindow();

        authorizationPage.inputEmail(user.getEmail());

        authorizationPage.inputPassword(user.getPassword());

        authorizationPage.clickEntryButton();

        mainPage.checkMakeOrderButton();
    }

    @Test
    @DisplayName("Ошибка ввода пароля при регистрация")
    public void unsuccessfulRegistrationTest(){

        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalEntryButton();

        var registration = authorizationPage.clickRegistrationFormButton();

        registration.inputEmail(user.getEmail());

        registration.inputPassword("11111");

        registration.inputName(user.getName());

        registration.clickRegistrationButton();

        registration.checkRegistrationError();
    }
}
