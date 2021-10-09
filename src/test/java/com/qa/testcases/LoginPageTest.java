package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

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
	
	@Test(priority=1 ,description= "Verifyng loginpage title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test description: Verify login page title test")
	@Story("This is Story name test")
	public void lgoinPageTitleTest(){
		String title=loginPage.validateloginPageTile();
		//Assert.assertEquals(title, "CRMPRO");
		Assert.assertEquals(title, "CRMPRO Log In Screen");
		
	}
	
	@Test(priority=2 ,description= "Verifyng loginpage logo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test description: Verify login page logo test")
	@Story("This is Story name test")
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
		
	@Test(priority=3 ,description= "Verifyng loginpage with valid details")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test description: Verify loginpage with valid details")
	@Story("This is Story name test")
	public void loginTest(){
	homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	
	@AfterMethod
	public void tearDown(){
	
		driver.quit();
	}

}
