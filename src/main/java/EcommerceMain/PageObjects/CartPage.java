package EcommerceMain.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceMain.AbstractComponents.Abstractcomponent;

public class CartPage 
{
@FindBy(xpath="//*[@class='cartSection']/h3")
private List<WebElement> ListofProductsinCartpage;

//@FindBy(xpath="//*[@class='totalRow']/button")
@FindBy(css= ".totalRow button")
private WebElement Checkoutbutton;

public CartPage()
{
	PageFactory.initElements(Abstractcomponent.driver, this);
}

public Boolean verifyProductdisplay(String productName)
{
	
	Boolean match=ListofProductsinCartpage.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
	return match;
}
public CheckoutPage clickonCheckoutbutton()
{
	Checkoutbutton.click();
	return new CheckoutPage();
}

}
