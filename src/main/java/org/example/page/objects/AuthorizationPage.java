package org.example.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    public WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }
    //Локатор для заголовка "Вход"
    private By headerOnAuthorizationPage = By.xpath(".//*[text()='Вход']");
    //Локатор для поля "email"
    private By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //Локатор для поля "пароль"
    private By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //Локатор для кнопки "войти"
    private By goButton = By.xpath(".//*[text()='Войти']");
    //Локатор для кнопки "зарегистрироваться"
    private By openRegistrationPageButton = By.xpath(".//*[text()='Зарегистрироваться']");
    //Локатор для кнопки "восстановить пароль"
    private By openRecoveryPasswordPageButton = By.xpath(".//*[text()='Восстановить пароль']");

    public void waitUntilAuthorizationPageOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOnAuthorizationPage));
    }

    public void openRegistrationPage() {
        driver.findElement(openRegistrationPageButton).click();
    }

    public void openRecoveryPasswordPage() {
        driver.findElement(openRecoveryPasswordPageButton).click();
    }

    public void goToRegistrationPage() {
        waitUntilAuthorizationPageOpen();
        openRegistrationPage();
    }

    public void goToRecoveryPasswordPage() {
        waitUntilAuthorizationPageOpen();
        openRecoveryPasswordPage();
    }

    public void setLogin(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnGoButton() {
        driver.findElement(goButton).click();
    }

    public void authorization(String email, String password) {
        waitUntilAuthorizationPageOpen();
        setLogin(email);
        setPassword(password);
        clickOnGoButton();
    }


}

