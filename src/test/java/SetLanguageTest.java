import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetLanguageTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(SetLanguageTest.class);

    @Test
    void SetLanguageTest() throws InterruptedException {
        logger.info("Тест на установку языка -Русский- начат");

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--lang"));
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link"));
        String itemName = getDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")).getText();
        webElement1.click();
        webElement2.click();
        Thread.sleep(5000);

        logger.info("Тест на установку языка -Русский- завершен");
        Assertions.assertTrue(itemName.contains(getDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")).getText()));
    }

}