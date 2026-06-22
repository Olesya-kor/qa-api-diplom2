package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {


    private By nameField =
            By.xpath("//input[@type='text'][@name='name']");


    private By emailField =
            By.xpath("//label[text()='Email']/following::input[@type='text'][1]");


    private By passwordField =
            By.xpath("//input[@type='password']");


    private By registerButton =
            By.xpath("//button[contains(text(),'Зарегистрироваться')]");


    private By loginLink =
            By.xpath("//a[contains(text(),'Войти')]");


    private By passwordError =
            By.xpath("//*[contains(text(),'Некорректный пароль')]");



    public RegisterPage(WebDriver driver) {

        super(driver);

    }



    @Step("Ввести имя: {name}")
    public void enterName(String name) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        ).sendKeys(name);

    }



    @Step("Ввести email: {email}")
    public void enterEmail(String email) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        ).sendKeys(email);

    }



    @Step("Ввести пароль")
    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);

    }



    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegister() {

        wait.until(
                ExpectedConditions.elementToBeClickable(registerButton)
        ).click();

    }



    @Step("Перейти на страницу входа")
    public LoginPage clickLoginLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        ).click();

        return new LoginPage(driver);

    }



    @Step("Проверить отображение ошибки пароля")
    public boolean isPasswordErrorDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordError)
        ).isDisplayed();

    }

}