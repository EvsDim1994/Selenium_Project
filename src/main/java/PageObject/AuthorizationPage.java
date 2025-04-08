package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {

    private final WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.xpath(".//input[@name='name']");
    private By password = By.xpath(".//input[@name='Пароль']");
    private By exit = By.xpath(".//button[text()='Войти']");
    private By entry = By.xpath(".//h2[text()='Вход']");
    private By registrationButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private By recoveryButton = By.xpath(".//a[text()='Восстановить пароль']");


    @Step("Ожидание появления окна авторизации")
    public void checkAuthorizationWindow(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(entry));
    }

    @Step("Заполнение email")
    public void inputEmail(String mail){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(email));
        driver.findElement(email).sendKeys(mail);
    }

    @Step("Заполнение пароля")
    public void inputPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    @Step("Заполнение пароля")
    public void clickEntryButton(){
        driver.findElement(exit).click();
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public RegistrationPage clickRegistrationFormButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    @Step("Нажатие на кнопку Восстановить пароль")
    public RecoveryForm clickRecoveryFormButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(recoveryButton));
        driver.findElement(recoveryButton).click();
        return new RecoveryForm(driver);
    }
}
