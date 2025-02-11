package org.example.page.objects;

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

    public void waitUntilPersonalAccountPageIsOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(messageUnderFields));
    }

    public void clickOnExitButton() {
        driver.findElement(exitButton).click();
    }

    public void exitAccount() {
        waitUntilPersonalAccountPageIsOpen();
        clickOnExitButton();
    }
}
