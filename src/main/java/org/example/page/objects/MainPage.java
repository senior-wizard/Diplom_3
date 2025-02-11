package org.example.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public WebDriver driver;

    //Локатор для заголовка "Соберите бургер"
    private By header = By.xpath(".//*[text()='Соберите бургер']");
    //Локатор для кнопки "Войти в аккаунт"
    private By authorizationButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    //Локатор для кнопки "Личный кабинет"
    private By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");
    //Локатор для кнопки "Булки"
    private By bunButton = By.xpath(".//span[text()='Булки']");
    //Локатор для кнопки "Соусы"
    private By sauceButton = By.xpath(".//span[text()='Соусы']");
    //Локатор для кнопки "Начинки"
    private By ingredientButton = By.xpath(".//span[text()='Начинки']");
    //Локатор для поля кнопки "Булки"
    private By bunButtonField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    //Локатор для поля кнопки "Соусы"
    private By sauceButtonField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    //Локатор для поля кнопки "Начинки"
    private By ingredientButtonField = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilMainPageOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    public void clickOnAuthorizationButton() {
        driver.findElement(authorizationButton).click();
    }

    public void clickOnPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickOnBunButton() {
        driver.findElement(bunButton).click();
    }

    public void clickOnSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickOnIngredientButton() {
        driver.findElement(ingredientButton).click();
    }

    public void waitUntilGoToBuns() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(bunButtonField, "class" , "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }

    public void waitUntilGoToSauces() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(sauceButtonField, "class" , "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }

    public void waitUntilGoToIngredients() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(ingredientButtonField, "class" , "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }


    public void goToAuthorizationPageWithAuthorizationButton() {
        waitUntilMainPageOpen();
        clickOnAuthorizationButton();
    }

    public void goToAuthorizationPageWithPersonalAccountButton() {
        waitUntilMainPageOpen();
        clickOnPersonalAccountButton();
    }




}

