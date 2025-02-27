package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageBases.PageBase;

public class LoginPage extends PageBase
{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	public WebElement mobileOrEmailField;
	
	@FindBy(className = "a-button-input")
	public WebElement continueBtn;
	
	@FindBy(id = "ap_password")
	public WebElement passwordField;
	
	@FindBy(id = "signInSubmit")
	public WebElement signInSubmit;
	
	public void signIntoAmazon(String email, String password)
	{
		wait.until(ExpectedConditions.visibilityOf(mobileOrEmailField));
		setTextInElementTextBox(mobileOrEmailField, email);
		clickButton(continueBtn);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		setTextInElementTextBox(passwordField, password);
		clickButton(signInSubmit);
	}

}
