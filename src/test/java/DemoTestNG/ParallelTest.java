package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ParallelTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("Simple Form Demo"));
        driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys("BumBum de different size");


        driver.findElement(By.id("showInput")).click();
        String getMessage = driver.findElement(By.id("message")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getMessage, "BumBum de different size","It is the same size");
    }
    @Test
    public void test2(){
        driver.findElement(By.linkText("Checkbox Demo"));
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));

        checkbox.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkbox.isSelected());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
