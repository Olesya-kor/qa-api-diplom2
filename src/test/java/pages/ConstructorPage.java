package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ConstructorPage extends BasePage {



    private By bunsTab =
            By.xpath("//div[contains(@class,'tab')][.//span[text()='Булки']]");


    private By saucesTab =
            By.xpath("//div[contains(@class,'tab')][.//span[text()='Соусы']]");


    private By fillingsTab =
            By.xpath("//div[contains(@class,'tab')][.//span[text()='Начинки']]");




    public ConstructorPage(WebDriver driver) {

        super(driver);

    }




    @Step("Открыть раздел Булки")
    public void clickBuns() {


        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(bunsTab)
                );


        clickWithJS(element);

    }





    @Step("Открыть раздел Соусы")
    public void clickSauces() {


        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(saucesTab)
                );


        clickWithJS(element);

    }





    @Step("Открыть раздел Начинки")
    public void clickFillings() {


        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(fillingsTab)
                );


        clickWithJS(element);

    }





    @Step("Проверить что открыт раздел Булки")
    public boolean isBunsSelected() {


        return driver.findElement(bunsTab)
                .getAttribute("class")
                .contains("tab_type_current");

    }





    @Step("Проверить что открыт раздел Соусы")
    public boolean isSaucesSelected() {


        return driver.findElement(saucesTab)
                .getAttribute("class")
                .contains("tab_type_current");

    }





    @Step("Проверить что открыт раздел Начинки")
    public boolean isFillingsSelected() {


        return driver.findElement(fillingsTab)
                .getAttribute("class")
                .contains("tab_type_current");

    }





    private void clickWithJS(WebElement element) {


        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element
                );


        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element
                );

    }

}