package Tests;

import org.testng.annotations.Test;

import pages.alertPage;
import pages.datepickerPage;

import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validateDate extends base{


	WebDriver driver;
	datepickerPage date;

	

	@BeforeTest
	public void initialize() throws IOException
	{	
		driver =initializeDriver();
		
		driver.get(prop.getProperty("Datepicker_url"));
		
	}
	
	@Test
	public void disabledDP() throws InterruptedException
	{
		date = new datepickerPage(driver);			
		date.changeDisabledDate("09/12/2017");		
		
	}
	@Test
	public void activeDP() throws InterruptedException
	{
		date = new datepickerPage(driver);			
		date.changeActiveDate("09/12/2017");		
		AssertJUnit.assertEquals("09/12/2017", date.get_activeDate());
		
	}
	
	
	
}
