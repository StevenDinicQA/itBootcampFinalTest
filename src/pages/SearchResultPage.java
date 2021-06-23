package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasicPage{

	public SearchResultPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
	public WebElement productName () {
		return driver.findElement(By.xpath("//*[@class='product-name']/a"));
	}
	
	public List<WebElement> searchNames (){
		
		return driver.findElements(By.className("product-name"));
	}
	
	public List<WebElement> resultNum (){
		return (List<WebElement>) driver.findElement(By.className("product-name"));
	}
	
}
