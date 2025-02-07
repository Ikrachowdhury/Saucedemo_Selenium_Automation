package Test;

import Pages.*;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingProductsTest extends SetUp {
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
    public void SortByLowToHighTest(){
        products.SortByDropdownBox("Price (high to low)");
        String IsSorted=products.CheckSortingHighToLow();
        test.CheckResultString(IsSorted,"HighToLow");
//        System.out.println(products.CheckSortingLowToHigh());
    }
    @Test
    public void SortByAtoZTest(){
        products.SortByDropdownBox("Name (A to Z)");
        String IsSorted=products.CheckSortingAtoZ();
        test.CheckResultString(IsSorted,"AtoZ");
    }
    @Test
    public void SortByZtoATest(){
        products.SortByDropdownBox("Name (Z to A)");
        String IsSorted=products.CheckSortingZtoA();
        test.CheckResultString(IsSorted,"ZtoA");
    }
    @Test
    public void SortByHighToLowTest(){
        products.SortByDropdownBox("Price (low to high)");
        String IsSorted=products.CheckSortingLowToHigh();
        test.CheckResultString(IsSorted,"LowToHigh");
//        System.out.println(products.CheckSortingLowToHigh());
    }

}
