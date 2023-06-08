package EcommerceMain.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceMain.AbstractComponents.Abstractcomponent;

public class ConfirmationPage extends Abstractcomponent
{
@FindBy(xpath="//*[@class='hero-primary']")
private WebElement confirmationMesssage;

public ConfirmationPage()
{
	PageFactory.initElements(Abstractcomponent.driver, this);
}

public String verifyConfirmationMessage()
{
	return confirmationMesssage.getText();
}
}
