import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OpenItemWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://livejournal.com");
        driver.manage().deleteCookieNamed("На сайте используются cookies");

        WebElement webElement1 = driver.findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/rabota/')]"));

        webElement1.click();   //кликаем категорию "Работа" в верхнем горизонтальном меню, чтобы открыть категорию "Работа".


        try {
            driver.findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/rabota/')]")).click(); //условие для вывода в консоль исключения для элемента - катогория "Работа"
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }

        //Завершаем работу с ресурсом
        driver.quit();
    }
}
