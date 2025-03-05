package org.example.page.objects;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Getter
public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String baseUrl() {
        return "https://stellarburgers.nomoreparties.site";
    }

    private String classNameOnBunOrSauceOrIngredientButtonIsSelected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

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
    private By bunButtonField = By.xpath(".//div[@style='display: flex;']/div[1]");
    //Локатор для поля кнопки "Соусы"
    private By sauceButtonField = By.xpath(".//div[@style='display: flex;']/div[2]");
    //Локатор для поля кнопки "Начинки"
    private By ingredientButtonField = By.xpath(".//div[@style='display: flex;']/div[3]");

    @Step("Ожидание открытия главной страницы")
    public void waitUntilMainPageOpen() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickOnAuthorizationButton() {
        driver.findElement(authorizationButton).click();
    }

    @Step("Нажать на кнопку 'Личный Кабинет'")
    public void clickOnPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать на кнопку 'Булки'")
    public void clickOnBunButton() {
        driver.findElement(bunButton).click();
    }

    @Step("Нажать на кнопку 'Соусы'")
    public void clickOnSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step("Нажать на кнопку 'Ингредиенты'")
    public void clickOnIngredientButton() {
        driver.findElement(ingredientButton).click();
    }

    @Step("Ожидание переключения на вкладку 'Булки' в конструкторе")
    public void waitUntilGoToBuns() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(bunButtonField, "class", classNameOnBunOrSauceOrIngredientButtonIsSelected));
    }

    @Step("Ожидание переключения на вкладку 'Соусы' в конструкторе")
    public void waitUntilGoToSauces() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(sauceButtonField, "class", classNameOnBunOrSauceOrIngredientButtonIsSelected));
    }

    @Step("Ожидание переключения на вкладку 'Ингредиенты' в конструкторе")
    public void waitUntilGoToIngredients() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(ingredientButtonField, "class", classNameOnBunOrSauceOrIngredientButtonIsSelected));
    }

    @Step("Явное ожидания")
    public void waitTwoSeconds() {
        try {
            Thread.sleep(2000); // 2000 миллисекунд = 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Переход на страницу через кнопку 'Войти в аккаунт' авторизации в 1 шаг")
    public void goToAuthorizationPageWithAuthorizationButton() {
        waitUntilMainPageOpen();
        clickOnAuthorizationButton();
    }

    @Step("Переход на страницу через кнопку 'Личный кабинет' авторизации в 1 шаг")
    public void goToAuthorizationPageWithPersonalAccountButton() {
        waitUntilMainPageOpen();
        clickOnPersonalAccountButton();
    }

    @Step("Получение атрибута 'class' у кнопки 'Булки'")
    public String getBunButtonAttribute() {
        return driver.findElement(bunButtonField).getAttribute("class");
    }

    @Step("Получение атрибута 'class' у кнопки 'Соусы'")
    public String getSauceButtonAttribute() {
        return driver.findElement(sauceButtonField).getAttribute("class");
    }

    @Step("Получение атрибута 'class' у кнопки 'Начинки'")
    public String  getIngredientButtonAttribute() {
        return driver.findElement(ingredientButtonField).getAttribute("class");
    }
}

