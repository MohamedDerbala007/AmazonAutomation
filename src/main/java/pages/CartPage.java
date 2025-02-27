package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.PageBases.PageBase;

public class CartPage extends PageBase {
	
	WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-cart-count")
    private WebElement cartItemCount; 
    
    @FindBy(name = "proceedToRetailCheckout")
    public WebElement checkoutBtn;

    public int getCartItemCount() {
        int count = Integer.parseInt(cartItemCount.getText().trim());
        System.out.println("Actual cart count from UI: " + count); 
        return count;
    }

    public void verifyCartItemCount(int expectedCount) {
        int actualCount = getCartItemCount();
        System.out.println("Comparing Expected: " + expectedCount + " vs Actual: " + actualCount); 
        Assert.assertEquals(actualCount, expectedCount, "Cart item count mismatch!"); 
    }
    
    public void openCheckoutPage()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
    	clickButton(checkoutBtn);
    }

}
