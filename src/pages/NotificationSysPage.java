package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationSysPage extends BasicPage {

	public NotificationSysPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	popup message when logged in or entering wrong credentials
	public WebElement getalertMsg() {
		return driver.findElement(By.xpath(
				"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

}
