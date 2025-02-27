package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageBases.PageBase;

public class LeftSideMenu extends PageBase
{

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public LeftSideMenu(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/li[14]/a[1]")
	public WebElement seeAllBtn;
	
	@FindBy(linkText = "Video Games")
	public WebElement videoGamesCategory;
	
	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[16]/li[3]/a")
	public WebElement allVideoGamesCategory;
	
	public void openVideoGamesProductsPage()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(seeAllBtn));
		clickButton(seeAllBtn);
		wait.until(ExpectedConditions.elementToBeClickable(videoGamesCategory));
		clickButton(videoGamesCategory);
		wait.until(ExpectedConditions.visibilityOf(allVideoGamesCategory));
        wait.until(ExpectedConditions.elementToBeClickable(allVideoGamesCategory));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", allVideoGamesCategory);
        js.executeScript("arguments[0].click();", allVideoGamesCategory);
	}

}
