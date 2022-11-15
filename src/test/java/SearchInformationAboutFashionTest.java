import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class SearchInformationAboutFashionTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(SearchInformationAboutFashionTest.class);

    @Test
    void SearchInformationAboutFashionTest() throws InterruptedException {
        logger.info("Тест на поиск информации о моде начат");

        String itemForSearch = "мода";
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-do-item-search-btn .svgicon"));
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".s-header-search__input-wrapper > #SearchText"));

        webElement1.click();
        webElement2.click();
        webElement2.sendKeys(itemForSearch);
        Thread.sleep(5000);

        List<WebElement> items = new ArrayList<>(getDriver().findElements(By.xpath("//a[contains(@href, 'https://www.livejournal.com/rsearch?q=%D0%BC%D0%BE%D0%B4%D0%B0&sort=_score&searchArea=post')]")));

        logger.info("Тест на поиск информации о моде завершен");
        assertTrue(items.stream().allMatch(s -> s.getText().contains(itemForSearch)));;
    }

}