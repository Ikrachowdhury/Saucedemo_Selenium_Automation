package Pages;
import Util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage  {
    WebDriver driver;
    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "user-name")
    WebElement  EmailField;
    @FindBy(id = "password")
    WebElement PasswordField;
    @FindBy(id = "login-button")
    WebElement SubmitButton;

    @FindBy(className = "title")
    WebElement PageName;

    @FindBy(id = "react-burger-menu-btn")
    WebElement MenuButton;
    @FindBy(linkText = "Logout")
    WebElement LogoutBUtton;
    @FindBy(className = "error-message-container")
    WebElement ErorMsgContainer;




    public void GoToLoginPage(String link){
        driver.get(link);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void SetEmail(String email){
        EmailField.sendKeys(email);
  }
  public void SetPassWord(String password){
      PasswordField.sendKeys(password);
  }
  public  void ClickSubmitButton(){
      SubmitButton.click();}
    public String CheckLoginButton(){
        String value = SubmitButton.getAttribute("value");
        return value;

    }

   public String CheckErrorMsg(){
        String ErrorMsg = ErorMsgContainer.getText();
        return ErrorMsg;

   }

   public void ClickMenuButton(){
        MenuButton.click();

       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
   public String ClickLogout(){

       LogoutBUtton.click();
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       String LoginPage = CheckLoginButton();
       return LoginPage;


   }

    public void  Login(String email,String password){
        GoToLoginPage("https://www.saucedemo.com/");
        SetEmail(email);
        SetPassWord(password);
        ClickSubmitButton();

    }
}
