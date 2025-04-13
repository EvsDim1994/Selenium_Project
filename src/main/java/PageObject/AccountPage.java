package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By profileText = By.xpath(".//a[text()='Профиль']");
    private By buttonExit = By.xpath(".//button[text()='Выход']");
    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']");

    @Step("Ожидание появления окна личного кабинета")
    public void checkAccountWindow(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(profileText));
    }

    @Step("Нажатие на кнопку Выход")
    public void clickExitButton(){
        driver.findElement(buttonExit).click();
    }

    @Step("Нажатие на кнопку Конструктор")
    public void clickConstructorButton(){
        driver.findElement(buttonConstructor).click();
    }
}
