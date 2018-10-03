# GoogleCalculatorTest
Verify Calculator functionality after searching on Google

TestBase.class
The above is a base class which reads the properties from config.properties to check URL and Browser.  It instantiates the right driver, sets the Window size/Clear Cookies and Timeouts.  Also, navigates to the Home page (https://www.google.com).

config.properties   -- Contains URL and Browser values

testng.xml  Right click on this to select Run As -> TestNG Suite.  Will execute all @Test methods

ExtentManager   - Use this if an ExtentReport need to be generated
Listener	implements ITestListener

All of the following extend the base class

InputCalculatorOnGoogleSearchHitEnter.java  --Page layer
VerifySearchingForCalculatorOnGoogle.java   --Page layer
MoreInfoPage.java   --Page layer

GoogleSearchCalculatorTest.java   --All test cases are contained in this
