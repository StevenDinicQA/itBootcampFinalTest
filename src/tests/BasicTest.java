package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BasicTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void cleanup() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
}
