package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageBases.PageBase;

public class PrimeSubcriptionPage extends PageBase{
	WebDriverWait wait;

	public PrimeSubcriptionPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "prime-interstitial-nothanks-button")
	private WebElement continueWithoutPrime;
	
	public void cancelPrime()
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueWithoutPrime));
    	clickButton(continueWithoutPrime);
	}

}
