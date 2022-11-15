import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class UserLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://livejournal.com");
        driver.manage().deleteCookieNamed("На сайте используются cookies");

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        WebElement webElement2 = driver.findElement(By.xpath("//input[@id='user']"));
        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        WebElement webElement4 = driver.findElement(By.name("action:login"));

        webElement1.click();   //кликаем кнопку "Войти" в верхнем правом углу главной страницы сайта - т.е. открываем виджет логина и пароля.
        webElement2.click();   //кликаем курсором на поле "Имя пользователя" в виджете логина и пароля.
        webElement2.sendKeys("MariyaMarusya");   //вводим логин в поле "Имя пользователя" в виджете логина и пароля.
        webElement3.click();   //кликаем курсором на поле "Пароль" в виджете логина и пароля.
        webElement3.sendKeys("567Rjvgjn");   //вводим пароль в поле "Пароль" в виджете логина и пароля.
        webElement4.click();   //кликаем кнопку "Войти" на виджете логина и пароля, чтобы зайти на сайт после авторизации.

        try {
            webElement3.sendKeys("MariyaMarusya");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }

        try {
            webElement4.sendKeys("567Rjvgjn");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }

        //Завершаем работу с ресурсом
        driver.quit();
    }
}

