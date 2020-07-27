package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class selectablePage {
	
	WebDriver driver ;

	public selectablePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By defFunction = By.cssSelector("[href*='Default']");
	By serialize = By.cssSelector("[href*='Serialize']");
	
	
	By MethodChaining = By.xpath("//div[@id=\"Default\"]/ul/li[3]");
	By ExtentReports = By.xpath("//div[@id=\"Serialize\"]/ul/li[5]");
	
	public void funcionality()
	{
		driver.findElement(defFunction).click();
		driver.findElement(MethodChaining).click();
	}
	
	public String get_text(String str)
	{
		String a="";
		
		if(str.equalsIgnoreCase("MethodChaining")) 
			
			a= driver.findElement(MethodChaining).getText();
		else if (str.equalsIgnoreCase("ExtentReports"))
			a =  driver.findElement(ExtentReports).getText();
		
		return a;
		
	}

	public void serialize() {
		// TODO Auto-generated method stub
		
		driver.findElement(serialize).click();
		driver.findElement(ExtentReports).click();
	}
	
	
}
