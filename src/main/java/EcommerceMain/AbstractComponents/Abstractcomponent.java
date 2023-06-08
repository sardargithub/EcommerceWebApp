package EcommerceMain.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Abstractcomponent 
{
public static WebDriver driver;
public void definedriver()
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/client");		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
}
/*
 * @FindBy(xpath="//*[@routerlink='/dashboard/cart']") private WebElement
 * selectaddtoCart;
 */


public void WaittheElementuptodisplay(By FindBy)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}
public void WaitforElementtoDisappiear(WebElement invisible) throws InterruptedException
{
	Thread.sleep(1000);
	/*
	 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 * wait.until(ExpectedConditions.invisibilityOf(invisible));
	 */
}

public void ClickonaddtoCartbutton()
{
	WebElement ClickonaddtoCartbutton= driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']"));
	JavascriptExecutor MoveuptoaddtoCartbutton = (JavascriptExecutor) driver;
	MoveuptoaddtoCartbutton.executeScript("arguments[0].click();", ClickonaddtoCartbutton);
}

public void MoveuptoElement()
{
	
}


}
