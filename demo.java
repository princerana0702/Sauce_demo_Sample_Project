package Sauce_demo;


    import java.time.Duration;
    import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class demo {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();
        private JavascriptExecutor js;

        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            baseUrl = "https://www.google.com/";
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            js = (JavascriptExecutor) driver;
        }

        @Test
        public void testUntitledTestCase() throws Exception {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).click();
            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.xpath("//div[@id='header_container']/div/div[2]/div")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.xpath("//a[@id='item_4_title_link']/div")).click();
            driver.findElement(By.linkText("1")).click();
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).click();
            driver.findElement(By.id("first-name")).clear();
            driver.findElement(By.id("first-name")).sendKeys("test");
            driver.findElement(By.id("last-name")).click();
            driver.findElement(By.id("last-name")).clear();
            driver.findElement(By.id("last-name")).sendKeys("abcs");
            driver.findElement(By.id("postal-code")).click();
            driver.findElement(By.id("postal-code")).clear();
            driver.findElement(By.id("postal-code")).sendKeys("1234");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            driver.findElement(By.id("back-to-products")).click();
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

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


