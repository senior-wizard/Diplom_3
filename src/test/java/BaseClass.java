import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class BaseClass {

    private static final String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
    private static final String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomEmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder();

        // Генерация случайной части перед @
        int length = random.nextInt(10) + 5; // Длина от 5 до 15 символов
        for (int i = 0; i < length; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Добавление случайного домена
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }

    WebDriver driver;

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

