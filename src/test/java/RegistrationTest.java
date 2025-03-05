import base.BaseClassForRegistrationTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.objects.AuthorizationPage;
import org.example.page.objects.MainPage;
import org.example.page.objects.RegistrationPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseClassForRegistrationTest {

    String expectedUrlRegistrationTest = "https://stellarburgers.nomoreparties.site/login";
    String expectedUrlRegistrationErrorWhenInPasswordLessSixSymbolsTest = "https://stellarburgers.nomoreparties.site/register";

    @DisplayName("Регистрация пользователя")
    @Description("Проверка успешной регистрации пользователя")
    @Test
    public void registrationTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickOnAuthorizationButton();
        authorizationPage.goToRegistrationPage();
        registrationPage.registration(name, email, password);
        authorizationPage.waitUntilAuthorizationPageOpen();
        assertEquals(expectedUrlRegistrationTest, driver.getCurrentUrl());
    }

    @DisplayName("Появление ошибки при регистрации")
    @Description("Проверка появления ошибки при попытке зарегистрировать пользователя с уже существующим email в базе данных")
    @Test
    public void registrationErrorWhenInPasswordLessSixSymbolsTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.goToRegistrationPage();
        registrationPage.registration(name, email, "1234");
        registrationPage.waitUntilGetErrorPasswordMessage();
        assertEquals(expectedUrlRegistrationErrorWhenInPasswordLessSixSymbolsTest, driver.getCurrentUrl());
    }
}


