package com.crm.qa.testcases;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.InputCalculatorOnGoogleSearchHitEnter;
import com.crm.qa.pages.MoreInfoPage;
import com.crm.qa.pages.VerifySearchingForCalculatorOnGoogle;

public class GoogleSearchCalculatorTest extends TestBase{

	InputCalculatorOnGoogleSearchHitEnter searchCalculator;
	VerifySearchingForCalculatorOnGoogle verifyCalculator;
	MoreInfoPage moreInfo;
	
	public GoogleSearchCalculatorTest()	{
		super();
	}
	/**
	 * Will search for Calculator On Google, verify Page Title and check if link More info Is Displayed below Calculator form
	 */
	@BeforeMethod
	public void setUp(){
		initialization();
		searchCalculator = new InputCalculatorOnGoogleSearchHitEnter();
		//Assert.assertEquals(searchCalculator.getPageTitle(), "New Tab");
		verifyCalculator = searchCalculator.enterSearchHitEnter("Calculator");
		Assert.assertEquals(verifyCalculator.getPageTitle(), "Calculator - Google Search");
		Assert.assertTrue(verifyCalculator.linkMoreinfoIsDisplayed());
	}
	/**
	 * Test to input a number, verify All Clear functionality and what is displayed on Output area
	 */
	@Test
	public void verifyDisplayOfInput() {
		verifyCalculator.clickOnNumberFive();
		Assert.assertEquals(verifyCalculator.getButtonLabel(), "CE");
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),"Ans = 0");
		verifyCalculator.clickOnAllClear();
		Assert.assertEquals(verifyCalculator.getButtonLabel(), "CE");
		verifyCalculator.clickOnNumberFive();
		verifyCalculator.clickOnSignEquals();
		Assert.assertEquals(verifyCalculator.getButtonLabel(), "AC");
		Assert.assertEquals(verifyCalculator.displayOutputValue(),"5");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),"5 =");
	}
	/**
	 * This method verifies the Result when an user clicks On Divide Sign by entering two numbers as an input
	 */
	@Test
	public void verifyDisplayOfResultDivide() {
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = "1";
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0 ";
		verifyCalculator.clickOnSignDivide();
		buildHeaderValue = buildHeaderValue + "\u00F7";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + " 5 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		long expectedResult = Math.floorDiv(10, 5);
		Assert.assertEquals(verifyCalculator.displayOutputValue(),String.format("%s", expectedResult));
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Multiply Sign by entering two numbers as an input
	 */
	@Test
	public void verifyDisplayOfResultMultiply()	{
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = "9";
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = buildHeaderValue + "9";
		verifyCalculator.clickOnNumberEight();
		buildHeaderValue = buildHeaderValue + "8 ";
		verifyCalculator.clickOnSignMultiply();
		buildHeaderValue = buildHeaderValue + "\u00D7";
		verifyCalculator.clickOnNumberFour();
		buildHeaderValue = buildHeaderValue + " 4";
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + "3 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		long expectedResult = Math.multiplyExact(998, 43);
		Assert.assertEquals(verifyCalculator.displayOutputValue(),String.format("%s", expectedResult));
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Subtract Sign by entering two numbers as an input
	 */
	@Test
	public void verifyDisplayOfResultSubtraction()	{
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberSeven();
		buildHeaderValue = "7";
		verifyCalculator.clickOnNumberSix();
		buildHeaderValue = buildHeaderValue + "6";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5 ";
		verifyCalculator.clickOnSignSubtract();
		buildHeaderValue = buildHeaderValue + "-";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + " 1";
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0";
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + "3 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		long expectedResult = Math.subtractExact(765, 103);
		Assert.assertEquals(verifyCalculator.displayOutputValue(),String.format("%s", expectedResult));
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Add Sign by entering two numbers as an input
	 */
	@Test
	public void verifyDisplayOfResultAddition()	{
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberSeven();
		buildHeaderValue = "7";
		verifyCalculator.clickOnNumberSix();
		buildHeaderValue = buildHeaderValue + "6";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2 ";
		verifyCalculator.clickOnSignAdd();
		buildHeaderValue = buildHeaderValue + "+";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + " 1";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2";
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + "3";
		verifyCalculator.clickOnNumberEight();
		buildHeaderValue = buildHeaderValue + "8 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		long expectedResult = Math.addExact(7652, 1238);
		Assert.assertEquals(verifyCalculator.displayOutputValue(),String.format("%s", expectedResult));
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies an user is able to view More info link and by clicking on it, navigates to the page.
	 */
	@Test
	public void verifyPageTitleLinkMoreinfo()	{
		moreInfo = verifyCalculator.clickLinkMoreinfo();
		Assert.assertEquals(moreInfo.getPageTitle(), "Manage calculator, unit converter & color codes - Google Search Help");
	}
	/**
	 * Test to input a decimal number and verify what is displayed on Output area
	 */
	@Test
	public void verifyDecimalInput()	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols( Locale.US );
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberSeven();
		buildHeaderValue = "7";
		verifyCalculator.clickOnNumberSix();
		buildHeaderValue = buildHeaderValue + "6";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2";
		Assert.assertEquals(verifyCalculator.displayDoubleOutputValue().toString(), buildHeaderValue);
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),"Ans = 0");
	}
	/**
	 * This method verifies the Result when an user clicks On Subtract Sign by entering two decimal numbers as an input
	 */
	@Test
	public void verifySubtractionResultOfDecimalInput()	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols( Locale.US );
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberSeven();
		buildHeaderValue = "7";
		verifyCalculator.clickOnNumberSix();
		buildHeaderValue = buildHeaderValue + "6";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2 ";
		verifyCalculator.clickOnSignSubtract();
		buildHeaderValue = buildHeaderValue + "-";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + " 1";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + "3";
		verifyCalculator.clickOnNumberEight();
		buildHeaderValue = buildHeaderValue + "8 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		Assert.assertEquals(verifyCalculator.displayDoubleOutputValue().toString(), "64.14");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Add Sign by entering two decimal numbers as an input
	 */
	@Test
	public void verifyAdditionResultOfDecimalInput()	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols( Locale.US );
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = "9";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2 ";
		verifyCalculator.clickOnSignAdd();
		buildHeaderValue = buildHeaderValue + "+";
		verifyCalculator.clickOnNumberFour();
		buildHeaderValue = buildHeaderValue + " 4";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + "1";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + "3";
		verifyCalculator.clickOnNumberEight();
		buildHeaderValue = buildHeaderValue + "8 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		Assert.assertEquals(verifyCalculator.displayDoubleOutputValue().toString(), "136.4");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Multiply Sign by entering two decimal numbers as an input
	 */
	@Test
	public void verifyMultiplicationResultOfDecimalInput()	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols( Locale.US );
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = "9";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2 ";
		verifyCalculator.clickOnSignMultiply();
		buildHeaderValue = buildHeaderValue + "\u00D7";
		verifyCalculator.clickOnNumberFour();
		buildHeaderValue = buildHeaderValue + " 4";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + "1";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + "3";
		verifyCalculator.clickOnNumberEight();
		buildHeaderValue = buildHeaderValue + "8 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		Assert.assertEquals(verifyCalculator.displayDoubleOutputValue().toString(), "3931.9276");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Divide Sign by entering two decimal numbers as an input
	 */
	@Test
	public void verifyDivisionResultOfDecimalInput()	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols( Locale.US );
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = "9";
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = buildHeaderValue + "9";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0";
		verifyCalculator.clickOnNumberNine();
		buildHeaderValue = buildHeaderValue + "9 ";
		verifyCalculator.clickOnSignDivide();
		buildHeaderValue = buildHeaderValue + "\u00F7";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + " 1";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + "1";
		verifyCalculator.clickOnSignPoint();
		buildHeaderValue = buildHeaderValue + dfs.getDecimalSeparator();
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0";
		verifyCalculator.clickOnNumberZero();
		buildHeaderValue = buildHeaderValue + "0 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		Assert.assertEquals(verifyCalculator.displayDoubleOutputValue().toString(), "9.00818181818");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Add and then Divide Sign by entering three numbers as an input
	 */
	@Test
	public void verifyDivisionAndAdditionResultOfDecimalOutput()	{
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberFour();
		buildHeaderValue = "4";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnNumberSix();
		buildHeaderValue = buildHeaderValue + "6 ";
		verifyCalculator.clickOnSignAdd();
		buildHeaderValue = buildHeaderValue + "+";
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + " 3";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + "1 ";
		verifyCalculator.clickOnSignDivide();
		buildHeaderValue = buildHeaderValue + "\u00F7";
		verifyCalculator.clickOnNumberSeven();
		buildHeaderValue = buildHeaderValue + " 7 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		Assert.assertEquals(verifyCalculator.displayDoubleOutputValue().toString(), "501.857142857");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * This method verifies the Result when an user clicks On Add and then Divide Sign by entering three numbers as an input
	 */
	@Test
	public void verifyMultiplicationAndSubtractionResult()	{
		String buildHeaderValue;
		verifyCalculator.clickOnAllClear();
		verifyCalculator.clickOnNumberFour();
		buildHeaderValue = "4";
		verifyCalculator.clickOnNumberFive();
		buildHeaderValue = buildHeaderValue + "5";
		verifyCalculator.clickOnNumberSix();
		buildHeaderValue = buildHeaderValue + "6 ";
		verifyCalculator.clickOnSignMultiply();
		buildHeaderValue = buildHeaderValue + "\u00D7";
		verifyCalculator.clickOnNumberThree();
		buildHeaderValue = buildHeaderValue + " 3";
		verifyCalculator.clickOnNumberTwo();
		buildHeaderValue = buildHeaderValue + "2";
		verifyCalculator.clickOnNumberOne();
		buildHeaderValue = buildHeaderValue + "1 ";
		verifyCalculator.clickOnSignSubtract();
		buildHeaderValue = buildHeaderValue + "-";
		verifyCalculator.clickOnNumberSeven();
		buildHeaderValue = buildHeaderValue + " 7 ";
		verifyCalculator.clickOnSignEquals();
		buildHeaderValue = buildHeaderValue + "=";
		Assert.assertEquals(verifyCalculator.displayOutputValue().toString(), "146369");
		// verify if Label displays correct content
		Assert.assertEquals(verifyCalculator.displayHeaderValue(),buildHeaderValue);
	}
	/**
	 * Closes the instance of the driver
	 */
	@AfterMethod
	public void tearDown()	{
		driver.close();
	}
}
