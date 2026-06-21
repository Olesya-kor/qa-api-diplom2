package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.BaseTest;
import utils.TestData;

import static org.junit.Assert.assertTrue;



@Epic("Stellar Burgers")
@Feature("Авторизация")
public class LoginTest extends BaseTest {



    private void login() {


        LoginPage loginPage =
                new LoginPage(driver);


        loginPage.enterEmail(
                TestData.USER_EMAIL
        );


        loginPage.enterPassword(
                TestData.USER_PASSWORD
        );


        loginPage.clickLoginButton();

    }





    @Test
    @Story("Вход через кнопку «Войти в аккаунт»")
    @Description("Проверка авторизации пользователя через кнопку на главной странице")
    public void loginFromMainButtonTest() {


        MainPage mainPage =
                new MainPage(driver);


        mainPage.clickLoginButton();


        login();


        LoginPage loginPage =
                new LoginPage(driver);


        assertTrue(
                loginPage.isLoginSuccessful()
        );

    }





    @Test
    @Story("Вход через личный кабинет")
    @Description("Проверка авторизации пользователя через личный кабинет")
    public void loginFromPersonalAccountTest() {


        MainPage mainPage =
                new MainPage(driver);


        mainPage.clickPersonalAccountButton();


        login();


        LoginPage loginPage =
                new LoginPage(driver);


        assertTrue(
                loginPage.isLoginSuccessful()
        );

    }





    @Test
    @Story("Вход через форму регистрации")
    @Description("Проверка авторизации пользователя после перехода из формы регистрации")
    public void loginFromRegistrationFormTest() {


        MainPage mainPage =
                new MainPage(driver);


        mainPage.clickLoginButton();



        LoginPage loginPage =
                new LoginPage(driver);


        loginPage.clickRegisterLink();



        RegisterPage registerPage =
                new RegisterPage(driver);


        registerPage.clickLoginLink();



        login();



        LoginPage afterLogin =
                new LoginPage(driver);



        assertTrue(
                afterLogin.isLoginSuccessful()
        );

    }





    @Test
    @Story("Вход через восстановление пароля")
    @Description("Проверка авторизации пользователя после перехода из восстановления пароля")
    public void loginFromForgotPasswordTest() {


        MainPage mainPage =
                new MainPage(driver);


        mainPage.clickLoginButton();



        LoginPage loginPage =
                new LoginPage(driver);


        loginPage.clickForgotPasswordLink();



        ForgotPasswordPage forgotPasswordPage =
                new ForgotPasswordPage(driver);


        forgotPasswordPage.clickLoginLink();



        login();



        LoginPage afterLogin =
                new LoginPage(driver);



        assertTrue(
                afterLogin.isLoginSuccessful()
        );

    }


}