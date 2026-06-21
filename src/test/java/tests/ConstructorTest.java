package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ConstructorPage;
import utils.BaseTest;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход в раздел Булки")
    @Description("Проверка перехода в раздел Булки")
    public void bunsSectionTest() {

        ConstructorPage constructorPage =
                new ConstructorPage(driver);

        constructorPage.clickBuns();

        assertTrue(
                driver.getPageSource()
                        .contains("Булки")
        );
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    @Description("Проверка перехода в раздел Соусы")
    public void saucesSectionTest() {

        ConstructorPage constructorPage =
                new ConstructorPage(driver);

        constructorPage.clickSauces();

        assertTrue(
                driver.getPageSource()
                        .contains("Соусы")
        );
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    @Description("Проверка перехода в раздел Начинки")
    public void fillingsSectionTest() {

        ConstructorPage constructorPage =
                new ConstructorPage(driver);

        constructorPage.clickFillings();

        assertTrue(
                driver.getPageSource()
                        .contains("Начинки")
        );
    }
}