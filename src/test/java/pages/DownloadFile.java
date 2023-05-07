package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadFile {

    WebDriver driver;
    By textBox = By.xpath("//textarea[@class='form-control' and @id='textbox']");
    By generateFile = By.xpath("//button[@id='create']");
    By downloadLink = By.xpath("//a[@id='link-to-download']");
    public DownloadFile(WebDriver driver){
        this.driver = driver;
    }

    public void sendText(){
//        driver.findElement(textBox).click();
        driver.findElement(textBox).sendKeys("We The Best");
        driver.findElement(generateFile).click();
    }

    public void clickDownloadLink(){

        driver.findElement(downloadLink).click();
    }
}
