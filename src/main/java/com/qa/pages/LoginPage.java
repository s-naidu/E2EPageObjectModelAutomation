package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.qameta.allure.Step;

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
	@Step("Getting login page title")
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	@Step("Validating login pagee etitle")
	public String validateloginPageTile(){
		return driver.getTitle();
	}
	@Step("login with username{0} and password: {1} step ...")
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
