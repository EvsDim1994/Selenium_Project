import PageObject.AccountPage;
import PageObject.EnvConfig;
import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTests extends BaseTest {
    @Rule
    public DriverRule factory = new DriverRule();

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = factory.getDriver();
        driver.get(EnvConfig.BASE_URL);
    }


    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void entryConstructorTest() {
        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalAccountButton();

        authorizationPage.checkAuthorizationWindow();

        authorizationPage.inputEmail(user.getEmail());

        authorizationPage.inputPassword(user.getPassword());

        authorizationPage.clickEntryButton();

        mainPage.checkMakeOrderButton();

        mainPage.clickPersonalAccountButton();

        AccountPage accountPage = new AccountPage(driver);

        accountPage.checkAccountWindow();

        accountPage.clickConstructorButton();

        mainPage.checkConstructorText();
    }

}
