package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
//	get clear all button
	public WebElement getClearBtn () {
		return driver.findElement(By.xpath("//*[@onclick=\"clearCartItems()\"]"));
	}
	
//	method for clicking the button
	public void clickClearBtn () {
		getClearBtn().click();
	}
	
}
