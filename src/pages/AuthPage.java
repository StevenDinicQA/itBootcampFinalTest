package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	get list item
	public WebElement getAuthList() {
		return driver.findElement(By.xpath("//div [@class=\"accounts-link accounts-popup\"]"));
	}

//	get my account
	public WebElement getAccElement() {
		return driver.findElement(By.xpath("//div [@class=\"my-account-dropdown\"]/ul/li[1]/a"));
	}

//	get logout
	public WebElement getLogout() {
		return driver.findElement(By.xpath("//div [@class=\"my-account-dropdown\"]/ul/li[2]/a"));
	}
	
//	click method for the list
	public void AuthClick () {
		getAuthList().click();
	}
	
//	my account click method
	public void AccClick () {
		getAccElement().click();
	}
	
//	logout click method
	public void LogoutClick () {
		getLogout().click();
	}
}
