package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	location selection element
	public WebElement getSelectLocation() {
		return driver.findElement(By.className("location-selector"));
	}

//	close button element
	public WebElement getCloseBtn() {
		return driver.findElement(By.xpath("//div[@class=\"model-box-mid location-search\"]/a"));
	}

//	keywords element
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

//	location item element
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}

//	location input element
	public WebElement getLocationInput() {
		return driver.findElement(By.id("locality_keyword"));
	}

//	submit btn element
	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}

//	click method for location
	public void clickLocation() {
		getSelectLocation().click();
	}

//	location input method
	public void locationName(String locationName) {
		getSelectLocation().click();
		getKeyword().click();
		String loc = getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), loc);
		js.executeScript("arguments[0].click()", getSubmit());
	}

	// close button click
	public void popupClose() {
		this.getCloseBtn().click();
	}
}
