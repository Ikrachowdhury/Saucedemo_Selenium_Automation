package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class YourCart {
    WebDriver driver;
    public YourCart(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    @FindAll({
            @FindBy(className ="inventory_item_name")
    })
    List<WebElement> InventoryItemNames;

    @FindBy(className = "shopping_cart_link")
    WebElement CartIcon;
    @FindBy(className = "shopping_cart_badge")
    WebElement CartBadge;
    @FindBy(id = "checkout")
    WebElement CheckoutButton;
    @FindBy(id = "continue-shopping")
    WebElement ContinueShoppingButton;
    public WebElement[] ArrayOfElement(List<WebElement> ElementArray){
        List<WebElement> elements = ElementArray;
        WebElement[] elementArray = new WebElement[elements.size()];
        elements.toArray(elementArray);

        return elementArray;

    }
    public List<String> GetCartItemNames(){
        List<String> addedItems = new ArrayList<>();
        try{
            WebElement ItemNamesArray[]=ArrayOfElement(InventoryItemNames);

            for (int i = 0; i <ItemNamesArray.length; i++) {
                    String ItemName = ItemNamesArray[i].getText();
                    addedItems.add(ItemName);
            }
            Thread.sleep(1000);

        }catch (Exception ex){
            System.out.println(ex);
        }

        return addedItems;
    }
    public void ClickCartIcon(){
        CartIcon.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void ClickCheckoutButton() {
        try {
            CheckoutButton.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

public void ClickContinueShoppingButton(){
        ContinueShoppingButton.click();

}

}
