package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoveryForm {
    private final WebDriver driver;

    public RecoveryForm(WebDriver driver) {
        this.driver = driver;
    }

    private By recovery = By.xpath(".//h2[text()='Восстановление пароля']");
    private By buttonEntry = By.xpath(".//a[text()='Войти']");

    @Step("Ожидание появления окна восстановления пароля")
    public void checkRecoveryWindow(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(recovery));
    }

    @Step("Нажатие на кнопку Войти")
    public void clickEntryButton(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(buttonEntry));
        driver.findElement(buttonEntry).click();
    }
}
