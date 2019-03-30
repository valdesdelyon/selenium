
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 1");
        driver.findElement(By.id("first-name")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 2");
        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys("Wayne");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Female'])[1]/input[1]")).click();
        driver.findElement(By.id("dob")).click();
        driver.findElement(By.id("dob")).click();
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys("03/03/1886");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 3");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("Rose Street");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 1");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("jw@m.com");
        driver.findElement(By.id("password")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 1");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("Company US");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 1");
        driver.findElement(By.id("role")).click();
        new Select(driver.findElement(By.id("role"))).selectByVisibleText("QA");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Role'])[1]/following::option[2]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 1");
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=expectation | label=High salary]]
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Job expectation'])[1]/following::option[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Take online courses'])[1]/input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Join tech cons'])[1]/input[1]")).click();
        driver.findElement(By.id("comment")).click();
        driver.findElement(By.id("comment")).clear();
        driver.findElement(By.id("comment")).sendKeys("Hi, John");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Komentarz 1");
        driver.findElement(By.id("submit")).click();
        try {
            assertEquals("Successfully submitted!", driver.findElement(By.id("submit-msg")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
