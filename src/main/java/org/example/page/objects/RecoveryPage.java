package org.example.page.objects;

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

    public void waitUntilRecoveryPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    public void clickOnAuthorizationPage() {
        driver.findElement(openAuthorizationPageButton).click();
    }


    public void goToAuthorizationPage() {
        waitUntilRecoveryPageIsOpen();
        clickOnAuthorizationPage();
    }
}
