import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SearchInformationAboutFashion {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://livejournal.com");
        driver.manage().deleteCookieNamed("На сайте используются cookies");

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon"));
        WebElement webElement2 = driver.findElement(By.cssSelector(".s-header-search__input-wrapper > #SearchText"));

        webElement1.click();   //кликаем на лупу - значок для поиска в верхнем правом углу главной страницы сайта.
        webElement2.click();   //кликаем на открывшуюся строку "Поиск" - устанавливаем в ней курсор.
        webElement2.sendKeys("мода");   //вводим слово "мода" в строку "Поиск".

        try {
            driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon")).click(); //условие для вывода в консоль исключения для элемента - лупа - значок поиска в верхнем правом углу главной страницы сайта
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }

        try {
            webElement2.sendKeys("мода");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }

        //Завершаем работу с ресурсом
        driver.quit();
    }
}

