import Model.User;
import PageObject.EnvConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        if ("yandex".equalsIgnoreCase(System.getProperty("browser"))) {
            startUpYandex();
        } else if("chrome".equalsIgnoreCase(System.getProperty("browser"))) {
            startUpChrome();
        } else {
            startUpChrome();
        }
    }
    public WebDriver getDriver(){
        return driver;
    }

    public void startUpChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Запуск в headless режиме
        options.addArguments("--no-sandbox"); // Рекомендуется для Linux
        options.addArguments("--disable-dev-shm-usage"); // Рекомендуется для Linux
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    public void startUpYandex() {
        WebDriverManager.chromedriver().driverVersion(EnvConfig.DRIVER_VERSION).setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary(EnvConfig.PATH_YANDEX_DRIVER);
        driver = new ChromeDriver(options);
    }
}
