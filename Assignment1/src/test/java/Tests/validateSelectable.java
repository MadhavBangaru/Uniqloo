package Tests;

import org.testng.annotations.Test;

import pages.framePage;
import pages.selectablePage;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validateSelectable extends base{
	
	
	
	public WebDriver driver;
	selectablePage selectable;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("Selectable_url"));
		
	}
	
	@Test
	public void functionality() throws InterruptedException
	{
		selectable = new selectablePage(driver);
		selectable.funcionality();
		AssertJUnit.assertEquals("Sakinalium - Method Chaining", selectable.get_text("MethodChaining"));
	}
	@Test
	public void serialize() throws InterruptedException
	{
		selectable = new selectablePage(driver);
		selectable.serialize();
		AssertJUnit.assertEquals("Sakinalium - Extent Reports", selectable.get_text("ExtentReports"));
	}
	
	
	@AfterTest
	public void teardown(){
		driver.close();
	}	
}
