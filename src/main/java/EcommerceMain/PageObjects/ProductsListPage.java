package EcommerceMain.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceMain.AbstractComponents.Abstractcomponent;

public class ProductsListPage extends Abstractcomponent
{
@FindBy(xpath="//div[contains(@class,'mb-3')]")
private List<WebElement> listofproducts;

@FindBy(css=".ng-animating")
private WebElement spinner;

By ProducedBy=By.xpath("//div[contains(@class,'mb-3')]");
By addtocart=By.cssSelector(".card-body button:last-of-type");
By toastMessage=By.xpath("//div[@id='toast-container']");

public ProductsListPage()
{
	PageFactory.initElements(Abstractcomponent.driver, this);
}
public List<WebElement> gettheListofProducts()
{
	WaittheElementuptodisplay(ProducedBy);
	return listofproducts;
}

public WebElement getProductByName(String ProductName)
{
	WebElement prod=gettheListofProducts().stream().filter(product->product.findElement(By.xpath("//div[contains(@class,'mb-3')]/div/div/h5/b")).getText().equals(ProductName))
			.findFirst().orElse(null);
	return prod;
}

public void addProducttoCart(String ProductName) throws InterruptedException
{
	WebElement prod=getProductByName(ProductName);
	prod.findElement(addtocart).click();
	WaittheElementuptodisplay(toastMessage);
	WaitforElementtoDisappiear(spinner);
}

}
