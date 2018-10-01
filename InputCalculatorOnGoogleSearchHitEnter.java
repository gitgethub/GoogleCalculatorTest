package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class InputCalculatorOnGoogleSearchHitEnter extends TestBase {
	
	public InputCalculatorOnGoogleSearchHitEnter()	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@name='q']")
	WebElement textSearch;		
	
	public VerifySearchingForCalculatorOnGoogle enterSearchHitEnter(String value){
	
		textSearch.sendKeys(value);
		textSearch.sendKeys(Keys.RETURN);		
		return new VerifySearchingForCalculatorOnGoogle();
	}
	
	public String getPageTitle()	{
		return driver.getTitle();
	}
	
}
