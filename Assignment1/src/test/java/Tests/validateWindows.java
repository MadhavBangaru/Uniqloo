package Tests;

import org.testng.annotations.Test;

import pages.alertPage;
import pages.windowPage;

import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validateWindows extends base{
	
	public WebDriver driver;
	windowPage window;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{	
		driver =initializeDriver();
		driver.get(prop.getProperty("Windows_url"));
	}
	
	@Test
	public void tabWindow() throws InterruptedException
	{
		window = new windowPage(driver);			
		window.clickTab();		
		window.openTabs(1);		
		AssertJUnit.assertEquals("sakinalium.in", window.tabTitile(1));	
		window.closeTab(1);
		window.openTabs(0);
	}
	
	@Test
	public void seperateWindow() throws InterruptedException
	{
		window = new windowPage(driver);			
		window.clickSeperate();		
		window.openTabs(1);		
		AssertJUnit.assertEquals("sakinalium.in", window.tabTitile(1));	
		window.closeTab(1);
		window.openTabs(0);
	}
	
	@Test 
	public void multipleWindow() throws InterruptedException
	{
		window = new windowPage(driver);			
		window.clickMultiple();		
		window.openTabs(1);		
		AssertJUnit.assertEquals("sakinalium.in", window.tabTitile(1));			
		window.openTabs(2);		
		AssertJUnit.assertEquals("Index", window.tabTitile(2));		
		window.closeTab(2);
		window.closeTab(1);
		window.openTabs(0);
	}
	
		
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
