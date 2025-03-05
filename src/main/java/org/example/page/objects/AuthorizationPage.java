package org.example.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {

    public WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для заголовка "Вход"
    private final By headerOnAuthorizationPage = By.xpath(".//*[text()='Вход']");
    //Локатор для поля "email"
    private final By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input");
    //Локатор для поля "пароль"
    private final By passwordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input");
    //Локатор для кнопки "войти"
    private final By goButton = By.xpath(".//*[text()='Войти']");
    //Локатор для кнопки "зарегистрироваться"
    private final By openRegistrationPageButton = By.xpath(".//*[text()='Зарегистрироваться']");
    //Локатор для кнопки "восстановить пароль"
    private final By openRecoveryPasswordPageButton = By.xpath(".//*[text()='Восстановить пароль']");

    @Step("Ожидание открытия страницы авторизации")
    public void waitUntilAuthorizationPageOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOnAuthorizationPage));
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void openRegistrationPage() {
        driver.findElement(openRegistrationPageButton).click();
    }

    @Step("Нажатие на кнопку Восстановить пароль")
    public void openRecoveryPasswordPage() {
        driver.findElement(openRecoveryPasswordPageButton).click();
    }

    @Step("Перевод на страницу регистрации 1 шагом")
    public void goToRegistrationPage() {
        waitUntilAuthorizationPageOpen();
        openRegistrationPage();
    }

    @Step("Переход на страницу восстановления пароля 1 шагом")
    public void goToRecoveryPasswordPage() {
        waitUntilAuthorizationPageOpen();
        openRecoveryPasswordPage();
    }

    @Step("Ввести логин")
    public void setLogin(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Войти")
    public void clickOnGoButton() {
        driver.findElement(goButton).click();
    }

    @Step("Авторизация пользователя 1 шагом")
    public void authorization(String email, String password) {
        waitUntilAuthorizationPageOpen();
        setLogin(email);
        setPassword(password);
        clickOnGoButton();
    }
}

