package base;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.restassured.RestAssured;
import org.example.API.steps.ApiSteps;
import org.example.page.objects.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class BaseClass {

    protected WebDriver driver;

    public static String email() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
        return fakeValuesService.bothify("?#?#?#?#?#@yahoo.com");
    }

    public static String name() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.name().firstName();
    }

    public static String password() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
        return fakeValuesService.bothify("?#?#?#?#?##?#?#?##?");
    }

    protected String email = email();
    protected String password = password();
    protected String name = name();

    @Before
    public void setup() {
        RestAssured.baseURI = MainPage.baseUrl();
        ApiSteps.createUserInOneStep(email, password, name);

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
        ApiSteps.deleteUser(ApiSteps.loginUserInOneStep(email, password));
    }
}

