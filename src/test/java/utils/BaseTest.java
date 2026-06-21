package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        System.setProperty("browser", browser);
        driver = DriverFactory.getDriver();
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(driver);
    }
}