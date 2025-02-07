package Test;

import Pages.*;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddToCartFunctionalitiesTest extends SetUp {
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
    public int OnClick(){
        String BadgeNumber= products.GetCartBadgeNumber();
        int BadgeCount = Integer.parseInt(BadgeNumber.trim());
        return BadgeCount;

    }
    @Test
    public void AddToCartTest() {
        String ItemName = "";
        List<String> ClickedItems = new ArrayList<>();
        ItemName = products.ClickAddToCartButton(3);
        ClickedItems.add(ItemName);
        ItemName = products.ClickAddToCartButton(1);
        ClickedItems.add(ItemName);



        products.ClickCartIcon();
        List<String> CartItems = new ArrayList<>();
        CartItems = yourCart.GetCartItemNames();
        yourCart.ClickContinueShoppingButton();
        test.CheckResultList(ClickedItems ,CartItems );


        }

    @Test
    public void EdgeCasesTest(){
        products.ClickAddToCartButton(2);
        String PrevBadgeNumber= products.GetCartBadgeNumber();
        int PrevBadgeCount = Integer.parseInt(PrevBadgeNumber.trim());


        products.ClickAddToCartButton(0);
        int BadgeCount = OnClick();
        int CurrentBadge= PrevBadgeCount+1;
        test.CheckResultInt(BadgeCount,CurrentBadge);

        PrevBadgeCount =CurrentBadge;
        products.ClickRemoveButton(0);
        BadgeCount = OnClick();
        CurrentBadge= PrevBadgeCount-1;
        test.CheckResultInt(BadgeCount,CurrentBadge);

        PrevBadgeCount =CurrentBadge;
        products.ClickAddToCartButton(0);
        BadgeCount = OnClick();
        CurrentBadge= PrevBadgeCount+1;
        test.CheckResultInt(BadgeCount,CurrentBadge);

        PrevBadgeCount =CurrentBadge;
        products.ClickRemoveButton(0);
        BadgeCount = OnClick();
        CurrentBadge= PrevBadgeCount-1;
        test.CheckResultInt(BadgeCount,CurrentBadge);


    }

    }
