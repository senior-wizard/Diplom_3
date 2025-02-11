import org.example.page.objects.MainPage;
import org.junit.Test;

public class ConstructorButtonsTest extends BaseClass {

    @Test
    public void bunTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        mainPage.waitUntilGoToSauces();
        mainPage.clickOnBunButton();
        mainPage.waitUntilGoToBuns();
    }

    @Test
    public void sauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        mainPage.waitUntilGoToSauces();
    }

    @Test
    public void ingredientTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnIngredientButton();
        mainPage.waitUntilGoToIngredients();
    }
}
