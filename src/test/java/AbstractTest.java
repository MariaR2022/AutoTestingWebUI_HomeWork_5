import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(AbstractTest.class);

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        logger.info("tests started");

    }

    @BeforeEach
    void goTo(){
        driver.get("https://livejournal.com");
        driver.manage().deleteCookieNamed("На сайте используются cookies");
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://livejournal.com"),
                "Страница не доступна");
    }

    @AfterAll
    static void afterAll() {
        logger.info("tests completed");
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}