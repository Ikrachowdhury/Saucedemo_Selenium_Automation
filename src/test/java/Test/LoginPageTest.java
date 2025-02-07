package Test;
import Pages.Products;
import Pages.loginPage;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends SetUp {
    loginPage loginpage;
    Products products;
    TestAction test;
    @BeforeTest
    public void PageObjects(){
         loginpage= new loginPage(driver);
         test=new TestAction();
        products =new Products(driver);
    }

    @Test
    public void LoginTest(){
        loginpage.Login("standard_user","secret_sauce");
        String tittle= products.CheckPageTittle();
        test.CheckResultString(tittle,"Products");

    }
    @Test
    public void LockedOutUserValidationTest(){
        loginpage.GoToLoginPage("https://www.saucedemo.com/");
        loginpage.SetEmail("locked_out_user");
        loginpage.SetPassWord("secret_sauce");
        loginpage.ClickSubmitButton();
        String ErrorMsg=loginpage.CheckErrorMsg();
        System.out.println(ErrorMsg);
        test.CheckResultString(ErrorMsg,"Epic sadface: Sorry, this user has been locked out.");

    }
    @Test
    public void LogoutTest(){
        loginpage.Login("standard_user","secret_sauce");
        loginpage.ClickMenuButton();
        String PageTittle=loginpage.ClickLogout();
        System.out.println(PageTittle);
        test.CheckResultString(PageTittle,"Login");


    }
    @Test
    public void NegativeCasesTest(){
        loginpage.GoToLoginPage("https://www.saucedemo.com/");
        loginpage.SetEmail("wrong_user");
        loginpage.SetPassWord("secret_sauce");
        loginpage.ClickSubmitButton();
        String ErrorMsg=loginpage.CheckErrorMsg();
        System.out.println(ErrorMsg);
        test.CheckResultString(ErrorMsg,"Epic sadface: Username and password do not match any user in this service");


    }
}
