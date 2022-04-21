
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin {
    private static WebDriver webDriver;

    private static Setup setup;

    @BeforeAll
    static void SetupBeforeExecution(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        setup = new Setup(webDriver);
    }

    @BeforeEach
    void setUp() throws Exception{
        setup.startApplication();
    }
    @AfterAll
    static void tearDown(){
        setup.exitApplication();
    }

    @Test
    void testLogin(){
        WebElement SignInButton = webDriver.findElement(By.className("login"));
        SignInButton.click();

        WebElement email = webDriver.findElement(By.id("email"));
        WebElement password = webDriver.findElement(By.id("passwd"));
        WebElement signInButton = webDriver.findElement(By.id("SubmitLogin"));

        email.sendKeys("matej.mujezinovic@gmail.com");
        password.sendKeys("12345");
        signInButton.click();
        String accountUrl = "http://automationpractice.com/index.php?controller=my-account";
        assertEquals(webDriver.getCurrentUrl(), accountUrl);
    }

}
