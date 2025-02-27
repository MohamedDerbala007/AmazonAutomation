package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBases.PageBase;

public class CheckoutPage extends PageBase {
    WebDriverWait wait;
    JavascriptExecutor js;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='checkout-deliveryAddressPanel']/div/div[2]/span/a")
    private WebElement changeAddressBtn;

    @FindBy(id = "add-new-address-desktop-sasp-tango-link")
    private WebElement addNewAddressBtn;

    @FindBy(id = "address-ui-widgets-countryCode-dropdown-nativeId")
    private WebElement countryDropdown;

    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    private WebElement fullNameInput;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    private WebElement mobileNumberInput;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    private WebElement streetNameInput;

    @FindBy(id = "address-ui-widgets-enter-building-name-or-number")
    private WebElement buildingNameInput;

    @FindBy(id = "address-ui-widgets-enterAddressCity")
    private WebElement cityInput;

    @FindBy(id = "address-ui-widgets-form-submit-button")
    private WebElement useThisAddressBtn;

    @FindBy(xpath = "//*[@id='checkout-paymentOptionPanel']/div/div[2]/span/a")
    private WebElement changePaymentMethodBtn;
    
    @FindBy(xpath = "//*[@id=\"pp-TOEpC7-166\"]")
    private WebElement cashOnDeliveryRB;
    
    @FindBy(xpath = "//*[@id=\"checkout-primary-continue-button-id\"]/span/input")
    private WebElement useThisMehodBtn;


    public void addDeliveryAddress(String country, String fullName, String mobileNumber, 
                                   String street, String building, String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(changeAddressBtn));
        clickButton(changeAddressBtn);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000); 
        js.executeScript("window.scrollBy(0, 600);"); 
         
        wait.until(ExpectedConditions.elementToBeClickable(addNewAddressBtn));
        clickButton(addNewAddressBtn);

        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);
        
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);

        mobileNumberInput.clear();
        mobileNumberInput.sendKeys(mobileNumber);

        streetNameInput.clear();
        streetNameInput.sendKeys(street);

        buildingNameInput.clear();
        buildingNameInput.sendKeys(building);

        cityInput.clear();
        cityInput.sendKeys(city);
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        js.executeScript("window.scrollBy(0, 200);"); 
        wait.until(ExpectedConditions.elementToBeClickable(useThisAddressBtn));
        clickButton(useThisAddressBtn);

    }


    public void addPaymentMethod() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(changePaymentMethodBtn));
        clickButton(changePaymentMethodBtn);
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, 400);"); 
        clickButton(cashOnDeliveryRB);
        Thread.sleep(2000);
        clickButton(useThisMehodBtn);
    }
}
