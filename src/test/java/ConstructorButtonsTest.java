import base.BaseClassForConstructorButtonsTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.objects.MainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ConstructorButtonsTest extends BaseClassForConstructorButtonsTest {

    private String classNameOnBunOrSauceOrIngredientButtonIsSelected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @DisplayName("Переход во вкладку 'Булки'")
    @Description("Проверка успешного перехода во вкладку 'Булки'")
    @Test
    public void bunTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        mainPage.waitUntilGoToSauces();
        mainPage.clickOnBunButton();
        mainPage.waitUntilGoToBuns();
        assertEquals(classNameOnBunOrSauceOrIngredientButtonIsSelected, mainPage.getBunButtonAttribute());
    }

    @DisplayName("Переход во вкладку 'Соусы'")
    @Description("Проверка успешного перехода во вкладку 'Соусы'")
    @Test
    public void sauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        mainPage.waitUntilGoToSauces();
        mainPage.waitTwoSeconds();
        assertEquals(classNameOnBunOrSauceOrIngredientButtonIsSelected, mainPage.getSauceButtonAttribute());
    }

    @DisplayName("Переход во вкладку 'Начинки'")
    @Description("Проверка успешного перехода во вкладку 'Начинки'")
    @Test
    public void ingredientTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnIngredientButton();
        mainPage.waitUntilGoToIngredients();
        assertEquals(classNameOnBunOrSauceOrIngredientButtonIsSelected, mainPage.getIngredientButtonAttribute());
    }
}
