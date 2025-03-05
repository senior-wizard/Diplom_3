package org.example.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;

    public  RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для заголовка "Регистрация"
    private By headerOnRegistrationPage = By.xpath(".//*[text()='Регистрация']");
    //Локатор для поля "Имя"
    private By nameField = By.xpath(".//fieldset[1]/div/div/input");
    //Локатор для поля "Email"
    private By emailField = By.xpath(".//fieldset[2]/div/div/input");
    //Локатор для поля "Пароль"
    private By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    //Локатор для кнопки "Зарегистрироваться"
    private By registrationButton = By.xpath(".//*[text() = 'Зарегистрироваться']");
    //Локатор сообщения об ошибке при вводе в поле пароль менее 6 символов
    private By errorMessageWhenInPasswordFieldLessSixSymbols = By.xpath(".//*[text()='Некорректный пароль']");
    //Локатор для кнопки "Войти"
    private By goInButton = By.xpath(".//*[text()='Войти']");

    @Step("Ожидание открытия страницы регистрации")
    public void waitUntilRegistrationPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOnRegistrationPage));
    }

    @Step("Ввод в поле 'Имя'")
    public void setName (String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввод в поле 'Email'")
    public void setEmailField (String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод в поле 'Пароль'")
    public void setPassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickOnRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Ожидание появления сообщения об ошибке")
    public void waitUntilGetErrorPasswordMessage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageWhenInPasswordFieldLessSixSymbols));
    }

    @Step("Регистрация в 1 шаг")
    public void registration(String name, String email, String password) {
        waitUntilRegistrationPageIsOpen();
        setName(name);
        setEmailField(email);
        setPassword(password);
        clickOnRegistrationButton();
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickOnGoInButton() {
        driver.findElement(goInButton).click();
    }
}


