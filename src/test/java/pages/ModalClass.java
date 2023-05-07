package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalClass {
    WebDriver driver;
    By singleTwitterModal = By.xpath("//a[@href='https://twitter.com/Lambdatesting']");
    By singleFacebookModal = By.xpath("//a[@href='https://www.facebook.com/lambdatest/']");

    public ModalClass(WebDriver driver){
        this.driver = driver;
    }

    public void clickTwitterModal(){
        driver.findElement(singleTwitterModal).click();
    }
    public void clickFacebookModal(){
        driver.findElement(singleFacebookModal).click();
    }
}
