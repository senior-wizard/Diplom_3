import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.objects.AuthorizationPage;
import org.example.page.objects.MainPage;
import org.example.page.objects.PersonalAccountPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoToConstructorFromPersonalAccountTest extends BaseClass {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/";

    @DisplayName("Переход в конструктор")
    @Description("Проверка возможности перехода в конструктор из личного кабинета после авторизации")
    @Test
    public void goToPersonalAccountPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.goToConstructor();
        mainPage.waitUntilMainPageOpen();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
