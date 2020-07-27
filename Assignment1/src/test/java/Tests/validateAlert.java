package Tests;

import org.testng.annotations.Test;

import pages.alertPage;
import pages.registerPage;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validateAlert extends base{
	public WebDriver driver;
	alertPage alert;
	
	
		@BeforeTest
		public void initialize() throws IOException
		{	
			driver =initializeDriver();
			driver.get(prop.getProperty("Alerts_url"));
		}
		
		@Test
		public void AlertOKTab() throws InterruptedException
		{
			alert = new alertPage(driver);			
			alert.clickOnAlertOkTab();			
			AssertJUnit.assertEquals(alert.get_alertMessage(), "I am an alert box!");			
			alert.accept_alert();
		}
		
		@Test
		public void AlertOkandCancel() throws InterruptedException
		{
			alert = new alertPage(driver);			
			alert.clickOnAlertOkandCancelTab();			
					
			alert.dismiss_alert();
			AssertJUnit.assertEquals("You Pressed Cancel",alert.confirmMessage());
		}
		
		@Test
		public void AlertTextbox() throws InterruptedException
		{
			alert = new alertPage(driver);			
			alert.clickOnAlertTextbox();	
			
			alert.sendKeys_alert("Madhav");
			alert.accept_alert();
			AssertJUnit.assertEquals("Hello Madhav How are you today",alert.confirmMessage1());			
			
		}
		
		
		@AfterTest
		public void teardown()
		{
			driver.close();
		}
		
		
}
