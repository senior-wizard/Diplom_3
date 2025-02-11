import org.example.page.objects.*;
import org.junit.Test;

public class AuthorizationTest extends BaseClass {

    private String email = "1234@4444.asddsa";
    private String password = "135797531";

    @Test
    public void authorizationWithAuthorizationButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
    }

    @Test
    public void authorizationWithPersonalAccountButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
    }

    @Test
    public void authorizationWithAuthorizationButtonOnRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.goToRegistrationPage();
        registrationPage.clickOnGoInButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
    }

    @Test
    public void authorizationWithAuthorizationButtonOnRecoveryPassword() {
        MainPage mainPage = new MainPage(driver);
        RecoveryPage recoveryPage = new RecoveryPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.goToRecoveryPasswordPage();
        recoveryPage.goToAuthorizationPage();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
    }
}
