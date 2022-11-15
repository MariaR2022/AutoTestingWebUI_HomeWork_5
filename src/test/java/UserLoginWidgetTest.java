import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLoginWidgetTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginWidgetTest.class);

    @Test
    void userLoginWidgetTest() throws InterruptedException {
        logger.info("Тест на открытие виджета логина начат");

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        String itemName = getDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText();
        webElement1.click();
        Thread.sleep(5000);

        logger.info("Тест на открытие виджета логина завершен");
        Assertions.assertTrue(itemName.contains(getDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText()));
    }

}