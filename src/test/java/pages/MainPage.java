package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private By loginButton =
            By.xpath("//button[contains(text(),'Войти')]");

    private By personalAccountButton =
            By.xpath("//a[contains(@href,'account')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public LoginPage clickLoginButton() {

        wait.until(
                        ExpectedConditions.elementToBeClickable(loginButton)
                )
                .click();

        return new LoginPage(driver);
    }

    @Step("Нажать кнопку 'Личный кабинет'")
    public LoginPage clickPersonalAccountButton() {

        wait.until(
                        ExpectedConditions.elementToBeClickable(personalAccountButton)
                )
                .click();

        return new LoginPage(driver);
    }
}