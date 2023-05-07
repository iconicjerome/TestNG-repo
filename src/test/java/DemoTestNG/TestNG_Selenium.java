package DemoTestNG;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Selenium {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        //use the two lines of code blow to clear the Java.io.IOException: Invalid Status code=403 text=Forbidden error
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        //pass option as an argument
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/en-uk");
    }
     @Test
    public void searchButton()throws InterruptedException{
        driver.findElement(By.name("domainToCheck")).sendKeys("goa.com");
        driver.findElement(By.xpath("//button[@type = 'Submit']")).click();
        Thread.sleep(10000);
     }

     @AfterClass
    public void endTest(){

        driver.close();
     }
}
