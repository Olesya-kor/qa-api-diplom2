package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {


    private By emailField =
            By.xpath("//input[@type='text']");


    private By passwordField =
            By.xpath("//input[@type='password']");


    private By loginButton =
            By.xpath("//button[contains(text(),'Войти')]");


    private By registerLink =
            By.xpath("//a[contains(text(),'Зарегистрироваться')]");


    private By forgotPasswordLink =
            By.xpath("//a[contains(text(),'Восстановить пароль')]");



    public LoginPage(org.openqa.selenium.WebDriver driver) {

        super(driver);

    }



    @Step("Ввести email: {email}")
    public void enterEmail(String email) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        );

        driver.findElement(emailField)
                .sendKeys(email);

    }



    @Step("Ввести пароль")
    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        );

        driver.findElement(passwordField)
                .sendKeys(password);

    }



    @Step("Нажать кнопку Войти")
    public void clickLoginButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );

        driver.findElement(loginButton)
                .click();

    }



    @Step("Проверить успешную авторизацию")
    public boolean isLoginSuccessful() {

        wait.until(
                ExpectedConditions.urlContains("/")
        );

        return driver.getCurrentUrl()
                .contains("/");

    }



    @Step("Перейти на страницу регистрации")
    public RegisterPage clickRegisterLink() {


        wait.until(
                ExpectedConditions.elementToBeClickable(registerLink)
        );


        driver.findElement(registerLink)
                .click();


        return new RegisterPage(driver);

    }



    @Step("Перейти на страницу восстановления пароля")
    public ForgotPasswordPage clickForgotPasswordLink() {


        wait.until(
                ExpectedConditions.elementToBeClickable(forgotPasswordLink)
        );


        driver.findElement(forgotPasswordLink)
                .click();


        return new ForgotPasswordPage(driver);

    }

}