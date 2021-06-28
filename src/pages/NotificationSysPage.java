package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSysPage extends BasicPage {

	public NotificationSysPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	popup message when entering right or wrong credentials
	public WebElement getalertMsg() {
		return driver
				.findElement(By.xpath("//*[contains(@class, 'alert--success')] or contains(@class, 'alert--danger')]"
						+ "[contains(@style,'display: block')]"));
	}

//	getting visible text message
	public String getPopupMsg() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')] or contains(@class, 'alert--danger')]\"\r\n" + 
				"						+ \"[contains(@style,'display: block')]")).getText();
	}

//	waiter for the message to disappear
	public void disappearMsg() {
		WebDriverWait waiter = new WebDriverWait(driver, 20);
		WebElement msg = getalertMsg();
		waiter.until(ExpectedConditions.attributeContains(msg, "style", "display: none"));
	}
}
