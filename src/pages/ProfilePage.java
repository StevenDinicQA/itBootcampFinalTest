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
	public Select getCountry() {
		Select country = new Select(driver.findElement(By.name("user_country_id")));

		return country;
	}

//	get state list -- dropdown select needed afterwards
	public Select getState() {
		Select state = new Select(driver.findElement(By.name("user_state_id")));
		return state;
	}

//	get city list -- dropdown select needed afterwards
	public Select getCity() {
		Select city = new Select(driver.findElement(By.name("user_city")));
		return city;
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

//	updating profile credentials
	public void profileCred(String name, String surname, String address, String phoneNum, String zipCode,
			String country, String state, String city) throws InterruptedException {

		getName().clear();
		getName().sendKeys("name");
		Thread.sleep(1000);

		getSurname().clear();
		getSurname().sendKeys("surname");
		Thread.sleep(1000);

		getAddress().clear();
		getAddress().sendKeys("address");
		Thread.sleep(1000);

		getPhone().clear();
		getPhone().sendKeys(phoneNum);
		Thread.sleep(1000);

		getZipCode().click();
		getZipCode().clear();
		getZipCode().sendKeys(zipCode);
		Thread.sleep(1000);

		getCountry().selectByVisibleText(country);
		Thread.sleep(1000);

		getState().selectByVisibleText(state);
		Thread.sleep(1000);

		getCity().selectByVisibleText(city);
		Thread.sleep(1000);
	}
}
