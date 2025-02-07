package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutComplete {
    WebDriver driver;
    public CheckoutComplete (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @FindBy(className = "complete-header")
    WebElement CheckoutSucessMsg;

    public String GetCheckOutSuccessMsg() {
       String SucessMsg= CheckoutSucessMsg.getText();
       return SucessMsg;

    }



}
