package EcommerceMain.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import EcommerceMain.AbstractComponents.Abstractcomponent;

public class CheckoutPage extends Abstractcomponent
{
@FindBy(xpath="//input[@placeholder='Select Country']")
private WebElement country;
@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
private WebElement selectCountry;
//@FindBy(css=".action__submit")
//private WebElement Submit;
By results=By.cssSelector(".ta-results");
public CheckoutPage()
{
	PageFactory.initElements(Abstractcomponent.driver, this);
}
public void SelecttheCountry(String countryName)
{
	Actions a = new Actions(driver);
	a.sendKeys(country,countryName).build().perform();
	WaittheElementuptodisplay(results);
	selectCountry.click();
}
public ConfirmationPage submitOrder()
{
	//Submit.click();
	WebElement Clickonsubmit= driver.findElement(By.cssSelector(".action__submit"));
	JavascriptExecutor Moveuptosubmit = (JavascriptExecutor) driver;
	Moveuptosubmit.executeScript("arguments[0].click();", Clickonsubmit);
	return new ConfirmationPage();
}
}
