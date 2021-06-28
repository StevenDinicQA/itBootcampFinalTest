package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealsTest extends BasicTest {

	@Test
	public void addMealToCart() throws InterruptedException {

		driver.get(baseUrl + "lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1000);

//		closes the popup button
		locPopPage.getCloseBtn();
		Thread.sleep(1000);

//		clears item number and adds random number of items to the cart
		mealPage.getQuantity().clear();
		mealPage.addToCart("5");

//		testing if the correct message appears
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(notSysPage.getalertMsg(), "The Following Errors Occurred: Please Select Location");
		notSysPage.disappearMsg();
		Thread.sleep(2000);

//		adding the locatiion
		locPopPage.clickLocation();
		locPopPage.locationName("City Center - Albany");

//		clears item number and adds random number of items to the cart again
		mealPage.getQuantity().clear();
		mealPage.addToCart("5");

		sa.assertEquals(notSysPage.getalertMsg(), "Meal Added To Cart");
		notSysPage.disappearMsg();
	}

	@Test
	public void addMealToFavorite() throws InterruptedException {

//		getting the meal
		driver.get(baseUrl + "lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1000);

//		closes the popup button
		locPopPage.getCloseBtn();
		Thread.sleep(1000);

//		click on favorite button
		mealPage.clickFav();

//		testing if the correct message appears
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(notSysPage.getalertMsg(), "Please login first!");
		notSysPage.disappearMsg();

//		logging in with credentials from basic test
		loginPage.loginBtn();
		loginPage.submitCred(username, password);

//		getting the meal again
		driver.get(baseUrl + "lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1000);

//		click on favorite button again
		mealPage.clickFav();

//		testing if the correct message appears
		sa.assertEquals(notSysPage.getalertMsg(), "Product has been added to your favorites!");
		notSysPage.disappearMsg();
	}

	@Test
	public void clearCart() throws InterruptedException, IOException {

//		getting the meal
		driver.get(baseUrl + "meals");
		Thread.sleep(1000);

//		adding the locatiion
		locPopPage.locationName("City Center - Albany");
		locPopPage.popupClose();

//		setting up the test to read from the data sheet excel file
		File file = new File("data\\Data.xlsx");

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meals");

//		inserting the data sheet information in for loop
		for (int i = 1; i < 6; i++) {
			String links = sheet.getRow(i).getCell(0).getStringCellValue();
			double quantity = sheet.getRow(i).getCell(1).getNumericCellValue();

//			converting double to String to add to the method for adding to cart
			String quant = String.valueOf(quantity);
			driver.get(links);
			mealPage.addToCart(quant);
			Thread.sleep(2000);

//			asserting if the correct message appears
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(notSysPage.getalertMsg(), "Meal Added To Cart");
			notSysPage.disappearMsg();
		}

		cartSumPage.clickClearBtn();
		Thread.sleep(2000);

//		asserting if the correct message appears
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(notSysPage.getalertMsg(), "All meals removed from Cart successfully");
		notSysPage.disappearMsg();
	}
}
