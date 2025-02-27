package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageBases.PageBase;

public class HomePage extends PageBase
{

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
	public WebElement linkOfAccountAndLists;
	
	@FindBy(xpath = "//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	public WebElement signInBtn;
	
	@FindBy(id = "nav-hamburger-menu")
	public WebElement leftSideMenuBtn;
	
	public void hoverOverAccountAndLists() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(linkOfAccountAndLists));
        hoverOverElement(linkOfAccountAndLists);
    }
	
	public void signInToAccount()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
		clickButton(signInBtn);
	}
	
	public void openLeftSideMenu()
	{
		wait.until(ExpectedConditions.elementToBeClickable(leftSideMenuBtn));
		clickButton(leftSideMenuBtn);
	}

}
