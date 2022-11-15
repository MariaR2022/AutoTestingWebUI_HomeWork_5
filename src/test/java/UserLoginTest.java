import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLoginTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(UserLoginTest.class);

    @Test
    void userLoginTest() throws InterruptedException {
        logger.info("Тест по авторизации начат");
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();
        Thread.sleep(5000);
        WebElement webElement2 = getDriver().findElement(By.xpath("//input[@id='user']"));
        webElement2.click();
        webElement2.sendKeys("MariyaMarusya");
        WebElement webElement3 = getDriver().findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("567Rjvgjn");
        WebElement webElement4 = getDriver().findElement(By.name("action:login"));

        webElement4.click();
        Thread.sleep(5000);
        String itemName = getDriver().findElement(By.xpath("//a[contains(@href, 'https://mariyamarusya.livejournal.com/')]")).getText();
        logger.info("Тест по авторизации завершен");

        Assertions.assertEquals(true, itemName.contains(getDriver().findElement(By.xpath("//a[contains(@href, 'https://mariyamarusya.livejournal.com/')]")).getText()));

    }

}