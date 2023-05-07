package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class ParameterizedTest {
    WebDriver driver;

    @Parameters({"URL"})
    @BeforeMethod
    public void setup(String url){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }


    @Test
    @Parameters({"Task", "TestResult"})
    public void testFileDownload(String task, String testResult){
//        driver.findElement(By.linkText("File Download")).click();
//        driver.findElement(By.id("textbox")).sendKeys(task + "Execution: " + testResult);
//        driver.findElement(By.id("create")).click();
//        driver.findElement(By.linkText("Download")).click();
        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.id("user-message")).sendKeys("Mafe jo pa mi nauuu");
        driver.findElement(By.id("showInput")).click();
        String actualMessage = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualMessage, "Mafe jo pa mi nau", "Message is not correct");

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        //to get the screenshot of failed test
        if(ITestResult.FAILURE==result.getStatus()){
            TakesScreenshot screenshot =  (TakesScreenshot) driver;
            //to save the screenshot as a file
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshot/testSimpleFormDemo_Pass.png");
            //import file from source to destination
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Thread.sleep(3000);
            driver.quit();
        }
    }


}
