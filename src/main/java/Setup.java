import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    private static WebDriver webDriver;

    public Setup(WebDriver webDriver) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        Setup.webDriver = new ChromeDriver(options);
        Setup.webDriver.manage().window().maximize();
        Setup.webDriver = webDriver;

    }

    public void startApplication() {
        webDriver.get("http://automationpractice.com/index.php");
    }
    public void exitApplication(){ webDriver.quit(); }
}
