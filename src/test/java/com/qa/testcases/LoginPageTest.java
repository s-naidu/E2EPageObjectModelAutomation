package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
public LoginPageTest(){
	
	super();
}
	@BeforeMethod
	public void setUP(){
		insilization();
		loginPage= new LoginPage();
	}
	
	@Test
	public void lgoinPageTitleTest(){
		String title=loginPage.validateloginPageTile();
		//Assert.assertEquals(title, "CRMPRO");
		Assert.assertEquals(title, "CRMPRO Log In Screen");
		
	}
	
	@Test
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
		
	@Test
	public void loginTest(){
	homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	
	@AfterMethod
	public void tearDown(){
	
		driver.quit();
	}

}
