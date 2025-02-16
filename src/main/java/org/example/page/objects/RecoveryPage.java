package org.example.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoveryPage {

    public WebDriver driver;

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки "Войти"
    private By openAuthorizationPageButton = By.xpath(".//*[text()='Войти']");
    //Локатор для заголовка "Восстановление пароля"
    private By header = By.xpath(".//*[text()='Восстановление пароля']");

    @Step("Ожидание открытия страницы восстановления пароля")
    public void waitUntilRecoveryPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickOnAuthorizationPage() {
        driver.findElement(openAuthorizationPageButton).click();
    }

    @Step("Переход на страницу авторизации в 1 шаг")
    public void goToAuthorizationPage() {
        waitUntilRecoveryPageIsOpen();
        clickOnAuthorizationPage();
    }
}
