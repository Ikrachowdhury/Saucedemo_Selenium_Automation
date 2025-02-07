package Test;
import Pages.*;
import Pages.CheckoutInformation;
import Pages.Products;
import Pages.loginPage;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutProcessTest extends SetUp {
    loginPage loginpage;
    Products products;
    TestAction test;
    CheckoutInformation checkoutInformation;
    CheckoutOverview checkoutOverview;
    YourCart yourCart;
    CheckoutComplete checkoutComplete;

    @BeforeTest
    public void PageObjects(){
        loginpage= new loginPage(driver);
        test=new TestAction();
        products =new Products(driver);
        checkoutInformation=new CheckoutInformation(driver);
        checkoutOverview = new CheckoutOverview(driver);
        yourCart = new YourCart(driver);
        checkoutComplete =new CheckoutComplete(driver);
        loginpage.Login("standard_user", "secret_sauce");
    }

    @Test
    public void CheckoutProcessTest(){
        products.ClickAddToCartButton(0);
        products.ClickAddToCartButton(1);
        products.ClickCartIcon();

        List<String> CartItems = new ArrayList<>();
        CartItems = yourCart.GetCartItemNames();
            for (String item : CartItems) {
                System.out.println(item);}
        yourCart.ClickCheckoutButton();

        checkoutInformation.FillCheckoutInformation("John ","Doe ","12345 ");
        checkoutInformation.ClickContinueButton();

        List<String> SummaryItems = new ArrayList<>();
        SummaryItems = checkoutOverview.GetCartItemNames();
        for (String item : SummaryItems) {
            System.out.println(item);}
        test.CheckResultList(SummaryItems ,CartItems );
        checkoutOverview.ClickFinishButton();

        String SuccessMsg=checkoutComplete.GetCheckOutSuccessMsg();
        test.CheckResultString(SuccessMsg,"Thank you for your order!");

    }


}
