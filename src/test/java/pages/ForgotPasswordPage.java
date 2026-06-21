package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ForgotPasswordPage extends BasePage {



    private By loginLink =
            By.xpath("//a[contains(text(),'Войти')]");





    public ForgotPasswordPage(org.openqa.selenium.WebDriver driver) {

        super(driver);

    }





    @Step("Перейти на страницу авторизации из восстановления пароля")
    public LoginPage clickLoginLink() {


        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        );


        driver.findElement(loginLink)
                .click();



        return new LoginPage(driver);

    }


}