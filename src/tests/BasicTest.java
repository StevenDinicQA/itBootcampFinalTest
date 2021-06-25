package tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSysPage;
import pages.ProfilePage;
import pages.SearchResultPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";
	protected LoginPage loginPage;
	protected LocationPopupPage locPopPage;
	protected ProfilePage profPage;
	protected NotificationSysPage notSysPage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSumPage;
	protected SearchResultPage searchResPage;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		loginPage = new LoginPage(driver, js);
		locPopPage = new LocationPopupPage(driver, js);
		profPage = new ProfilePage(driver, js);
		notSysPage = new NotificationSysPage(driver, js);
		authPage = new AuthPage(driver, js);
		mealPage = new MealPage(driver, js);
		cartSumPage = new CartSummaryPage(driver, js);
		searchResPage = new SearchResultPage(driver, js);
	}
	
	@AfterMethod
	public void cleanup() throws InterruptedException, IOException {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("D:\\QA\\Projects\\Project1\\itBootcampFinalTest\\screenshots");
		
		LocalDateTime locdt = LocalDateTime.now();
		DateTimeFormatter dtform = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		
		FileUtils.copyFile(SrcFile, new File("./screenshots/"+locdt.format(dtform)+".png"));
		
		Thread.sleep(4000);
		driver.quit();
	}
	
}
