package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.RegisterPage;
import utils.BaseTest;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка регистрации нового пользователя с корректными данными")
    public void successfulRegistrationTest() {

        driver.get("https://stellarburgers.education-services.ru/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterName("Lesya");
        registerPage.enterEmail("lesya" + System.currentTimeMillis() + "@mail.com");
        registerPage.enterPassword("123456");
        registerPage.clickRegister();

        assertTrue(
                driver.getCurrentUrl().contains("stellarburgers.education-services.ru")
        );
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    @Description("Проверка отображения ошибки при пароле короче 6 символов")
    public void registrationWithShortPasswordTest() {

        driver.get("https://stellarburgers.education-services.ru/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterName("Lesya");
        registerPage.enterEmail("lesya" + System.currentTimeMillis() + "@mail.com");
        registerPage.enterPassword("123");
        registerPage.clickRegister();

        assertTrue(registerPage.isPasswordErrorDisplayed());
    }
}