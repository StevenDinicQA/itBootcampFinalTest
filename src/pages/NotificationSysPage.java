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

//	popup message when logged in or entering wrong credentials
	public WebElement getalertMsg() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}

//	getting visible text message
	public String getPopupMsg () {
		return driver.findElement(By.xpath("//div[@class='div_msg']/ul/li")).getText();
	}
	
//	waiter for the message to disappear
	public void disappearMsg () {
		WebDriverWait waiter = new WebDriverWait(driver, 20);
		WebElement msg = driver.findElement(By.xpath("//div[@class=\"system_message alert]"));
		
		waiter.until(ExpectedConditions.attributeToBe(msg, "display:", "none"));
	}
}
