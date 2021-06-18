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
	public WebElement emailAddress () {
		return driver.findElement(By.name("username"));
	}

//	password for login
	public WebElement passwordEl () {
		return driver.findElement(By.name("password"));
	}
	
//	submitting the login credentials
	public void submitCred (String username, String password) {
		emailAddress().getAttribute(username);
		passwordEl().getAttribute(password);
		driver.findElement(By.name("btn_submit"));
	}
}
