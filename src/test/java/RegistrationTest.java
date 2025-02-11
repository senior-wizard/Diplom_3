import org.example.page.objects.AuthorizationPage;
import org.example.page.objects.MainPage;
import org.example.page.objects.RegistrationPage;
import org.junit.Test;

public class RegistrationTest extends BaseClass {

    private final String randomEmail = BaseClass.generateRandomEmail();
    private final String password = "12345677";
    private final String name = "jmyh";

    @Test
    public void testRegistration() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickOnAuthorizationButton();
        authorizationPage.goToRegistrationPage();
        registrationPage.registration(name, randomEmail, password);
        authorizationPage.waitUntilAuthorizationPageOpen();
    }

    @Test
    public void testRegistrationErrorWhenInPasswordLessSixSymbols() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.goToRegistrationPage();
        registrationPage.registration(name, randomEmail, "1234");
        registrationPage.waitUntilGetErrorPasswordMessage();
    }
}


