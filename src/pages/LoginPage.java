package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	email address for username login
	public WebElement getemailAddress () {
		return driver.findElement(By.name("username"));
	}

//	password for login
	public WebElement getpasswordElement () {
		return driver.findElement(By.name("password"));
	}
	
//	submit button
	public WebElement getBtnSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	
//	submitting the login credentials
	public void submitCred (String username, String password) throws InterruptedException {
		getemailAddress().clear();
		getemailAddress().getAttribute(username);
		Thread.sleep(500);
		getpasswordElement().clear();
		getpasswordElement().getAttribute(password);
		getBtnSubmit().click();		
	}
}
