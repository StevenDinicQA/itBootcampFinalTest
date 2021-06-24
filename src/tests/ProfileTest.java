package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTest extends BasicTest {

	@Test
	public void profileEdit() throws InterruptedException {

		driver.get(baseUrl + "guest-user/login-form");
		Thread.sleep(2000);

//		closes the popup button
		locPopPage.getCloseBtn();
		Thread.sleep(1000);

//		enters credentials using the username and password from basic test
		loginPage.submitCred(username, password);

//		checking if the message appears on login and waiter for it to disappear
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(notSysPage.getPopupMsg(), "Login Successful");
		notSysPage.disappearMsg();

		driver.get(baseUrl + "member/profile");
		Thread.sleep(1500);

//		editing profile details
		profPage.profileCred("Mark", "Markovich", "Washington St. 23", "2225559686", "21568", "United States",
				"Waterford", "Waterford");
		Thread.sleep(1500);
		profPage.getSaveBtn().click();

//		asserting if the right message appeard
		sa.assertEquals(notSysPage.getPopupMsg(), "Setup Successful");
		notSysPage.disappearMsg();

//		logout and assert of the logout message appearance
		authPage.AccClick();
		Thread.sleep(500);
		authPage.LogoutClick();
		Thread.sleep(2000);
		sa.assertEquals(notSysPage.getPopupMsg(), "Logout Successfull");
		notSysPage.disappearMsg();
	}

	@Test
	public void profileImgChange() throws InterruptedException {
		driver.get(baseUrl + "guest-user/login-form");
//		closes the popup button
		locPopPage.getCloseBtn();
		Thread.sleep(1000);

//		enters credentials using the username and password from basic test
		loginPage.submitCred(username, password);

//		checking if the message appears on login and waiter for it to disappear
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(notSysPage.getPopupMsg(), "Login Successful");
		notSysPage.disappearMsg();

		driver.get(baseUrl + "member/profile");
		Thread.sleep(1500);

//		uploading image function and selecting the image from the folder
		profPage.getUploadBtn();
		Thread.sleep(700);
		profPage.pictureUpload();
		Thread.sleep(700);
		sa.assertEquals(notSysPage.getPopupMsg(), "Profile Image Uploaded Successfully");
		notSysPage.disappearMsg();

//		deleting the picture function
		profPage.deletePictureBtn();
		sa.assertEquals(notSysPage.getPopupMsg(), "Profile Image Deleted Successfully");
		notSysPage.disappearMsg();

//		logout and assert of the logout message appearance
		authPage.AccClick();
		Thread.sleep(500);
		authPage.LogoutClick();
		Thread.sleep(2000);
		sa.assertEquals(notSysPage.getPopupMsg(), "Logout Successfull");
		notSysPage.disappearMsg();
	}
}
