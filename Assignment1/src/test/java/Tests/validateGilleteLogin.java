package Tests;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.gillete_de;
import pages.gillete_in;
import resources.base;

public class validateGilleteLogin extends base{


	WebDriver driver;
	gillete_in gillete1;
	gillete_de gillete2;


	@BeforeTest
	//@Parameters({"url"})
	public void initialize() throws IOException {
		driver =initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Gillete_url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider= "testLoginData")
	public void Logintest(String username, String password)
	{
		if(prop.getProperty("Gillete_url").contains("en")){

			driver.findElement(By.cssSelector("a[href*='login']")).click();
			driver.findElement(By.xpath("//input[contains(@data-key,'Email')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@data-key,'Password')]")).sendKeys(password);
			driver.findElement(By.cssSelector("input[type='submit']")).click();

		}else if(prop.getProperty("Gillete_url").contains("de")) {
			
			Actions a = new Actions(driver);
			WebElement ele = driver.findElement(By.cssSelector("span[class*=openAccount]"));
			a.moveToElement(ele).perform();
			driver.findElement(By.cssSelector("a[class*=sign-in] ")).click();
			driver.findElement(By.cssSelector("input#username")).sendKeys(username);
			driver.findElement(By.cssSelector("input#password")).sendKeys(password);	
			
			WebElement login = driver.findElement(By.cssSelector("button#login-submit"));	
			JavascriptExecutor executor = (JavascriptExecutor) driver;	
			executor.executeScript("arguments[0].click()", login);
			

		}
	}

	@DataProvider(name="testLoginData")
	public Object[][] testData()
	{
		return new Object[][] {
			{"bangaru@yahoo.com","pass1233"},
			{"bangaru@gmail.com","pass1243"}
		};
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}



}
