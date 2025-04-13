package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registration = By.xpath(".//h2[text()='Регистрация']");
    private By buttonEntry = By.xpath(".//a[text()='Войти']");
    private By email = By.xpath("//label[text()='Email']/following-sibling::input[@name='name']");
    private By password = By.xpath(".//input[@name='Пароль']");
    private By name = By.xpath("//label[text()='Имя']/following-sibling::input[@name='name']");
    private By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private By errorText = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Ожидание появления окна регистрации")
    public void checkRegistrationWindow(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(registration));
    }

    @Step("Нажатие на кнопку Войти")
    public void clickEntryButton(){
        driver.findElement(buttonEntry).click();
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

    @Step("Заполнение name")
    public void inputName(String registrationName){
        driver.findElement(name).sendKeys(registrationName);
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Проверка ошибки при вводе некорректного пароля")
    public void checkRegistrationError(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(errorText));
        assertTrue(driver.findElement(errorText).isDisplayed());
    }
}
