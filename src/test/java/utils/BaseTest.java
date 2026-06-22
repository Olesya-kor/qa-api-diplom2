package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    protected User user;

    protected String accessToken;

    protected UserClient userClient;

    @Before
    public void setUp() {

        String browser =
                System.getProperty("browser", "chrome");

        System.setProperty("browser", browser);

        driver = DriverFactory.getDriver();

        driver.get(
                "https://stellarburgers.education-services.ru/"
        );

        userClient = new UserClient();
    }

    @After
    public void tearDown() {

        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }

        DriverFactory.quitDriver(driver);
    }
}