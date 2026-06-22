package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;
import utils.BaseTest;
import utils.User;
import utils.UserGenerator;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка регистрации нового пользователя с корректными данными")
    public void successfulRegistrationTest() {

        user = UserGenerator.getRandomUser();

        driver.get(
                "https://stellarburgers.education-services.ru/register"
        );

        RegisterPage registerPage =
                new RegisterPage(driver);

        registerPage.enterName(
                user.getName()
        );

        registerPage.enterEmail(
                user.getEmail()
        );

        registerPage.enterPassword(
                user.getPassword()
        );

        registerPage.clickRegister();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(
                        ExpectedConditions.urlContains("login")
                );

        accessToken =
                userClient.login(user)
                        .jsonPath()
                        .getString("accessToken");

        assertTrue(
                driver.getCurrentUrl()
                        .contains("login")
        );
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    @Description("Проверка ошибки при пароле короче 6 символов")
    public void registrationWithShortPasswordTest() {

        driver.get(
                "https://stellarburgers.education-services.ru/register"
        );

        RegisterPage registerPage =
                new RegisterPage(driver);

        registerPage.enterName(
                "Lesya"
        );

        registerPage.enterEmail(
                "lesya" + System.currentTimeMillis() + "@mail.com"
        );

        registerPage.enterPassword(
                "123"
        );

        registerPage.clickRegister();

        assertTrue(
                registerPage.isPasswordErrorDisplayed()
        );
    }
}