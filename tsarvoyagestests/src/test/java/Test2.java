
/**
 * Created by katem on 5/1/2017.
 */

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class Test2 {
    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        //Install ChromeDrvierService with the path where we have chrome driver itself
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\katem\\IdeaProjects\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        //Step 1- Driver Instantiation: Instantiate driver object as ChromeDriver
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void firstPage_opens() {
        driver.get("https://tsarvoyages.com");
        By PriceSelector = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[1]/div[4]/div[3]/table/tbody/tr[1]/td[2]/div/span");
        driver.findElement(PriceSelector).click();
        String currency = driver.findElement(PriceSelector).getText();
        assertEquals("959€", currency);
    }

}

    @Test
    public void firsPage_opens() {

        driver.get("http://tsarvoyages.com");
        By tabVivreEnRussie;
        tabVivreEnRussie = By.xpath("//*[@id=\"header\"]/div[2]/div/div[3]/a");
        driver.findElement(tabVivreEnRussie).click();
        By SecondPriceSelector = By.xpath("//*[@id=\"page-page\"]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div/ul/li[1]/div/div/div[1]/div[2]/div/span[2]/span[2]");
        driver.findElement(SecondPriceSelector).click();
        String currency = driver.findElement(SecondPriceSelector).getText();
        assertEquals("RUB", currency);
    }

