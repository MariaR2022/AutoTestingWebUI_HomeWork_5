import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenItemVoyagesTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(OpenItemVoyagesTest.class);

    @Test
    void OpenItemVoyagesTest() throws InterruptedException {
        logger.info("Тест на открытие категории/темы -Путешествия- начат");

        WebElement webElement1 = getDriver().findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/puteshestviya/')]"));
        webElement1.click();
        Thread.sleep(5000);

        logger.info("Тест на открытие категории/темы -Путешествия- завершен");
        Assertions.assertEquals("Блоги о путешествиях и самостоятельном туризме — Живой Журнал — ЖЖ",getDriver().getTitle(),"Данная категория отсутствует");
    }

}