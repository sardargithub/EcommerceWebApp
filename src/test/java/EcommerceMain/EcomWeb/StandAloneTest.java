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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("johnsmith123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[contains(@class,'mb-3')]"))));
		
		List<WebElement> products=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		WebElement prod=products.stream().filter(product->product.findElement(By.xpath("//div[contains(@class,'mb-3')]/div/div/h5/b")).getText().equals(productName))
		.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//*[@class='totalRow']/button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.querySelector('.tableFixHead').scrollDown=5000");
		//js.executeScript("window.scrollBy(0,1000)", "");
		//js.executeScript("window.scrollBy(0,2000)");
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@class='actions']/a")).click();
		WebElement element=driver.findElement(By.xpath("//*[contains(text(),'Place Order ')]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage=driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}
