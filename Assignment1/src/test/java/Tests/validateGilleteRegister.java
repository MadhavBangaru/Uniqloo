package Tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.gillete_de;
import pages.gillete_in;
import resources.base;

public class validateGilleteRegister extends base{


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

	@Test(dataProvider= "testRegisterData")
	public void Registertest(String firstname, String lastname,String email,String password,String confirm, 
			String Birthmonth, String birthyear, String zipcode, String response, String refer)
	{
		if(prop.getProperty("Gillete_url").contains("en"))
		{
			driver.findElement(By.cssSelector("a[href*='create']")).click();
			driver.findElement(By.xpath("//input[@data-key='firstName']")).sendKeys(firstname);;
			driver.findElement(By.xpath("//input[@data-key='lastName']")).sendKeys(lastname);
			driver.findElement(By.xpath("//input[@data-key='emailAddress']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@data-key='newPassword']")).sendKeys(password);
			driver.findElement(By.xpath("//input[contains(@name,'[confirm]')]")).sendKeys(confirm);
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();		
			driver.findElement(By.cssSelector("input[type='submit']")).click();

		}else if(prop.getProperty("Gillete_url").contains("de")){
			Actions a = new Actions(driver);
			WebElement ele = driver.findElement(By.cssSelector("span[class*=openAccount]"));
			a.moveToElement(ele).perform();
			driver.findElement(By.cssSelector("a[href*='Create']")).click();
			driver.findElement(By.cssSelector("input#customerName")).clear();
			driver.findElement(By.cssSelector("input#customerName")).sendKeys(firstname+" "+lastname);			
			driver.findElement(By.cssSelector("input#customerEmail")).clear();
			driver.findElement(By.cssSelector("input#customerEmail")).sendKeys(email);
			driver.findElement(By.cssSelector("input#confirmCustomerEmail")).clear();
			driver.findElement(By.cssSelector("input#confirmCustomerEmail")).sendKeys(email);
			driver.findElement(By.cssSelector("input#customerPassword")).clear();
			driver.findElement(By.cssSelector("input#customerPassword")).sendKeys(password);
			driver.findElement(By.cssSelector("input#confirmPassword")).clear();
			driver.findElement(By.cssSelector("input#confirmPassword")).sendKeys(password);
			driver.findElement(By.cssSelector("input#referrerCode")).clear();
			driver.findElement(By.cssSelector("input#referrerCode")).sendKeys(refer);
			
			/*List<WebElement> radio = driver.findElements(By.cssSelector("input[type=radio]"));
			
			for(int i=0;i<radio.size();i++) {
				
				WebElement r = radio.get(i);
				String text = r.getAttribute("value");
				System.out.println(text);
				if(text.equalsIgnoreCase(response)) {
					r.click();
					System.out.println(response);
				}
			}*/
			
			WebElement signup = driver.findElement(By.cssSelector("button[class*=SignUp]"));	
			JavascriptExecutor executor = (JavascriptExecutor) driver;	
			executor.executeScript("arguments[0].click()", signup);
			

		}

	}

	@DataProvider(name="testRegisterData")
	public Object[][] testData()
	{
		return new Object[][] {
			{"ulrich","neilson","neilson@wipro.com","pass123","pass123A","9","1996","500072","true","rr123"},
			{"mickel","nielson","micke1@wipro.com","pass1123","pass1123B","10","1997","500082","true","ee123"}
		};
	}



}
