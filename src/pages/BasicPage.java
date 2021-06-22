package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage {

//	attributes for the webdriver and javaScript executor
	protected WebDriver driver;
	protected JavascriptExecutor js;
	
//	constructor
	public BasicPage (WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
//	try/catch method
	public boolean elementExists (WebDriver driver, By by) {
		boolean exists = true;
		try {
			driver.findElement(by);
		} catch (Exception e){
			exists = false;
		}
		return exists;
	}
}
