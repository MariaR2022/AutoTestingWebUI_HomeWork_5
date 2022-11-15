import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenItemWorkTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(OpenItemWorkTest.class);

    @Test
    void OpenItemWorkTest() throws InterruptedException {
        logger.info("Тест на открытие категории/темы -Работа- начат");

        WebElement webElement1 = getDriver().findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/rabota/')]"));
        webElement1.click();
        Thread.sleep(5000);

        logger.info("Тест на открытие категории/темы -Работа- завершен");
        Assertions.assertEquals("Статьи и блоги про работу — Живой Журнал — ЖЖ",getDriver().getTitle(),"Данная категория отсутствует");
    }

}