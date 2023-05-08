package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestPOM {
    WebDriver driver;
    //initialize the pages in the test class
    HomePage homePage;
    SimpleFormDemo simpleFormPage;
    DownloadFile downloadFile;
    ModalClass modalClass;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test(priority = 1)
    public void testPom(){
        //create instances of the pages in the test class
        homePage = new HomePage(driver);
        simpleFormPage = new SimpleFormDemo(driver);
        homePage.clickDemoForm();
        simpleFormPage.clickTextBox();
        simpleFormPage.textInTextBox("Bum Bum dey different size");
        Assert.assertEquals(simpleFormPage.displayMessage(),"Bum Bum dey different size", "E no correct o");
        simpleFormPage.backToHomePage();
    }
    @Test(priority =2)
    public void testDownload(){
        homePage = new HomePage(driver);
        downloadFile = new DownloadFile(driver);
        homePage.clickDownloadButton();
        downloadFile.sendText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadFile.downloadLink));
        downloadFile.clickDownloadLink();
    }
    @Test(priority =-1)
    public void testModals(){
        homePage = new HomePage(driver);
        modalClass = new ModalClass(driver);
        homePage.clickModalButton();
        modalClass.clickTwitterModal();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/resources/screenshot/testSimpleModalDemo_Pass.png");
             try {
            FileHandler.copy(sourceFile, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @AfterMethod
    public void tearDown(ITestResult result) {
//        if(ITestResult.SUCCESS == result.getStatus()){
//            try{
//                SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
//                String timestamp = formatter.format(new Date());
//                Path path = Paths.get("screenshots");
//                if(!Files.exists(path)){
//                    Files.createDirectory(path);
//                }
//                String testName = result.getMethod().getMethodName();
//                String fileName = String.format("screenshots/%s_%s.png", testName, timestamp);
//                TakesScreenshot screenshot = (TakesScreenshot) driver;
//                File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
//                Files.copy(screenshotFile.toPath(), Paths.get(fileName));
//            }catch (IOException e) {
//                e.printStackTrace();
//
//            }

        driver.quit();
    }
}
