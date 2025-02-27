package tests;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LeftSideMenu;
import pages.LoginPage;
import pages.VideoGamesProductsPage;
import pages.CheckoutPage;
import pages.PrimeSubcriptionPage;
import tests.TestBases.TestBase;
import utils.ConfigReader;

public class PurchaseProductsFromAmazonTest extends TestBase {
    WebDriverWait wait;
    HomePage homeObject;
    LoginPage loginObject;
    LeftSideMenu leftSideMenuObject;
    VideoGamesProductsPage videoGamesProductsObject;
    CartPage cartObject;
    PrimeSubcriptionPage primeSubcriptionObject;
    CheckoutPage checkoutObject;

    String email = ConfigReader.getProperty("amazon.email");
    String password = ConfigReader.getProperty("amazon.password");

    String country = ConfigReader.getProperty("address.country");
    String fullName = ConfigReader.getProperty("address.fullName");
    String mobileNumber = ConfigReader.getProperty("address.mobileNumber");
    String street = ConfigReader.getProperty("address.street");
    String building = ConfigReader.getProperty("address.building");
    String city = ConfigReader.getProperty("address.city");
    String state = ConfigReader.getProperty("address.state");

    @Test
    public void purchasingProductsSuccessfully() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homeObject = new HomePage(driver);
        homeObject.hoverOverAccountAndLists();
        homeObject.signInToAccount();
        loginObject = new LoginPage(driver);
        loginObject.signIntoAmazon(email, password);

        homeObject = new HomePage(driver);
        homeObject.openLeftSideMenu();
        leftSideMenuObject = new LeftSideMenu(driver);
        leftSideMenuObject.openVideoGamesProductsPage();

        videoGamesProductsObject = new VideoGamesProductsPage(driver);
        videoGamesProductsObject.filterVideoGamesProducts("Price: High to Low");
        videoGamesProductsObject.addAffordableVideoGamesToCart(15000, 2);
        videoGamesProductsObject.openShoppingCart();

        cartObject = new CartPage(driver);
        int expectedCount = videoGamesProductsObject.getAddedProductCount();
        cartObject.verifyCartItemCount(expectedCount);
        cartObject.openCheckoutPage();

        primeSubcriptionObject = new PrimeSubcriptionPage(driver);
        primeSubcriptionObject.cancelPrime();

        checkoutObject = new CheckoutPage(driver);
        checkoutObject.addDeliveryAddress(country, fullName, mobileNumber, street, building, city);
        checkoutObject.addPaymentMethod();
    }
}
