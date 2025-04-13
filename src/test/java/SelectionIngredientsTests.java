import PageObject.EnvConfig;
import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SelectionIngredientsTests {
    @Rule
    public DriverRule factory = new DriverRule();

    private WebDriver driver;


    @Before
    public void setUp() {
        driver = factory.getDriver();
        driver.get(EnvConfig.BASE_URL);
    }


    @Test
    @DisplayName("Переход к разделу Булочки")
    public void selectBunsTest(){
        MainPage mainPage = new MainPage(driver);

        // Выбор к разделу начинок, так раздел булочки выбраны по умолчанию
        mainPage.chooseIngredient(3);

        mainPage.chooseIngredient(1);

        mainPage.checkIngredientChoose(1);
    }

    @Test
    @DisplayName("Переход к разделу Соусов")
    public void selectSouceTest(){
        MainPage mainPage = new MainPage(driver);

        mainPage.chooseIngredient(2);

        mainPage.checkIngredientChoose(2);
    }

    @Test
    @DisplayName("Переход к разделу Начинок")
    public void selectFillingsTest(){
        MainPage mainPage = new MainPage(driver);

        mainPage.chooseIngredient(3);

        mainPage.checkIngredientChoose(3);
    }

}
