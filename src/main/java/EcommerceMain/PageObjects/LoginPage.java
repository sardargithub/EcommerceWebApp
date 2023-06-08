package EcommerceMain.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceMain.AbstractComponents.Abstractcomponent;


public class LoginPage
{
@FindBy(id="userEmail")
private WebElement userEmail;
@FindBy(id="userPassword")
private WebElement userpassword;
@FindBy(id="login")
private WebElement loginbutton;

public LoginPage()
{
	PageFactory.initElements(Abstractcomponent.driver, this);
}

public ProductsListPage enterUsernameandPassword(String username,String password)
{
	userEmail.sendKeys(username);
	userpassword.sendKeys(password);
	loginbutton.click();
	ProductsListPage plp=new ProductsListPage();
	return plp;
}

}
