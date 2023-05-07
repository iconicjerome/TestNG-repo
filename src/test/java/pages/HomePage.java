package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //initialize driver
    WebDriver driver;

    //initialize linktext
    By simpleFormDemo = By.linkText("Simple Form Demo");
    By fileDownload = By.linkText("File Download");
    By modalClass = By.linkText("Window Popup Modal");

    //initialize driver method
    //remember the method name should be the same as the class name
    public HomePage (WebDriver driver){

        this.driver = driver;
    }

    //setup click method
    public void clickDemoForm(){

        driver.findElement(simpleFormDemo).click();
    }
    public void clickDownloadButton(){
        driver.findElement(fileDownload).click();
    }
    public void clickModalButton(){
        driver.findElement(modalClass).click();
    }
}
