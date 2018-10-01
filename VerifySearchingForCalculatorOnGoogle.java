package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class VerifySearchingForCalculatorOnGoogle extends TestBase {
	
	public VerifySearchingForCalculatorOnGoogle()	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='cwbt06']")
	WebElement allClear;
	
	@FindBy(xpath="//div[@id='cwbt43']")
	WebElement numberZero;
	
	@FindBy(xpath="//div[@id='cwbt33']")
	WebElement numberOne;
	
	@FindBy(xpath="//div[@id='cwbt34']")
	WebElement numberTwo;
	
	@FindBy(xpath="//div[@id='cwbt35']")
	WebElement numberThree;
	
	@FindBy(xpath="//div[@id='cwbt23']")
	WebElement numberFour;
	
	@FindBy(xpath="//div[@id='cwbt24']")
	WebElement numberFive;
	
	@FindBy(xpath="//div[@id='cwbt25']")
	WebElement numberSix;
	
	@FindBy(xpath="//div[@id='cwbt13']")
	WebElement numberSeven;
	
	@FindBy(xpath="//div[@id='cwbt14']")
	WebElement numberEight;
	
	@FindBy(xpath="//div[@id='cwbt15']")
	WebElement numberNine;
	
	@FindBy(xpath="//div[@id='cwbt45']")
	WebElement signEquals;
	
	@FindBy(xpath="//div[@id='cwbt16']")
	WebElement signDivide;
	
	@FindBy(xpath="//div[@id='cwbt26']")
	WebElement signMultiply;
	
	@FindBy(xpath="//div[@id='cwbt36']")
	WebElement signSubtract;
	
	@FindBy(xpath="//div[@id='cwbt46']")
	WebElement signAdd;
	
	@FindBy(xpath="//div[@id='cwbt44']")
	WebElement signPoint;
	
	@FindBy(xpath="//div[@class='cwtlotc']")
	WebElement displayOutput;
	
	@FindBy(xpath="//span[@id='cwles']")
	WebElement displayHeader;
	
	@FindBy(xpath="//a[contains(text(),'info')]")
	WebElement linkMoreinfo;
	
	public String getPageTitle()	{
		return driver.getTitle();
	}
	
	public void clickOnAllClear ()	{
		allClear.click();
	}
	
	public String getButtonLabel()	{
		return allClear.getText();
	}
	
	public void clickOnSignPoint ()	{
		signPoint.click();
	}
	
	public void clickOnSignAdd ()	{
		signAdd.click();
	}
	
	public void clickOnSignSubtract ()	{
		signSubtract.click();
	}
	
	public void clickOnSignMultiply ()	{
		signMultiply.click();
	}
	
	public void clickOnSignDivide ()	{
		signDivide.click();
	}
	
	public void clickOnSignEquals ()	{
		signEquals.click();
	}
	
	public void clickOnNumberNine ()	{
		numberNine.click();
	}
	
	public void clickOnNumberEight ()	{
		numberEight.click();
	}
	
	public void clickOnNumberSeven ()	{
		numberSeven.click();
	}
	
	public void clickOnNumberSix ()	{
		numberSix.click();
	}
	
	public void clickOnNumberFive ()	{
		numberFive.click();
	}
	
	public void clickOnNumberFour ()	{
		numberFour.click();
	}
	
	public void clickOnNumberThree ()	{
		numberThree.click();
	}

	public void clickOnNumberTwo ()	{
		numberTwo.click();
	}
	
	public void clickOnNumberOne ()	{
		numberOne.click();
	}
	
	public void clickOnNumberZero ()	{
		numberZero.click();
	}
	
	public Double displayDoubleOutputValue()	{
		return Double.parseDouble(displayOutput.getText());
	}
	
	public String displayOutputValue()	{
		return displayOutput.getText();
	}
	
	public String displayHeaderValue()	{
		return displayHeader.getText();
	}
	
	public boolean linkMoreinfoIsDisplayed()	{
		return linkMoreinfo.isDisplayed();
	}
	
	public MoreInfoPage clickLinkMoreinfo()	{
		linkMoreinfo.click();
		return new MoreInfoPage();
	}
	
}
