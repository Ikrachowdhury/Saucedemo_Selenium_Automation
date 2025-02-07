
package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class CheckoutOverview {
    WebDriver driver;
    public  CheckoutOverview(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindAll({
            @FindBy(className ="inventory_item_name")
    })
    List<WebElement> InventoryItemNames;

    @FindBy(id = "finish")
    WebElement FinishButton;
    @FindBy(className = "complete-header")
    WebElement Complete;

    public WebElement[] ArrayOfElement(List<WebElement> ElementArray){
        List<WebElement> elements = ElementArray;
        WebElement[] elementArray = new WebElement[elements.size()];
        elements.toArray(elementArray);

        return elementArray;

    }

    public List<String> GetCartItemNames(){
        List<String> addedItems = new ArrayList<>();
        try{
            WebElement ItemNamesArray[]= ArrayOfElement(InventoryItemNames);
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

    public void ClickFinishButton() {
        try {
            FinishButton.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
