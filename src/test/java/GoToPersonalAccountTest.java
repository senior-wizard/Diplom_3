import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.objects.AuthorizationPage;
import org.example.page.objects.MainPage;
import org.example.page.objects.PersonalAccountPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoToPersonalAccountTest extends BaseClass {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    @DisplayName("Переход в личный кабинет")
    @Description("Проверка возможности перехода в личный кабинет после авторизации")
    @Test
    public void goToPersonalAccountPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
