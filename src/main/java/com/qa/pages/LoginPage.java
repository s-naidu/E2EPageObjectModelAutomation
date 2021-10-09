package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//page factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up']")
	WebElement  signUpBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	public String validateloginPageTile(){
		return driver.getTitle();
	}
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
