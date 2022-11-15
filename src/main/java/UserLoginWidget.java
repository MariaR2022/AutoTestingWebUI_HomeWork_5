import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class UserLoginWidget {
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

        webElement1.click();   //кликаем кнопку "Войти" в верхнем правом углу главной страницы сайта - т.е. открываем виджет логина и пароля.

        try {
            driver.findElement(By.cssSelector(".s-header-item__link--login")).click(); //условие для вывода в консоль исключения для элемента - кнопка "Войти"
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }

        //Завершаем работу с ресурсом
        driver.quit();
    }
}

