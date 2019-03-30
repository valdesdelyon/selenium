import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class BingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://bing.com");
    }

    @Test
    public void testSearch() throws InterruptedException {

        // WebElement szukajka = driver.findElement(By.name("q"));
        WebElement szukajka = driver.findElement(By.id("sb_form_q"));
        szukajka.clear();
        szukajka.sendKeys("Mistrzostwa świata w piłce nożnej 2018");
        szukajka.submit();

        Thread.sleep(5000);

        WebElement link = driver.findElement(By.xpath("/html/body/div[2]/main/ol/li[2]/div[1]/h2/a"));

        String textLinku = link.getText();
        String oczekiwanyTekst = "Mistrzostwa Świata w Piłce Nożnej 2018 – Wikipedia, …";

        assertTrue(textLinku.equals(oczekiwanyTekst));

    }
        @After
       public void tearDown() throws InterruptedException {
     Thread.sleep(5000);

            driver.quit();
        }



    }