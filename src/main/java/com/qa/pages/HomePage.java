package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),sudarshandn naid')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contactslink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals']")
	WebElement Dealslink;
	
	@FindBy(xpath="//a[@class='topnavlink'] [contains(.,'Logout')]")
	WebElement logout;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactslink(){
		Contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealslink(){
		Dealslink.click();
		return new DealsPage();
	}
	
	public LoginPage clickOnLogout(){
		logout.click();
		return new LoginPage();
	}
	public void clickOnNewContactLink(){
		
		Actions action = new Actions(driver);
		action.moveToElement(Contactslink).build().perform();
		newContactLink.click();
		
	}
	
	
}
