package EcommerceMain.EcomWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import EcommerceMain.AbstractComponents.Abstractcomponent;
import EcommerceMain.PageObjects.CartPage;
import EcommerceMain.PageObjects.CheckoutPage;
import EcommerceMain.PageObjects.ConfirmationPage;
import EcommerceMain.PageObjects.LoginPage;
import EcommerceMain.PageObjects.ProductsListPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends Abstractcomponent{

	public static void main(String[] args) throws InterruptedException {
		
		String productName="ZARA COAT 3";
		Abstractcomponent Ac=new Abstractcomponent();
		Ac.definedriver();
		LoginPage lp=new LoginPage();
		ProductsListPage plp=lp.enterUsernameandPassword("johnsmith123@gmail.com", "Test@123");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        List<WebElement>products=plp.gettheListofProducts();
        plp.addProducttoCart(productName);
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        Ac.ClickonaddtoCartbutton();
        CartPage cp=new CartPage();
        Boolean match=cp.verifyProductdisplay(productName);
		Assert.assertTrue(match);
		WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(5));
		CheckoutPage cop=cp.clickonCheckoutbutton();
		cop.SelecttheCountry("india");
		ConfirmationPage confirm=cop.submitOrder();
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	/*
	 * WebElement ClickonPlaceorder=
	 * driver.findElement(By.cssSelector(".action__submit")); JavascriptExecutor
	 * MoveuptoPlaceorderbutton = (JavascriptExecutor) driver;
	 * MoveuptoPlaceorderbutton.executeScript("arguments[0].click();",
	 * ClickonPlaceorder);
	 */
		String confirmMessage=confirm.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}
