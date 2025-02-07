package Test;

import Pages.*;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartBadgeCountValidationTest extends SetUp {
    loginPage loginpage;
    TestAction test;
    Products products;
    YourCart yourCart;
    @BeforeTest
    public void PageObjects(){
        loginpage= new loginPage(driver);
        test=new TestAction();
        products =new Products(driver);
        yourCart = new YourCart(driver);
        loginpage.Login("standard_user", "secret_sauce");
    }

    @Test
    public void AddMultipleProductsCartBadgeTest(){
        String BadgeNumber="";
        products.ClickAddToCartButton(2);
        products.ClickAddToCartButton(1);
        products.ClickAddToCartButton(0);
        BadgeNumber= products.GetCartBadgeNumber();

        test.CheckResultString(BadgeNumber,"3");

    }
    @Test
    public void RemoveAProductCartBadgeTest(){
        products.ClickAddToCartButton(2);
        products.ClickAddToCartButton(1);
        products.ClickAddToCartButton(0);
        String PrevBadgeNumber= products.GetCartBadgeNumber();
        int PrevBadgeCount = Integer.parseInt(PrevBadgeNumber.trim());
        if(PrevBadgeCount!=0){
            products.ClickRemoveButton(0);
            String BadgeNumber= products.GetCartBadgeNumber();
            int BadgeCount = Integer.parseInt(BadgeNumber.trim());
            int ExpectedBadge= PrevBadgeCount-1;
            test.CheckResultInt(BadgeCount,ExpectedBadge);
        }

    }
}

