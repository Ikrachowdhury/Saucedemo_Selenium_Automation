package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Products {
    WebDriver driver;
    public Products(WebDriver driver){
    PageFactory.initElements(driver, this);
    this.driver = driver;

}
    @FindBy(className = "title")
    WebElement PageName;
    @FindAll({
            @FindBy(className ="btn_inventory")
    })
    List<WebElement> AddToCartButtons;
    @FindAll({
            @FindBy(className ="inventory_item_name")
    })
    List<WebElement> InventoryItemNames;
    @FindAll({
            @FindBy(className ="inventory_item_price")
    })
    List<WebElement> InventoryItemPrice;

    @FindBy(className = "shopping_cart_link")
    WebElement CartIcon;
    @FindBy(className = "shopping_cart_badge")
    WebElement CartBadge;
    @FindBy(className = "product_sort_container")
    WebElement SortByDropDownBOx;
    public String CheckPageTittle(){
        String tittle = PageName.getText();
        return tittle;

    }

    public WebElement[] ArrayOfElement(List<WebElement> ElementArray){
        List<WebElement> elements = ElementArray;
        WebElement[] elementArray = new WebElement[elements.size()];
        elements.toArray(elementArray);

        return elementArray;

    }
    public String ClickAddToCartButton(int number){
        String ItemName ="no click";
        try{
            WebElement ButtonArray[]= ArrayOfElement(AddToCartButtons);
            WebElement ItemNamesArray[]= ArrayOfElement(InventoryItemNames);

            for (int i = 0; i <ButtonArray.length; i++) {
                if (i == number) {
                    String ButtonType=ButtonArray[i].getText();
                    if (!ButtonType.equals("Remove")) {
                        ButtonArray[i].click();
                        ItemName = ItemNamesArray[i].getText();
                    }
                    break;
                }
            }

            Thread.sleep(1000);

        }catch (Exception ex){
            System.out.println(ex);
        }
        return ItemName;
    }

    public String ClickRemoveButton(int number){
        String BadgeNumber ="0";
        try{
            WebElement ButtonArray[]= ArrayOfElement(AddToCartButtons);

            for (int i = 0; i <ButtonArray.length; i++) {
                if (i == number) {
                    String ButtonType=ButtonArray[i].getText();
                    if (ButtonType.equals("Remove")) {
                        ButtonArray[i].click();
                        BadgeNumber=CartBadge.getText();
                        return BadgeNumber;
                    }
                    break;
                }

            }

            Thread.sleep(1000);

        }catch (Exception ex){
            System.out.println(ex);
        }
        return BadgeNumber;
    }
    public Double[] ArrayOfSortingPrice(){
        WebElement ItemPrizeArray[]= ArrayOfElement(InventoryItemPrice);

        Double[] Prices = new Double[ItemPrizeArray.length];

        for (int i = 0; i < ItemPrizeArray.length; i++) {
            String PriceText = ItemPrizeArray[i].getText().replace("$", "");
            double PriceValue = Double.parseDouble(PriceText);
            Prices[i]=PriceValue;
        }
        return Prices;

    }

    public String CheckSortingLowToHigh(){
        String IsSort ="LowToHigh";
        try{
            Double[] Prices = ArrayOfSortingPrice();
            for (int i = 0; i < Prices.length - 1; i++) {
                if (Prices[i] > Prices[i + 1]) {
                    IsSort="No";
                    return IsSort;
                }
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
        return IsSort;

    }
    public String CheckSortingHighToLow(){
        String IsSort ="HighToLow";
        try{
            Double[] Prices = ArrayOfSortingPrice();
            for (int i = 0; i < Prices.length - 1; i++) {
                if (Prices[i] < Prices[i + 1]) {
                    IsSort="No";
                    return IsSort;
                }
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
        return IsSort;

    }

    public String CheckSortingAtoZ(){
        String IsSort ="AtoZ";
        WebElement ItemNamesArray[]= ArrayOfElement(InventoryItemNames);

        for (int i = 0; i < ItemNamesArray.length - 1; i++) {
            if (InventoryItemNames.get(i).getText().compareTo(InventoryItemNames.get(i + 1).getText()) > 0) {
                return "no";
            }
        }
 return IsSort;
    }
    public String CheckSortingZtoA(){
        String IsSort ="ZtoA";
        WebElement ItemNamesArray[]= ArrayOfElement(InventoryItemNames);

        for (int i = 0; i < ItemNamesArray.length - 1; i++) {
            if (InventoryItemNames.get(i).getText().compareTo(InventoryItemNames.get(i + 1).getText()) < 0) {
                return "no";
            }
        }
        return IsSort;
    }
    public void ClickCartIcon(){
        CartIcon.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String GetCartBadgeNumber(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement cartBadge = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_badge")));
            return cartBadge.getText();
        } catch (TimeoutException e) {
            return "0";
        }

    }
    public void SortByDropdownBox(String Option){
        try {
        SortByDropDownBOx.click();
        Thread.sleep(1000);
        Select Drop = new Select(SortByDropDownBOx);
        Drop.selectByVisibleText(Option);
        Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
