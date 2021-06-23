package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
//	get item quantity
	public WebElement getQuantity () {
		return driver.findElement(By.name("product_qty"));
	}
	
//	get add to cart button
	public WebElement getAddCartBtn () {
		return driver.findElement(By.xpath("//*[@class= 'js-proceedtoAddInCart']"));
	}
	
//	get favorite button
	public WebElement getFavBtn () {
		return driver.findElement(By.className("itemfav"));
	}
	
//	method for adding to cart
	public void addToCart (String num) {
		getQuantity().clear();
		getQuantity().getAttribute(num);
		getAddCartBtn().click();
	}
	
//	favorite button click method
	public void clickFav () {
		getFavBtn().click();
	}
}
