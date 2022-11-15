import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SetLanguage {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://livejournal.com");
        driver.manage().deleteCookieNamed("На сайте используются cookies");

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--lang"));
        WebElement webElement2 = driver.findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link"));

        webElement1.click();   //кликаем на выпадающее меню для выбора языков в верхнем правом углу главной страницы сайта.
        webElement2.click();   //кликаем на русский язык в выпадающем меню в верхнем правом углу главной страницы сайта.

        try {
            driver.findElement(By.cssSelector(".s-header-item__link--lang")).click(); //условие для вывода в консоль исключения для элемента - выпадающее меню для выбора языков
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }


        //Завершаем работу с ресурсом
        driver.quit();
    }
}

