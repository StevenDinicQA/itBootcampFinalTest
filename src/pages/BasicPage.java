package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	
	public BasicPage (WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
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
