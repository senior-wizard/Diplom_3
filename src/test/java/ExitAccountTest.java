import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.objects.AuthorizationPage;
import org.example.page.objects.MainPage;
import org.example.page.objects.PersonalAccountPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExitAccountTest extends BaseClass {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/login";

    @DisplayName("Выход из аккаунта")
    @Description("Проверка успешного выхода из аккаунта после авторизации")
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
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
