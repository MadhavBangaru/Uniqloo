package Tests;

import org.testng.annotations.Test;

import pages.framePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class validateFrames extends base{

	public WebDriver driver;
	framePage frame;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{	
		driver =initializeDriver();
		driver.get(prop.getProperty("Frames_url"));
	}
	
	@Test
	public void singleFrame() throws InterruptedException
	{
	
		frame = new framePage(driver);	
		frame.textbox1("Helloo");
	}
	
	/*@Test
	public void multipleFrame() throws InterruptedException
	{
		frame = new framePage(driver);			
		frame.textbox2("Helloo");
		driver.switchTo().defaultContent();
	}*/
	
	
	
		
	/*@AfterTest
	public void teardown() {
		driver.close();
	}*/
}
