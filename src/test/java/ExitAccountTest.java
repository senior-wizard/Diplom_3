import org.example.page.objects.AuthorizationPage;
import org.example.page.objects.MainPage;
import org.example.page.objects.PersonalAccountPage;
import org.junit.Test;

public class ExitAccountTest extends BaseClass {

    private String email = "1234@4444.asddsa";
    private String password = "135797531";

    @Test
    public void exitFromAccountTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.exitAccount();
        authorizationPage.waitUntilAuthorizationPageOpen();
    }
}
