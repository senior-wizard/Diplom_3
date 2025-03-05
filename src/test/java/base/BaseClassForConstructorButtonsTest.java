package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassForConstructorButtonsTest {

    protected WebDriver driver;

    @Before
    public void setup() {
        boolean chrome = true; //если chrome равен true - то тестирование будет проходить в chrome. Если false - то в яндексе
        if (chrome == true) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/yandexdriver.exe");
        }
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
