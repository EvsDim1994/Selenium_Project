package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By account = By.xpath(".//p[text()='Личный Кабинет']");
    private By buttonMakeOrder = By.xpath(".//button[text()='Оформить заказ']");
    private By buttonEntry = By.xpath(".//button[text()='Войти в аккаунт']");
    private By constructor = By.xpath(".//h1[text()='Соберите бургер']");
    private String ingredient = ".tab_tab__1SPyG:nth-child(%s)";


    @Step("Нажатие на кнопку Личный кабинет")
    public AuthorizationPage clickPersonalAccountButton() {
        driver.findElement(account).click();
        return new AuthorizationPage(driver);
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public AuthorizationPage clickPersonalEntryButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(buttonEntry));
        driver.findElement(buttonEntry).click();
        return new AuthorizationPage(driver);
    }

    @Step("Ожидание появления кнопки оформить заказ")
    public void checkMakeOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(buttonMakeOrder));
    }

    @Step("Ожидание появления надписи Соберите бургер")
    public void checkConstructorText() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(constructor));
    }

    @Step("Выбор ингредиента")
    public void chooseIngredient(int id) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format(ingredient, id))));
        driver.findElement(By.cssSelector(String.format(ingredient, id))).click();
    }

    @Step("Ожидание появления раздела в конструторе")
    public void checkIngredientChoose(int id) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(By.cssSelector(String.format(ingredient, id)), "class", "current"));
    }

}