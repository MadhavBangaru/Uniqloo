package Tests;

import org.testng.annotations.Test;

import pages.registerPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class validateRegister extends base{
	
	public WebDriver driver;
	registerPage report;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{

		driver =initializeDriver();
		driver.get(prop.getProperty("Report_url"));

	}
	
	@Test(priority =1)
	public void registerInitialDetails() throws IOException {

		report= new registerPage(driver);		
		report.get_first_name().sendKeys("Madhav");
		report.get_last_name().sendKeys("Bangari");
		report.get_adress().sendKeys("Wipro");
		report.set_email().sendKeys("madahv@gmail.com");
		report.get_phone().sendKeys("54");						
	}
	@Test(priority =2)
	public void registerSecondaryDetails() throws IOException {
		report.set_gender("Male");
		report.set_hobby("Cricket");
		report.select_language("English");
		report.set_skill("Java");
		report.set_country("India");
		report.select_country("ind");
	}
	@Test(priority =3)
	public void userDetails() throws IOException {
		report.set_DOB("1996 February 16");		
		report.set_password("paswword");
		report.confirm_pass("password");		
		report.submit().click();		
		report.upload_file("C:\\Users\\SaiMadhav\\Pictures\\funny.png");
		report.refresh().click();
	}
	
	

	@AfterTest
	public void teardown()
	{
		//driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{		

		return new Object[][] {
			{"Madhav","Bangaru","Wipro,Bangalore"},
			{"","",""}
		};
	}

}
