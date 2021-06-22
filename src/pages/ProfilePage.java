package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	get user name
	public WebElement getName() {
		return driver.findElement(By.name("user_first_name"));
	}

//	get user surname
	public WebElement getSurname() {
		return driver.findElement(By.name("user_last_name"));
	}

//	get email
	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
	}

//	get address
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}

//	get phone number
	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
	}

//	get user zip code
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}

//	get country list -- dropdown select needed afterwards
	public WebElement getCountry() {
		return driver.findElement(By.name("user_country_id"));
	}

//	get state list -- dropdown select needed afterwards
	public WebElement getState() {
		return driver.findElement(By.name("user_state_id"));
	}

//	get city list -- dropdown select needed afterwards
	public WebElement getCity() {
		return driver.findElement(By.name("user_city"));
	}

//	get save button
	public WebElement getSaveBtn() {
		return driver.findElement(By.name("btn_submit"));
	}

	public WebElement getAvatarEl() {
		return driver.findElement(By.className("avatar"));
	}

//	get upload button 
	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//a[@title=\"Uplaod\"]/i"));
	}

	public WebElement getRemoveBtn() {
		return driver.findElement(By.xpath("//a[@title=\"Remove\"]"));
	}

//	picture upload hover and click
	public void pictureUploadBtn() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement avatar = getAvatarEl();
		action.moveToElement(avatar).build().perform();
		Thread.sleep(1000);
		WebElement uplBtn = getUploadBtn();
		js.executeScript("arguments[0].click();", uplBtn);

	}

//	picture upload
	public void pictureUpload() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title=\"Uplaod\"]")).click();
		WebElement upload = driver.findElement(By.xpath("//input [@type=\"file\"]"));
		upload.sendKeys("C:\\\\Users\\\\Stevan\\\\Desktop\\\\algr.jpg");
		Thread.sleep(2000);
	}

//	deleting the picture
	public void deletePictureBtn() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement avatar = getAvatarEl();
		action.moveToElement(avatar).build().perform();
		Thread.sleep(1000);
		WebElement remBtn = getRemoveBtn();
		js.executeScript("arguments[0].click();", remBtn);
	}

}
