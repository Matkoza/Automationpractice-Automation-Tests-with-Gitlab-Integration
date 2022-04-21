
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest{
    private static WebDriver webDriver;

    private static Setup setup;

    @BeforeAll
    static void SetupBeforeExecution(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();

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
    void testHomePage() throws InterruptedException{
        String homeURL = webDriver.getCurrentUrl();
        assertEquals(homeURL, "http://automationpractice.com/index.php");
    }
}
