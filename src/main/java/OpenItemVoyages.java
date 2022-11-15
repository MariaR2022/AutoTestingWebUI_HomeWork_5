import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OpenItemVoyages {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://livejournal.com");
        driver.manage().deleteCookieNamed("На сайте используются cookies");

        WebElement webElement1 = driver.findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/puteshestviya/')]"));

        webElement1.click();   //кликаем категорию "Путешествия" в верхнем горизонтальном меню, чтобы открыть категорию "Путешествия".

        try {
            driver.findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/puteshestviya/')]")).click(); //условие для вывода в консоль исключения для элемента - катогория "Путешествия"
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }

        //Завершаем работу с ресурсом
        driver.quit();
    }
}
