package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealsTest extends BasicTest{

	
	@Test
	public void addMealToCart () throws InterruptedException{
		
		driver.get(baseUrl+ "lobster-shrimp-chicken-quesadilla-combo");
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
		
//		adding the locatiion
		locPopPage.locationName("City Center - Albany");
		locPopPage.popupClose();
		
//		clears item number and adds random number of items to the cart again
		mealPage.getQuantity().clear();
		mealPage.addToCart("5");
		
		sa.assertEquals(notSysPage.getalertMsg(), "Meal Added To Cart");
		notSysPage.disappearMsg();
	}
	
	@Test
	public void addMealToFavorite () throws InterruptedException{
		
//		getting the meal
		driver.get(baseUrl+ "lobster-shrimp-chicken-quesadilla-combo");
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
		driver.get(baseUrl+ "lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1000);
		
//		click on favorite button again
		mealPage.clickFav();
		
//		testing if the correct message appears
		sa.assertEquals(notSysPage.getalertMsg(), "Product has been added to your favorites!");
		notSysPage.disappearMsg();
	}	
}
