package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormDemo {
    WebDriver driver;

    By textBox = By.xpath("//input[@id='user-message']");
    By showMessage = By.xpath("//div[@id='user-message']/p[@id='message']");
    By checkButton = By.xpath("//button[@id='showInput']");

    By backToHomePage = By.linkText("Selenium Playground");
    public SimpleFormDemo (WebDriver driver){
        this.driver = driver;

    }

    public void clickTextBox(){

        driver.findElement(textBox).click();
    }

    public void textInTextBox(String writeText){
        driver.findElement(textBox).sendKeys(writeText);
        driver.findElement(checkButton).click();
    }

    public String displayMessage(){
        return driver.findElement(showMessage).getText();
    }

    public void backToHomePage(){
        driver.findElement(backToHomePage).click();
    }

}
