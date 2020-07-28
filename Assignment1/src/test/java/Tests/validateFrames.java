package Tests;

import org.testng.annotations.Test;

import pages.framePage;

import java.io.IOException;

import org.openqa.selenium.By;
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
	
	@Test(priority=1)
	public void singleFrame() throws InterruptedException
	{
	
		//frame = new framePage(driver);	
		//frame.textbox1("Helloo");
		driver.findElement(By.cssSelector("[href*=Single]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Single']/iframe")));		
		driver.findElement(By.cssSelector("input[type=text]")).sendKeys("Hello");
		driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = {"singleFrame"})
	public void multipleFrame() throws InterruptedException
	{
		driver.findElement(By.cssSelector("[href*=Multiple]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Multiple']/iframe")));		
		driver.switchTo().frame(0);		
		driver.findElement(By.cssSelector("input[type=text]")).sendKeys("Hello");
		driver.switchTo().defaultContent();
	}
	
	
	
		
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
