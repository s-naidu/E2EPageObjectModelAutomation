package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
}

	@BeforeMethod
	public void setUP(){
		insilization();
		testutil =new TestUtil();
		loginPage= new LoginPage();
		contactsPage =new ContactsPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testutil.switchToFrame();
	}
	
	@Test
	public void verifyHomePageTitleTest(){
		String homepagetitle= homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page title not matched");
		
	}
	@Test
	public void verifyUserNameTest(){
		
		Assert.assertTrue(homepage.verifyCorrectUserName());
		
	}
	
	@Test
	public void verifyContactsLinkTest(){
		contactsPage=homepage.clickOnContactslink();
		
	}

	@AfterMethod
	public void tearDown(){
	
		driver.quit();
	}

	
}