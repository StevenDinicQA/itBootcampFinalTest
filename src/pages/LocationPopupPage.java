package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getSelectLocation () {
		return driver.findElement(By.className("location-selector"));
	}
	
	public WebElement getCloseBtn () {
		return driver.findElement(By.xpath("//div[@class=\"model-box-mid location-search\"]/a"));
	}
		
	public WebElement getKeyword () {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem (String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}
	
	public WebElement getLocationInput () {
		return driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getSubmit () {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void clickLocation () {
		getSelectLocation().click();
	}
	
	
	
	
}
