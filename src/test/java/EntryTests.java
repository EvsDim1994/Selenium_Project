import Model.User;
import PageObject.EnvConfig;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotNull;

public class EntryTests extends BaseTest {
    @Rule
    public DriverRule factory = new DriverRule();

    private WebDriver driver;


    @Before
    public void setUp() {
        driver = factory.getDriver();
        driver.get(EnvConfig.BASE_URL);
    }

    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт")
    public void entryFromMainPageTest() {
        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalEntryButton();

        authorizationPage.checkAuthorizationWindow();

        authorizationPage.inputEmail(user.getEmail());

        authorizationPage.inputPassword(user.getPassword());

        authorizationPage.clickEntryButton();

        mainPage.checkMakeOrderButton();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void entryFromPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalAccountButton();

        authorizationPage.checkAuthorizationWindow();

        authorizationPage.inputEmail(user.getEmail());

        authorizationPage.inputPassword(user.getPassword());

        authorizationPage.clickEntryButton();

        mainPage.checkMakeOrderButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме Восстановления пароля")
    public void entryFromPasswordRecoveryTest(){
        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalAccountButton();

        authorizationPage.checkAuthorizationWindow();

        var recoveryForm = authorizationPage.clickRecoveryFormButton();

        recoveryForm.checkRecoveryWindow();

        recoveryForm.clickEntryButton();

        authorizationPage.checkAuthorizationWindow();

        authorizationPage.inputEmail(user.getEmail());

        authorizationPage.inputPassword(user.getPassword());

        authorizationPage.clickEntryButton();

        mainPage.checkMakeOrderButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме Регистрации")
    public void entryFromRegistrationTest() {
        MainPage mainPage = new MainPage(driver);

        var authorizationPage = mainPage.clickPersonalAccountButton();

        authorizationPage.checkAuthorizationWindow();

        var registration = authorizationPage.clickRegistrationFormButton();

        registration.checkRegistrationWindow();

        registration.clickEntryButton();

        authorizationPage.checkAuthorizationWindow();

        authorizationPage.inputEmail(user.getEmail());

        authorizationPage.inputPassword(user.getPassword());

        authorizationPage.clickEntryButton();

        mainPage.checkMakeOrderButton();
    }


}
