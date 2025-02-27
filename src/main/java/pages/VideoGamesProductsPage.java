package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBases.PageBase;

public class VideoGamesProductsPage extends PageBase {
    WebDriverWait wait;
    JavascriptExecutor js;
    private int addedProductCount = 0; // ✅ Track added product count

    public VideoGamesProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//*[@id='s-refinements']/div[2]/ul/li/span/a/div[1]/label/i")
    public WebElement freeShippingCheckBox;

    @FindBy(xpath = "//*[@id='p_n_condition-type/28071525031']/span/a/span")
    public WebElement newConditionFilter;

    @FindBy(css = "#a-autoid-0-announce")
    public WebElement sortMenu;

    @FindBy(xpath = "//a[contains(@class, 's-pagination-next')]")
    public WebElement nextPageButton;
    
    @FindBy(xpath = "//*[@id='nav-cart-count-container']")
    public WebElement openCartBtn;
    
    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    private List<WebElement> productContainers;

    @FindBy(className = "a-price-whole")
    public List<WebElement> productPrices;

    public void filterVideoGamesProducts(String sortByVisibleText) {
        wait.until(ExpectedConditions.elementToBeClickable(freeShippingCheckBox));
        clickButton(freeShippingCheckBox);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", newConditionFilter);
        wait.until(ExpectedConditions.elementToBeClickable(newConditionFilter));
        clickButton(newConditionFilter);
        wait.until(ExpectedConditions.elementToBeClickable(sortMenu));
        clickButton(sortMenu);

        List<WebElement> sortOptions = driver.findElements(By.cssSelector(".a-dropdown-link"));
        for (WebElement option : sortOptions) {
            if (option.getText().trim().equalsIgnoreCase(sortByVisibleText)) {
                option.click();
                break;
            }
        }
    }

    public int getAddedProductCount() {
    	System.out.println("Expected cart count (Added Products): " + addedProductCount);
        return addedProductCount; 
    }

    public void addAffordableVideoGamesToCart(int priceLimit, int iterations) throws InterruptedException {
        for (int i = 0; i < iterations; i++) {
            for (WebElement product : productContainers) {
                try {
                    WebElement priceElement = product.findElement(By.className("a-price-whole"));
                    String priceText = priceElement.getText().replaceAll("[^0-9]", ""); 
                    
                    if (!priceText.isEmpty()) {
                        int price = Integer.parseInt(priceText);
                        if (price > priceLimit) {
                            continue;
                        }
                        
                        List<WebElement> addToCartButtons = product.findElements(By.xpath(".//button[contains(text(), 'Add to cart') or contains(@id, 'add-to-cart-button')]"));
                        if (addToCartButtons.isEmpty()) {
                            continue;
                        }
                        
                        WebElement addToCartButton = addToCartButtons.get(0);
                        addToCartButton.click();
                        
                        addedProductCount++; 

                        Thread.sleep(5000); 
                    }
                } catch (Exception e) {
                    System.out.println("Skipping product due to an error: " + e.getMessage());
                }
            }

            if (nextPageButton.isDisplayed()) {
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", nextPageButton);
                nextPageButton.click();
                Thread.sleep(5000); 
            }
        }
    }

    public void openShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(openCartBtn));
        clickButton(openCartBtn);
    }
}
