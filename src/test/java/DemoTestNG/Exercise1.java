package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Exercise1 {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    @BeforeTest
    public void beforeExercise(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void exercise(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String successCheck = driver.findElement(By.id("txtAge")).getText();
        Assert.assertTrue(successCheck.contains("Success"), "It does not contain success");


    }

    @Test
    public void multipleBox()throws InterruptedException{
//        driver.findElement(By.id("ex1-check1")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("ex1-check2")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("ex1-check3")).click();
         driver.findElement(By.id("box")).click();
         //use this line to check the checkboxes are selected
         Assert.assertEquals(true,driver.findElement(By.id("ex1-check1")).isSelected());
        System.out.println("The First checkbox is selected");
        softAssert.assertEquals(true,driver.findElement(By.id("ex1-check2")).isSelected());
        System.out.println("The second checkbox is selected");
        Assert.assertEquals(true,driver.findElement(By.id("ex1-check3")).isSelected());
        System.out.println("The third checkbox is selected");
        softAssert.assertAll("E no enter o!");
    }


    @AfterTest
    public void afterExercise() throws InterruptedException{
        Thread.sleep(7000);
        driver.close();
    }


}
