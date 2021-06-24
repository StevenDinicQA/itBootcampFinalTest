package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BasicTest {

	protected WebDriver driver;
	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void cleanup() throws InterruptedException {
//		
//		TakesScreenshot scrShot =((TakesScreenshot)driver);
//		File SrcFile=scrShot.getScreenshotAs(OutputType<X>.FILE);
//		File DestFile=new File("D:\\QA\\Projects\\Project1\\itBootcampFinalTest\\screenshots");
		
		
		Thread.sleep(4000);
		driver.quit();
	}
	
}
