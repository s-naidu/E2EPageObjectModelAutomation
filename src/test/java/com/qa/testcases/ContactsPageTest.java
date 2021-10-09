package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setUP() throws InterruptedException{
		insilization();
		testutil =new TestUtil();
		contactsPage =new ContactsPage();
		loginPage= new LoginPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");

		testutil.switchToFrame();
		//
	}
	
	@Test(priority=1)
	public void verifyContactsLabel(){
		homepage.clickOnContactslink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts panel is missing on the page");
		
		
	}
	
	@Test(priority=2)
	public void selectsingleContactsTest(){
		homepage.clickOnContactslink();
	contactsPage.selectContactsByName("sudarshan naidu");
	
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		homepage.clickOnNewContactLink();
		
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	
	@AfterMethod
	public void tearDown(){

		driver.quit();
	}

	
}


