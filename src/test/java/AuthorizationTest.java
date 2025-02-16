import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.objects.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorizationTest extends BaseClass {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    @DisplayName("Авторизация через кнопку 'Войти в аккаунт'")
    @Description("Переход на страницу авторизации через кнопку 'Войти в акканут' на главной странице")
    @Test
    public void authorizationWithAuthorizationButtonOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithAuthorizationButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @DisplayName("Авторизация через кнопку 'Личный кабинет'")
    @Description("Переход на страницу авторизации через кнопку 'Личный кабинет' на главной странице")
    @Test
    public void authorizationWithPersonalAccountButtonOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        authorizationPage.authorization(email, password);
        mainPage.goToAuthorizationPageWithPersonalAccountButton();
        personalAccountPage.waitUntilPersonalAccountPageIsOpen();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @DisplayName("Авторизация через кнопку 'Войти' на странице регистрации")
    @Description("Переход на страницу авторизации через кнопку 'Войти' на странице регистрации")
    @Test
    public void authorizationWithAuthorizationButtonOnRegistrationPageTest() {
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
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @DisplayName("Авторизация через кнопку 'Войти' на странице восстановления пароля")
    @Description("Переход на страницу авторизации через кнопку 'Войти' на странице восстановления пароля")
    @Test
    public void authorizationWithAuthorizationButtonOnRecoveryPasswordTest() {
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
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
