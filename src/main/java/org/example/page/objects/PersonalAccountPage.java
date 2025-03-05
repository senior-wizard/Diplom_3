package org.example.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //Локатор для текста
    private By messageUnderFields = By.xpath(".//*[text()='В этом разделе вы можете изменить свои персональные данные']");
    //Локатор для кнопки "Выйти"
    private By exitButton = By.xpath(".//*[text()='Выход']");
    //Локатор для кнопки "Конструктор"
    private By constructorButton = By.xpath(".//*[text()='Конструктор']");

    @Step("Ожидание открытия страницы 'Личный Кабинет'")
    public void waitUntilPersonalAccountPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(messageUnderFields));
    }

    @Step("Нажать на кнопку 'Выйти'")
    public void clickOnExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Выход из аккаунта 1 шагом")
    public void exitAccount() {
        waitUntilPersonalAccountPageIsOpen();
        clickOnExitButton();
    }

    @Step("Нажать на кнопку 'Конструктор")
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Переход к конструктору в 1 шаг")
    public void goToConstructor() {
        waitUntilPersonalAccountPageIsOpen();
        clickOnConstructorButton();
    }
}
